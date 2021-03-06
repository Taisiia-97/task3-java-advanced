package concurrency;

public class MessageThread extends Thread {
    @Override
    public void run() {
        int count = 10;
        while (!this.isInterrupted() && count-->10) {
            System.out.println("Actualna temperatura: " + 100);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku");
                this.interrupt();
            }


        }

        System.out.println("Koniec wantku!");

    }
}
