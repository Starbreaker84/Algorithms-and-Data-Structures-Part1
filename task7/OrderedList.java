import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1 instanceof Integer && v2 instanceof Integer){
            if ((Integer) v1 < (Integer) v2) return -1;
            if ((Integer) v1 > (Integer) v2) return 1;
        }
        if (v1 instanceof String && v2 instanceof String){
            String str1 = ((String) v1).trim();
            String str2 = ((String) v2).trim();
            if (str1.compareTo(str2) > 0) return 1;
            if (str1.compareTo(str2) < 0) return -1;
        }
        return 0;
    }

    public void add(T value) {
        Node node = this.head;
        int comp = -1;
        if (_ascending) comp = 1;
        boolean match = false;
        while (node != null && !match) {
            if (node.prev != null && compare((T) node.value, value) == comp) {
                Node item = new Node(value);
                node.prev.next = item;
                item.prev = node.prev;
                item.next = node;
                node.prev = item;
                match = true;
            }
            if (node.prev == null && compare((T) node.value, value) == comp) {
                Node item = new Node(value);
                head = item;
                head.next = node;
                node.prev = head;
                match = true;
            }
            node = node.next;
        }
        if (!match && this.head != null){
            Node item = new Node(value);
            node = this.tail;
            node.next = item;
            item.prev = node;
            this.tail = item;
        }
        if (this.head == null) {
            Node item = new Node(value);
            this.head = item;
            this.tail = item;
        }
    }

    public Node<T> find(T val) {
        Node node = this.head;
        int comp = -1;
        if (_ascending) comp = 1;
        while (node != null){
            if (compare((T) node.value, val) == comp) return null;
            if (compare((T) node.value, val) == 0) return node;
            node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        Node node = this.head;
        int comp = -1;
        if (_ascending) comp = 1;
        boolean match = false;
        while (node != null && !match){
            if (compare((T) node.value, val) == comp) break;
            if (compare((T) node.value, val) != 0) {
                node = node.next;
                continue;
            }
            match = true;
            if (node.prev == null && node.next == null){
                this.head = null;
                this.tail = null;
            }
            if (node.prev == null && node.next != null){
                this.head = node.next;
                this.head.prev = null;
            }
            if (node.prev != null && node.next == null){
                this.tail = node.prev;
                this.tail.next = null;
            }
            if (node.prev != null && node.next != null){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

     ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
