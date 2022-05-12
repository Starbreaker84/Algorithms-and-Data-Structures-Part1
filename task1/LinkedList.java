import java.util.*;

public class LinkedList{
    public Node head;
    public Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null){
            if (node.value == _value){
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value){
        if (this.head == null) return false;
        Node node = head;
        Node temp = null;
        boolean match = false;
        while (node != null && !match){
            if (node.value != _value) {
                temp = node;
                node = node.next;
                continue;
            }
            match = true;
            if (temp == null) {
                node = node.next;
                this.head = node;

            }
            if (temp != null) {
                temp.next = node.next;
                node = node.next;
            }

        }
        if (temp == null){
            this.tail = null;
        }
        if (temp != null && temp.next == null) {
            this.tail = temp;
        }
        return match;
    }

    public void removeAll(int _value){
        Node node = this.head;
        Node temp = null;
        while (node != null){
            if (node.value != _value) {
                temp = node;
                node = node.next;
                continue;
            }
            if (temp == null) {
                node = node.next;
                this.head = node;
            }
            if (temp != null) {
                temp.next = node.next;
                node = node.next;
            }

        }
        if (temp == null){
            this.tail = null;
        }
        if (temp != null && temp.next == null) {
            this.tail = temp;
        }
    }

    public void clear(){
        this.head = null;
        this.tail = null;
    }

    public int count(){
        Node node = this.head;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert){
        Node node = this.head;
        boolean match = false;
        while (node != null && !match && _nodeAfter != null) {
            if (node != _nodeAfter) {
                node = node.next;
                continue;
            }
            match = true;
        }
        if (_nodeAfter == null && this.head != null){
            node = this.head;
            this.head = _nodeToInsert;
            this.head.next = node;
        }
        if (_nodeAfter == null && this.head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        }
        if (match && node.next != null){
            Node link = node.next;
            node.next = _nodeToInsert;
            node = node.next;
            node.next = link;
        }
        if (match && node.next == null){
            node.next = _nodeToInsert;
            node = node.next;
            node.next = null;
            this.tail = node;
        }
    }

}

class Node {
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
