import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    
    @Test
    void enqueue_enqueue(){
        Queue<Integer> qu = new Queue<Integer>();
        for (int i = 0; i < 10; i++){
            qu.enqueue(i);
        }
        assertEquals(0, qu.qu.get(0));
        assertEquals(9, qu.qu.get(9));
        assertEquals(10, qu.size());
    }

    @Test
    void enqueue_dequeue(){
        Queue<Integer> qu = new Queue<Integer>();
        for (int i = 0; i < 10; i++){
            qu.enqueue(i);
        }
        assertEquals(0, qu.dequeue());
        assertEquals(1, qu.dequeue());
        assertEquals(2, qu.qu.get(0));
        assertEquals(3, qu.qu.get(1));
        assertEquals(8, qu.size());
    }

    @Test
    void enqueue_dequeue_null(){
        Queue<Integer> qu = new Queue<Integer>();
        assertNull(qu.dequeue());
    }
}
