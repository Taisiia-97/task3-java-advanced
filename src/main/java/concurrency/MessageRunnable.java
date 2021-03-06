package concurrency;

public class MessageRunnable implements Runnable {
private final long time;

    public MessageRunnable() {
        this.time=1000;
    }

    public MessageRunnable(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        int count = 10;
        while (!Thread.currentThread().isInterrupted() && count-->0) {
            System.out.println("Actualna temperatura: " + 100+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku");
                Thread.currentThread().interrupt();
            }


        }

        System.out.println("Koniec wantku!");
    }
}
