import java.util.*;

public class Queue<T> {
    public List<T> qu;

    public Queue() {
        qu = new ArrayList<>();
    }

    public void enqueue(T item) {
        qu.add(item);
    }

    public T dequeue() {
        try {
            return qu.remove(0);
        } catch (Exception exception) {
            return null;
        }
    }

    public int size() {
        return qu.size();
    }
}
