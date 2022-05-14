import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    private static List<Integer> toArray(LinkedList2 list){
        List<Integer> intList = new ArrayList<>();
        Node item = list.head;
        while (item != null) {
            intList.add(item.value);
            item = item.next;
        }
        return intList;
    }

    private static List<Integer> toArrayReverse(LinkedList2 list) {
        List<Integer> intList = new ArrayList<>();
        Node item = list.tail;
        while (item != null) {
            intList.add(item.value);
            item = item.prev;
        }
        return intList;
    }

    LinkedList2 list = new LinkedList2();
    Node n1 = new Node(12);
    Node n2 = new Node(55);
    Node n3 = new Node(28);
    Node n4 = new Node(12);
    Node n5 = new Node(13);
    Node n6 = new Node(55);

    @Test
    void findTest_true(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        assertEquals(n5, list.find(13));
    }

    @Test
    void findTest_false(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        assertNull(list.find(152));
    }

    @Test
    void findTest_emptyList(){
        assertNull(list.find(152));
    }

    @Test
    void findAllTest_true(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n4);
        assertEquals(nodes, list.findAll(12));
    }

    @Test
    void findAllTest_false(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes, list.findAll(152));
    }

    @Test
    void findAllTest_empty(){
        ArrayList<Node> nodes = new ArrayList<>();
        assertEquals(nodes, list.findAll(152));
    }

    @Test
    void removeTest_one(){
        list.addInTail(n1);
        assertTrue(list.remove(12));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeTest_only_head(){
        list.addInTail(n1);
        list.addInTail(n2);
        assertTrue(list.remove(12));
        assertEquals(n2, list.head);
        assertEquals(n2, list.tail);
    }

    @Test
    void removeTest_only_tail(){
        list.addInTail(n1);
        list.addInTail(n2);
        assertTrue(list.remove(55));
        assertEquals(n1, list.head);
        assertEquals(n1, list.tail);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void removeTest_middle(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertTrue(list.remove(55));
        List<Integer> array = new ArrayList<>(2);
        array.add(12);
        array.add(28);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(28);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void removeTest_false(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        assertFalse(list.remove(152));
    }

    @Test
    void removeTest_regression(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        assertTrue(list.remove(13));
        List<Integer> array = new ArrayList<>(5);
        array.add(12);
        array.add(55);
        array.add(28);
        array.add(12);
        array.add(55);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(55);
        array.add(12);
        array.add(28);
        array.add(55);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void removeTest_empty(){
        assertFalse(list.remove(13));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllTest_allTrue(){
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.addInTail(new Node(12));
        list.removeAll(12);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAll_removeOnlyHead(){
        list.addInTail(new Node(10));
        list.addInTail(new Node(11));
        list.addInTail(new Node(12));
        list.addInTail(new Node(13));
        list.removeAll(10);
        List<Integer> array = new ArrayList<>(3);
        array.add(11);
        array.add(12);
        array.add(13);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(13);
        array.add(12);
        array.add(11);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void removeAll_removeOnlyTail(){
        list.addInTail(new Node(10));
        list.addInTail(new Node(11));
        list.addInTail(new Node(12));
        list.addInTail(new Node(13));
        list.removeAll(13);
        List<Integer> array = new ArrayList<>(3);
        array.add(10);
        array.add(11);
        array.add(12);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(12);
        array.add(11);
        array.add(10);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void removeAll_leaveOnlyHead(){
        list.addInTail(new Node(10));
        list.addInTail(new Node(11));
        list.addInTail(new Node(11));
        list.addInTail(new Node(11));
        list.removeAll(11);
        assertEquals(list.head, list.tail);
    }

    @Test
    void removeAll_leaveOnlyTail(){
        list.addInTail(new Node(11));
        list.addInTail(new Node(11));
        list.addInTail(new Node(11));
        list.addInTail(new Node(10));
        list.removeAll(11);
        assertEquals(list.head, list.tail);
    }

    @Test
    void removeAll_body(){
        list.addInTail(new Node(11));
        list.addInTail(new Node(10));
        list.addInTail(new Node(12));
        list.addInTail(new Node(10));
        list.addInTail(new Node(13));
        list.removeAll(10);
        List<Integer> array = new ArrayList<>(3);
        array.add(11);
        array.add(12);
        array.add(13);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(13);
        array.add(12);
        array.add(11);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void removeAll_noMatch(){
        list.addInTail(new Node(11));
        list.addInTail(new Node(12));
        list.addInTail(new Node(13));
        list.removeAll(15);
        List<Integer> array = new ArrayList<>(3);
        array.add(11);
        array.add(12);
        array.add(13);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(13);
        array.add(12);
        array.add(11);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void clearTest(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        assertEquals(n1, list.head);
        assertEquals(n6, list.tail);
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void countTest_many(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        assertEquals(6, list.count());
    }

    @Test
    void countTest_one(){
        list.addInTail(n1);
        assertEquals(1, list.count());
    }

    @Test
    void countTest_empty(){
        assertEquals(0, list.count());
    }

    @Test
    void insertAfterTest_head(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n1, n5);
        List<Integer> array = new ArrayList<>(5);
        array.add(12);
        array.add(13);
        array.add(55);
        array.add(28);
        array.add(12);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(12);
        array.add(28);
        array.add(55);
        array.add(13);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void insertAfterTest_tail(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n4, n5);
        List<Integer> array = new ArrayList<>(5);
        array.add(12);
        array.add(55);
        array.add(28);
        array.add(12);
        array.add(13);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(13);
        array.add(12);
        array.add(28);
        array.add(55);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void insertAfterTest_body(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.insertAfter(n3, n5);
        List<Integer> array = new ArrayList<>(5);
        array.add(12);
        array.add(55);
        array.add(28);
        array.add(13);
        array.add(12);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(12);
        array.add(13);
        array.add(28);
        array.add(55);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void insertAfterTest_nullWithEmptyList(){
        list.insertAfter(null, n5);
        assertEquals(n5, list.head);
        assertEquals(list.head, list.tail);
    }

    @Test
    void insertAfterTest_nullWithNoEmptyList(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.insertAfter(null, n5);
        List<Integer> array = new ArrayList<>(4);
        array.add(13);
        array.add(12);
        array.add(55);
        array.add(28);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(28);
        array.add(55);
        array.add(12);
        array.add(13);
        assertEquals(array, toArrayReverse(list));
    }

    @Test
    void insertAfterTest_NoMatch(){
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.insertAfter(n4, n5);
        List<Integer> array = new ArrayList<>(3);
        array.add(12);
        array.add(55);
        array.add(28);
        assertEquals(array, toArray(list));
        array.clear();
        array.add(28);
        array.add(55);
        array.add(12);
        assertEquals(array, toArrayReverse(list));
    }
}
