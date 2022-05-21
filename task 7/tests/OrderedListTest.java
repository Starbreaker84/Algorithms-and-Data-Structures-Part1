import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class OrderedListTest {

    private static List<Integer> toArray(OrderedList list){
        List<Integer> intList = new ArrayList<>();
        Node item = list.head;
        while (item != null) {
            intList.add((Integer) item.value);
            item = item.next;
        }
        return intList;
    }

    @Test
    void compare(){
        OrderedList list = new OrderedList(false);
        assertEquals(1, list.compare(3, 2));
        assertEquals(-1, list.compare(5, 6));
        assertEquals(0, list.compare(3, 3));
        assertEquals(1, list.compare("abc", "ab"));
        assertEquals(1, list.compare(" abc ", "ab"));
        assertEquals(-1, list.compare("a", " aaa "));
        assertEquals(0, list.compare("abc", "abc"));
    }

    @Test
    void add_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(3);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        assertEquals(numbers, toArray(list));
    }

    @Test
    void add_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5);

        assertEquals(numbers, toArray(list));
    }

    @Test
    void find_empty_null(){
        OrderedList list1 = new OrderedList(true);
        OrderedList list2 = new OrderedList(false);
        assertNull(list1.find(1));
        assertNull(list2.find(1));
    }

    @Test
    void find_null_smaller_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertNull(list.find(1));
    }

    @Test
    void find_null_bigger_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertNull(list.find(6));
    }

    @Test
    void find_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertEquals(3, list.find(3).value);
    }

    @Test
    void find_null_smaller_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertNull(list.find(1));
    }

    @Test
    void find_null_bigger_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertNull(list.find(6));
    }

    @Test
    void find_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        assertEquals(3, list.find(3).value);
    }

    @Test
    void remove_two_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        
        list.delete(3);
        assertEquals(1, list.count());
        assertEquals(5, list.head.value);
    }

    @Test
    void remove_two_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);

        list.delete(5);
        assertEquals(1, list.count());
        assertEquals(3, list.head.value);
    }

    @Test
    void remove_oneToEmpty(){
        OrderedList list = new OrderedList(true);
        list.add(5);

        list.delete(5);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void remove_empty(){
        OrderedList list1 = new OrderedList(true);
        OrderedList list2 = new OrderedList(false);
        list1.delete(5);
        list2.delete(5);
        assertEquals(0, list1.count());
        assertEquals(0, list2.count());
    }

    @Test
    void remove_smaller_null_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(1);
        assertEquals(3, list.count());
    }

    @Test
    void remove_bigger_null_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(6);
        assertEquals(3, list.count());
    }

    @Test
    void remove_head_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(2);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        assertEquals(2, list.count());
        assertEquals(numbers, toArray(list));
    }

    @Test
    void remove_tail_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(5);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        assertEquals(2, list.count());
        assertEquals(numbers, toArray(list));
    }

    @Test
    void remove_body_ascending(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(2);

        list.delete(3);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        assertEquals(3, list.count());
        assertEquals(numbers, toArray(list));
    }

    @Test
    void remove_smaller_null_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(1);
        assertEquals(3, list.count());
    }

    @Test
    void remove_bigger_null_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(6);
        assertEquals(3, list.count());
    }

    @Test
    void remove_head_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(5);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        assertEquals(2, list.count());
        assertEquals(numbers, toArray(list));
        //Начало печати
        print(list);
        //Конец печати
    }

    @Test
    void remove_tail_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);
        list.add(2);

        list.delete(2);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        assertEquals(2, list.count());
        assertEquals(numbers, toArray(list));
    }

    @Test
    void remove_body_descending(){
        OrderedList list = new OrderedList(false);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(2);
 
        list.delete(3);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        assertEquals(3, list.count());
        assertEquals(numbers, toArray(list));
    }

    @Test
    void clear(){
        OrderedList list = new OrderedList(true);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(2);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
        assertEquals(numbers, toArray(list));
        list.clear(false);
        list.add(5);
        list.add(3);
        list.add(3);
        list.add(2);
        numbers.clear();
        numbers.add(5);
        numbers.add(3);
        numbers.add(3);
        numbers.add(2);
        assertEquals(numbers, toArray(list));
    }
}
