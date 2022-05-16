import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    @Test
    void initial(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        assertEquals(16, array.capacity);
        assertEquals(0, array.count);
        assertNull(array.array[0]);
        assertNull(array.array[15]);
    }

    @Test
    void getItem_exceptionInEmpty() throws IndexOutOfBoundsException{
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        try{
            int index = 0;
            int item = array.getItem(index);
            fail("Test getItem_exception is fail!");
        } catch (Exception ex) {
            assertEquals(IndexOutOfBoundsException.class, ex.getClass());
        }
    }

    @Test
    void getItem_exceptionInNormal() throws IndexOutOfBoundsException{
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.append(10);
        array.append(12);
        array.append(30);
        try{
            int index = 3;
            int item = array.getItem(index);
            fail("Test getItem_exception is fail!");
        } catch (Exception ex) {
            assertEquals(IndexOutOfBoundsException.class, ex.getClass());
        }
    }

    @Test
    void getItem_normal() throws IndexOutOfBoundsException{
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        array.append(10);
        array.append(12);
        array.append(30);

        assertEquals(10, array.getItem(0));
        assertEquals(12, array.getItem(1));
        assertEquals(30, array.getItem(2));
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
        assertNull(array.array[3]);
    }

    @Test
    void append_head(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);

        array.append(35);
        assertEquals(16, array.capacity);
        assertEquals(1, array.count);
        assertEquals(35, array.array[0]);
    }

    @Test
    void append_manyElements(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);

        for (int i = 0; i < 10; i++){
            array.append(12);
        }
        assertEquals(16, array.capacity);
        assertEquals(10, array.count);
        assertEquals(12, array.array[5]);
    }

    @Test
    void append_doubleCap(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++){
            array.append(12);
        }

        assertEquals(16, array.capacity);
        assertEquals(16, array.count);
        array.append(12);
        assertEquals(32, array.capacity);
        assertEquals(17, array.count);
        assertEquals(12, array.array[16]);
        assertNull(array.array[17]);
    }

    @Test
    void insert_tail(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }

        array.insert(15, 4);
        assertEquals(5, array.count);
        assertEquals(16, array.capacity);
        assertEquals(12, array.array[3]);
        assertEquals(15, array.array[4]);
        assertNull(array.array[5]);
    }

    @Test
    void insert_head(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }

        array.insert(15, 0);
        assertEquals(5, array.count);
        assertEquals(16, array.capacity);
        assertEquals(12, array.array[3]);
        assertEquals(15, array.array[0]);
    }

    @Test
    void insert_headInEmpty(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);

        array.insert(15, 0);
        assertEquals(1, array.count);
        assertEquals(16, array.capacity);
        assertEquals(15, array.array[0]);
    }

    @Test
    void insert(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }

        array.insert(15, 2);
        assertEquals(5, array.count);
        assertEquals(16, array.capacity);
        assertEquals(12, array.array[3]);
        assertEquals(15, array.array[2]);
        assertNull(array.array[5]);
    }

    @Test
    void insert_doubleCap(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++){
            array.append(12);
        }

        array.insert(15, 4);

        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        assertEquals(12, array.array[16]);
        assertEquals(15, array.array[4]);
    }

    @Test
    void insert_exception(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }

        try{
            array.insert(15, 5);
            fail("Test insert is fail!");
        } catch (Exception ex) {
            assertEquals(IndexOutOfBoundsException.class, ex.getClass());
        }
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    void remove_normal(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }
        array.append(15);

        array.remove(4);
        assertEquals(4, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    void remove_exception(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 4; i++){
            array.append(12);
        }
        array.append(15);

        try{
            array.remove(5);
            fail("Test insert is fail!");
        } catch (Exception ex) {
            assertEquals(IndexOutOfBoundsException.class, ex.getClass());
        }
    }

    @Test
    void remove_decrease(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        Random random = new Random();
        for (int i = 0; i < 17; i++){
            array.append(random.nextInt(10));
        }

        assertEquals(32, array.capacity);
        assertEquals(17, array.count);

        array.remove(16);
        array.remove(15);

        assertEquals(21, array.capacity);
        assertEquals(15, array.count);

        for (int i = 14; i > 9; i--){
            array.remove(i);
        }

        assertEquals(10, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    void insertAndRemove(){
        DynArray<Integer> array = new DynArray<Integer>(Integer.class);
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            array.append(random.nextInt(10));
        }

        assertEquals(16, array.capacity);
        assertEquals(5, array.count);

        array.remove(3);

        assertEquals(16, array.capacity);
        assertEquals(4, array.count);
    }
}
