import org.junit.jupiter.api.Test;
import static Deque.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    void palindrome_true(){
        String string = "asdfdsa";
        assertTrue(isPalindrome(string));
        string = "asddsa";
        assertTrue(isPalindrome(string));
    }

    @Test
    void palindrome_false(){
        String string = "asdfsa";
        assertFalse(isPalindrome(string));
        string = "asdsssa";
        assertFalse(isPalindrome(string));
    }
}
