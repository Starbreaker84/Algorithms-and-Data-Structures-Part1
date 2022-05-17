public class PostfixExpression {
    private static void multiplication (Stack stack){
        int res = 1;
        while (stack.size() > 0){
            res *= (int) stack.pop();
        }
        stack.push(res);
    }

    private static void addition (Stack stack){
        int res = 0;
        while (stack.size() > 0){
            res += (int) stack.pop();
        }
        stack.push(res);
    }

    public static int postfix(Stack stack1){
        Stack<Integer> stack2 = new Stack<Integer>();
        while (stack1.size() > 0){
            if (stack1.peek() instanceof Integer){
                stack2.push((int) stack1.peek());
            }
            if (stack1.peek().equals('*')){
                multiplication(stack2);
            }
            if (stack1.peek().equals('+')){
                addition(stack2);
            }
            if (stack1.peek().equals('=')){
                break;
            }
            stack1.pop();
        }
        assert stack2.size() == 1;
        return stack2.pop();
    }
}
