public class Rotator {
    
    public static void rotation(int cycles, Queue queue) {
        for (int i = 0; i < cycles; i++) {
            if (queue.size() > 0) {
                queue.enqueue(queue.dequeue());
            }
        }
    }
}
