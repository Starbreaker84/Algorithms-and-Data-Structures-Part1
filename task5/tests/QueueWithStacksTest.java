import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueWithStacksTest {
    
    @Test
    void enqueue(){
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(3);
        queue.enqueue(5);
        assertEquals(2, queue.size());
        assertEquals(3, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        assertEquals(3, queue.size());
    }
}
