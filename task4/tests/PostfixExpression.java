public class PostfixExpression {
    public static int postfix(Stack stack1){
        Stack<Integer> stack2 = new Stack<Integer>();
        while (stack1.size() > 0){
            Object item = stack1.pop();
            if (item.equals('+')){
                stack2.push(stack2.pop() + stack2.pop());
            }
            if (item.equals('-')){
                int num = stack2.pop();
                stack2.push(stack2.pop() - num);
            }
            if (item.equals('/')){
                int num = stack2.pop();
                stack2.push(stack2.pop() / num);
            }
            if (item.equals('*')){
                stack2.push(stack2.pop() * stack2.pop());
            }
            if (item.equals('=')){
                break;
            }
            if (item instanceof Integer) {
                stack2.push((Integer)item);
            }
        }
        return stack2.pop();
    }
}
