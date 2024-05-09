import java.util.concurrent.Semaphore;

public class ProduciDato extends Thread {
    private Semaphore pieno;
    private Semaphore vuoto;
    private final int attesa = 500;

    public ProduciDato(Semaphore s1, Semaphore s2) {
        pieno = s1;
        vuoto = s2;
    }

    public void run() {
        for (int i = 0; i < ProdConsSem.tanti; i++) {
            vuoto.acquireUninterruptibly();
            ProdConsSem.buffer = i;
            System.out.println("Scrittore: dato scritto: " + i);
            pieno.release();

            try {
                Thread.sleep(attesa);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Scrittore: termine scrittura dati.");
        }
    }
}
