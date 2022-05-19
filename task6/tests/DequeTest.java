import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    @Test
    void addTail(){
        Random random = new Random();
        Deque deque = new Deque();
        for (int i = 0; i < 10; i++){
            deque.addTail(random.nextInt(10) + 1);
        }
        assertEquals(10, deque.size());
        deque.addTail(25);
        assertEquals(11, deque.size());
        assertEquals(25, deque.deque.get(0));
    }

    @Test
    void addFront(){
        Random random = new Random();
        Deque deque = new Deque();
        for (int i = 0; i < 10; i++){
            deque.addFront(random.nextInt(10) + 1);
        }
        assertEquals(10, deque.size());
        deque.addFront(25);
        assertEquals(11, deque.size());
        assertEquals(25, deque.deque.get(deque.deque.size() - 1));
    }

    @Test
    void removeTail(){
        Random random = new Random();
        Deque deque = new Deque();
        for (int i = 0; i < 10; i++){
            deque.addFront(random.nextInt(10) + 1);
        }
        assertEquals(10, deque.size());
        deque.addTail(25);
        assertEquals(11, deque.size());
        assertEquals(25, deque.removeTail());
        assertEquals(10, deque.size());
    }

    @Test
    void removeTail_null(){
        Deque deque = new Deque();
        assertEquals(0, deque.size());
        assertNull(deque.removeTail());
    }

    @Test
    void removeFront(){
        Random random = new Random();
        Deque deque = new Deque();
        for (int i = 0; i < 10; i++){
            deque.addFront(random.nextInt(10) + 1);
        }
        assertEquals(10, deque.size());
        deque.addFront(25);
        assertEquals(11, deque.size());
        assertEquals(25, deque.removeFront());
        assertEquals(10, deque.size());
    }

    @Test
    void removeFront_null(){
        Deque deque = new Deque();
        assertEquals(0, deque.size());
        assertNull(deque.removeFront());
    }
}
