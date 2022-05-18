import org.junit.jupiter.api.Test;
import static Queue.Rotator.rotation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RotatorTest {
    
    @Test
    void rotation_normal(){
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
        }
        rotation(3, queue);
        assertEquals(10, queue.size());
        assertEquals(3, queue.qu.get(0));
        assertEquals(2, queue.qu.get(9));
    }

    @Test
    void rotation_null(){
        Queue<Integer> queue = new Queue<Integer>();
        rotation(3, queue);
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }
}
