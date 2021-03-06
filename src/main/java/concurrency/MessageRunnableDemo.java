package concurrency;

public class MessageRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new MessageRunnable());
        Thread thread1 = new Thread(new MessageRunnable(1000));
        thread0.start();
        //wymuszanie kolejności wywolania wątków
        while (!thread0.isAlive()){

        }
        thread1.start();
        Thread.sleep(5000);

        thread0.interrupt();
        thread1.interrupt();
    }
}
