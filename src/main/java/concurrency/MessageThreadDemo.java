package concurrency;

import java.util.Scanner;

public class MessageThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MessageThread thread = new MessageThread();
        System.out.println("Uruchamiam wątek!!!");
        thread.start();
        System.out.println("Watek uruchomiony");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("q")) {
                thread.interrupt();

            }
            Thread.sleep(1);
            if (!thread.isAlive()) {
                System.out.println("KONIEC");
                return;
            }
        }
    }


}

