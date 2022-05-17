public class StringAnalyzer {
    public static boolean analyzer(String string){
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < string.length(); i++){
            Character letter = string.charAt(i);
            if (letter == '('){
                stack.push(string.charAt(i));
            }
            if (letter == ')' &&  stack.peek() == null){
                return false;
            }
            if (letter == ')' &&  stack.peek() != null){
                stack.pop();
            }
        }
        return (stack.size() <= 0);
    }
}
