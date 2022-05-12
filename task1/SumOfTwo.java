import java.util.*;

public class SumOfTwo {
    public static List<Integer> sumOfTwo(LinkedList list1, LinkedList list2) {
        List<Integer> list = new ArrayList<>();
        if (list1.count() != list2.count()) {
            return list;
        }
        Node node1 = list1.head;
        Node node2 = list2.head;
        while (node1 != null) {
            list.add(node1.value + node2.value);
            node1 = node1.next;
            node2 = node2.next;
        }
        return list;
    }
}
