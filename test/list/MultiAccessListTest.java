package list;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class MultiAccessListTest {
    public static final int VALUES = 100;
    public static final int THREADS = 100;

    @Test
    public void threadsTest() throws InterruptedException {
        int size = VALUES * THREADS;
        List<String> list = new LinkedList<>();

        java.util.List<String> values = new ArrayList<>();
        for (int i = 0; i < VALUES; i++) {
            values.add("test");
        }
        java.util.List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            threads.add(new Thread(new AddWorker<>(list, values)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        Assert.assertEquals(size, list.getSize());
    }
}

class AddWorker<T> implements Runnable {
    private List<T> list;
    private java.util.List<T> values;

    public AddWorker(List<T> list, java.util.List<T> values) {
        this.list = list;
        this.values = values;
    }

    @Override
    public void run() {
        for (T value : values) {
            list.addLast(value);
        }
    }
}
