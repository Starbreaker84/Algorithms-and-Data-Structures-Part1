import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2(){
        head = null;
        tail = null;
    }

    public void addInTail(Node _item){
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value){
        Node node = this.head;
        while (node != null) {
            if (node.value == _value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value){
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value){
        Node node = this.head;
        boolean match = false;
        while (node != null && !match){
            if (node.value != _value){
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
        return match;
    }

    public void removeAll(int _value){
        Node node = this.head;
        while (node != null){
            if (node.value != _value){
                node = node.next;
                continue;
            }
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
            node = node.next;
        }
    }

    public void clear(){
        this.head = null;
        this.tail = null;
    }

    public int count(){
        Node node = this.head;
        int counter = 0;
        while (node != null){
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert){
        Node node = this.head;
        if (_nodeAfter == null && node == null){
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            node = null;
        }
        if (_nodeAfter == null && node != null){
            this.head = _nodeToInsert;
            this.head.next = node;
            node.prev = this.head;
            node = null;
        }
        Boolean match = false;
        while (node != null && !match){
            if (node == _nodeAfter && node.next != null){
                node.next.prev = _nodeToInsert;
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
                _nodeToInsert.prev = node;
                match = true;

            }
            if (node == _nodeAfter && node.next == null){
                this.tail = _nodeToInsert;
                node.next = this.tail;
                this.tail.prev = node;
                match = true;
            }
            node = node.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value){
        value = _value;
        next = null;
        prev = null;
    }
}
