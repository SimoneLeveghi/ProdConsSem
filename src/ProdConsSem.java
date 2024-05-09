import java.util.concurrent.Semaphore;

public class ProdConsSem {
    protected static int buffer;
    protected static int tanti = 5;

    public static void main(String[] args) {
        Semaphore pieno = new Semaphore(0);
        Semaphore vuoto = new Semaphore(1);
        ProduciDato prod = new ProduciDato(pieno, vuoto);
        ConsumaDato cons = new ConsumaDato(pieno, vuoto);

        prod.start();
        cons.start();

        System.out.println("Main: termine avvio thread.");
    }
}