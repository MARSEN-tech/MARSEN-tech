package PTepsit;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private Queue<Integer> buffer;
    private int capacity;

    public Buffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(value);
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int value = buffer.poll();
        notifyAll();
        return value;
    }

    public synchronized boolean isEmpty() {
        return buffer.isEmpty();
    }
}
