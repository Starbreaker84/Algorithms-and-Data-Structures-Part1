import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack = new Stack();

    @Test
    void size_empty(){
        assertEquals(0, stack.size());
    }

    @Test
    void size_normal(){
        stack.stack.add(5);
        stack.stack.add("five");
        assertEquals(2, stack.size());
    }

    @Test
    void pop_normal(){
        stack.stack.add(5);
        stack.stack.add("five");
        assertEquals(2, stack.size());
        assertEquals("five", stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void pop_null(){
        stack.stack.add(5);
        stack.stack.add("five");
        assertEquals(2, stack.size());
        assertEquals("five", stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(0, stack.size());
        assertNull(stack.pop());
    }

    @Test
    void push(){
        stack.push(5);
        stack.push("five");
        assertEquals(2, stack.size());
        assertEquals(5, stack.stack.get(0));
        assertEquals("five", stack.stack.get(1));
    }

    @Test
    void peek_normal(){
        stack.stack.add(5);
        stack.stack.add("five");
        assertEquals(2, stack.size());
        assertEquals("five", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void peek_null(){
        assertNull(stack.peek());
    }
}
