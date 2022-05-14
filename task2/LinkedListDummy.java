import java.util.*;

public class LinkedListDummy {
    private final Node head;
    private final Node tail;

    public LinkedListDummy(){
        this.head = new Dummy(0);
        this.tail = new Dummy(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public Node getHead(){
        if (this.head.next == this.tail) return null;
        return this.head.next;
    }

    public Node getTail(){
        if (this.tail.prev == this.head) return null;
        return this.tail.prev;
    }
    public void addInTail(Node item) {
        this.tail.prev.next = item;
        item.prev = this.tail.prev;
        item.next = this.tail;
        this.tail.prev = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value && !(node instanceof Dummy)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public List<Node> findAll(int value){
        List<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == value && !(node instanceof Dummy)){
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
            if (node.value != _value || node instanceof Dummy){
                node = node.next;
                continue;
            }
            match = true;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return match;
    }

    public void removeAll(int _value){
        Node node = this.head;
        while (node != null){
            if (node.value != _value || node instanceof Dummy){
                node = node.next;
                continue;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = node.next;
        }
    }

    public void clear(){
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int count(){
        Node node = this.head;
        int counter = 0;
        while (node != null){
            if (!(node instanceof Dummy))counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert){
        Node node = this.head;
        boolean match = false;
        while (node != null && !match) {
            if (node == _nodeAfter && !(node instanceof Dummy) || _nodeAfter == null) {
                _nodeToInsert.prev = node;
                _nodeToInsert.next = node.next;
                node.next.prev = _nodeToInsert;
                node.next = _nodeToInsert;
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

class Dummy extends Node {

    public Dummy(int _value){
        super( _value);
        this.next = null;
        this.prev = null;
    }
}
