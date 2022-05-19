public class Palindrome {
    public static boolean isPalindrome(String string){
        Deque<Character> deque = new Deque<Character>();
        for (int i = 0; i < string.length(); i++){
            deque.addTail(string.charAt(i));
        }
        while (deque.size() > 1) {
            if (!(deque.removeFront().equals(deque.removeTail()))) return false;
        }
        return true;
    }
}
