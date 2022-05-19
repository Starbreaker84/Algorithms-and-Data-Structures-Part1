import java.util.*;

public class Deque<T> {
    public List<T> deque;

    public Deque() {
        this.deque = new ArrayList<>();
    }

    public void addFront(T item) {
        this.deque.add(item);
    }

    public void addTail(T item) {
        this.deque.add(0, item);
    }

    public T removeFront() {
        try{
            return this.deque.remove(deque.size() - 1);
        } catch (Exception exception) {
            return null;
        }
    }

    public T removeTail() {
        try{
            return this.deque.remove(0);
        } catch (Exception exception) {
            return null;
        }
    }

    public int size() {
        return this.deque.size();
    }
}
