package PTepsit;

public class Consumatore extends Thread {
    private Buffer buffer;
    private int numValues;
    private int pari = 0;
    private int dispari = 0;

    public Consumatore(Buffer buffer, int numValues) {
        this.buffer = buffer;
        this.numValues = numValues;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numValues; i++) {
                int value = buffer.take();
                System.out.println("Consumatore ha consumato: " + value);
                if (value % 2 == 0) {
                    pari++;
                } else {
                    dispari++;
                }
                System.out.println("Statistiche: Pari = " + pari + ", Dispari = " + dispari);
                Thread.sleep(120);  // Attendere 120ms per ogni valore
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
