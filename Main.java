package PTepsit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta dell'input
        System.out.print("Inserisci il numero di thread T: ");
        int T = scanner.nextInt();
        System.out.print("Inserisci il valore massimo N: ");
        int N = scanner.nextInt();

        // Creare il buffer
        Buffer buffer = new Buffer(10);  // Imposta capacità buffer a 10

        // Creare e avviare i thread produttori e consumatori
        Produttore[] produttori = new Produttore[T];
        Consumatore[] consumatori = new Consumatore[T];

        for (int i = 0; i < T; i++) {
            produttori[i] = new Produttore(buffer, N);
            consumatori[i] = new Consumatore(buffer, N);

            produttori[i].start();
            consumatori[i].start();
        }

        // Attendere che i thread finiscano
        try {
            for (int i = 0; i < T; i++) {
                produttori[i].join();
                consumatori[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
