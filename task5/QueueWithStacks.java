import Stack.*;

public class QueueWithStacks<T> {
    private Stack stack1;
    private Stack stack2;
    public QueueWithStacks() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enqueue(T item) {
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        stack1.push(item);
    }

    public T dequeue() {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        return (T) stack2.pop(); // null если очередь пустая
    }

    public int size() {
        if (stack1.size() > stack2.size()) return stack1.size();
        return stack2.size(); // размер очереди
    }
}
