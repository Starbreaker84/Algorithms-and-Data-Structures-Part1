import org.junit.jupiter.api.Test;
import static Stack.PostfixExpression.postfix;
import static org.junit.jupiter.api.Assertions.*;

class PostfixExpressionTest {

    @Test
    void postfix_simple(){
        Stack stack = new Stack();
        stack.push('=');
        stack.push('+');
        stack.push(2);
        stack.push(2);
        assertEquals(4, postfix(stack));
    }

    @Test
    void postfix_complex(){
        Stack stack = new Stack();
        stack.push('=');
        stack.push('+');
        stack.push(9);
        stack.push('*');
        stack.push(5);
        stack.push('+');
        stack.push(2);
        stack.push(8);
        assertEquals(59, postfix(stack));
    }

    @Test
    void postfix_hard(){
        Stack stack = new Stack();
        stack.push('=');
        stack.push('+');
        stack.push(9);
        stack.push('*');
        stack.push(2);
        stack.push(5);
        stack.push('+');
        stack.push(2);
        stack.push(8);
        stack.push(3);
        assertEquals(139, postfix(stack));
    }

}
