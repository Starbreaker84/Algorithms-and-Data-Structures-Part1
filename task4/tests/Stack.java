import java.util.*;

public class Stack<T> {
    public List<T> stack;

    public Stack()     {
        this.stack = new ArrayList<>();
    }

    public int size() {
        return this.stack.size();
    }

    public T pop() {
        try{
            return this.stack.remove(this.stack.size() - 1);
        } catch (Exception exception){
            return null;
        }
    }

    public void push(T val) {
        this.stack.add(val);
    }

    public T peek() {
        try{
            return this.stack.get(this.stack.size() - 1);
        } catch (Exception exception){
            return null;
        }
    }
}
