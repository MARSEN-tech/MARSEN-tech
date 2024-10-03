package PTepsit;

import java.util.Random;

public class Produttore extends Thread {
    private Buffer buffer;
    private int numValues;
    private Random rand;

    public Produttore(Buffer buffer, int numValues) {
        this.buffer = buffer;
        this.numValues = numValues;
        this.rand = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numValues; i++) {
                int value = rand.nextInt(1024);
                buffer.put(value);
                System.out.println("Produttore ha prodotto: " + value);
                int sleepTime = rand.nextInt(900) + 100;
                Thread.sleep(sleepTime);  // Tempo tra 100 e 1000ms
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

