package LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static LinkedList.SumOfTwo.sumOfTwo;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList list = new LinkedList();
    Node n1 = new Node(12);
    Node n2 = new Node(55);
    Node n3 = new Node(28);
    Node n4 = new Node(12);
    Node n5 = new Node(13);
    Node n6 = new Node(55);
    Node n7 = new Node(28);

    @Test
    void findAllTest_3items_0matchArray(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes, list.findAll(58));
    }

    @Test
    void findAllTest_0items_0matchArray(){
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes, list.findAll(12));
    }

    @Test
    void findAllTest_7items_2matchArrayHeadAndBody(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n4);
        assertEquals(nodes, list.findAll(12));
    }

    @Test
    void findAllTest_7items_2matchArrayBodyAndTail(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(n3);
        nodes.add(n7);
        assertEquals(nodes, list.findAll(28));
    }

    @Test
    void findAllTest_7items_1matchArray(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(n5);
        assertEquals(nodes, list.findAll(13));
    }

    @Test
    void count_empty(){
        assertEquals(0, list.count());

    }

    @Test
    void count_one(){
        list.addInTail(n1);
        assertEquals(1, list.count());
    }

    @Test
    void count_many(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertEquals(3, list.count());
    }

    @Test
    void clear(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertEquals(n1, list.head);
        assertEquals(n3, list.tail);
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void remove_empty(){
        assertFalse(list.remove(52));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void remove_1item_true(){
        list.addInTail(n1);
        assertTrue(list.remove(12));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void remove_1item_false(){
        list.addInTail(n2);
        assertFalse(list.remove(12));
        assertEquals(n2, list.head);
        assertEquals(n2, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void remove_3item_true_head(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n4);
        assertTrue(list.remove(12));
        assertEquals(n2, list.head);
        assertEquals(n4, list.tail);
        assertNull(list.tail.next);

    }

    @Test
    void remove_3item_true_tail(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertTrue(list.remove(28));
        assertEquals(n1, list.head);
        assertEquals(n2, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void remove_3item_true_body(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertTrue(list.remove(55));
        assertEquals(n1, list.head);
        assertEquals(n3, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void remove_2item_true_head(){
        list.addInTail(n1);
        list.addInTail(n2);
        assertTrue(list.remove(12));
        assertEquals(n2, list.head);
        assertEquals(n2, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void remove_2item_true_tail(){
        list.addInTail(n1);
        list.addInTail(n2);
        assertTrue(list.remove(55));
        assertEquals(n1, list.head);
        assertEquals(n1, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void remove_3item_false(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n4);
        assertFalse(list.remove(49));
        assertEquals(n1, list.head);
        assertEquals(n4, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_empty(){
        list.removeAll(12);
        assertEquals(0, list.count());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll_all(){
        list.addInTail(n1);
        list.addInTail(n4);
        list.removeAll(12);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll_2items(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        list.removeAll(12);
        assertEquals(5, list.count());
        assertEquals(n2, list.head);
        assertEquals(n7, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_7itemsAll(){
        list.addInTail(n1);
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.addInTail(n4);
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.removeAll(12);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll_7itemsOneBody(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        list.removeAll(13);
        assertEquals(6, list.count());
        assertEquals(n1, list.head);
        assertEquals(n7, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_7itemsHeadBody(){
        list.addInTail(n1);
        list.addInTail(new Node(46));
        list.addInTail(new Node(46));
        list.addInTail(new Node(46));
        list.addInTail(new Node(46));
        list.addInTail(new Node(46));
        list.addInTail(n7);
        list.removeAll(46);
        assertEquals(2, list.count());
        assertEquals(n1, list.head);
        assertEquals(n7, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_2items_tail(){
        list.addInTail(n1);
        list.addInTail(n4);
        list.addInTail(n3);
        list.removeAll(12);
        assertEquals(n3, list.head);
        assertEquals(n3, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_2items_head(){
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n1);
        list.removeAll(12);
        assertEquals(n3, list.head);
        assertEquals(n3, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_head(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.removeAll(12);
        assertEquals(n2, list.head);
        assertEquals(n2, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void removeAll_tail(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.removeAll(55);
        assertEquals(n1, list.head);
        assertEquals(n1, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfter_regression(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n3, n5);
        assertEquals(5, list.count());
        Node node = list.head;
        int counter = 0;
        while (counter < 3) {
            node = node.next;
            counter++;
        }
        assertEquals(n5, node);
        assertEquals(n1, list.head);
        assertEquals(n4, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfter_tail() {
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n4, n5);
        assertEquals(n1, list.head);
        assertEquals(n5, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfter_noMatch(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n6, n5);
        assertEquals(4, list.count());
        assertEquals(n1, list.head);
        assertEquals(n4, list.tail);
    }

    @Test
    void insertAfter_empty(){
        list.insertAfter(n3, n5);
        assertEquals(0, list.count());
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void insertAfter_null_empty(){
        list.insertAfter(null, n5);
        assertEquals(1, list.count());
        assertEquals(n5, list.head);
        assertEquals(n5, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void insertAfter_regression_null(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(null, n5);
        assertEquals(5, list.count());
        assertEquals(n5, list.head);
        assertEquals(n4, list.tail);
        assertNull(list.tail.next);
    }

    @Test
    void SumOfTwoTest_true(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        List<Integer> list = new ArrayList<>();
        list1.addInTail(new Node(12));
        list1.addInTail(new Node(13));
        list1.addInTail(new Node(35));
        list2.addInTail(new Node(12));
        list2.addInTail(new Node(36));
        list2.addInTail(new Node(137));
        list.add(24);
        list.add(49);
        list.add(172);
        assertEquals(list, sumOfTwo(list1, list2));
    }

    @Test
    void SumOfTwoTest_false(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        List<Integer> list = new ArrayList<>();
        list1.addInTail(new Node(12));
        list1.addInTail(new Node(13));
        list1.addInTail(new Node(35));
        list2.addInTail(new Node(12));
        list2.addInTail(new Node(36));
        assertEquals(list, sumOfTwo(list1, list2));
    }

    @Test
    void SumOfTwoTest_empty(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        List<Integer> list = new ArrayList<>();
        assertEquals(list, sumOfTwo(list1, list2));
    }
}