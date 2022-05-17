import java.util.*;

public class InvertedStack<T> {
    public List<T> stack;

    public InvertedStack()     {
        this.stack = new ArrayList<>();
    }

    public int size() {
        return this.stack.size();
    }

    public T pop() {
        try{
            return this.stack.remove(0);
        } catch (Exception exception){
            return null;
        }
    }

    public void push(T val) {
        this.stack.add(0, val);
    }

    public T peek() {
        try{
            return this.stack.get(0);
        } catch (Exception exception){
            return null;
        }
    }
}
