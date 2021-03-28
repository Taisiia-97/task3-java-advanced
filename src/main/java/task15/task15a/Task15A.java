package task15.task15a;

import java.util.Scanner;

public class Task15A {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message("Hello");
        message.start();
        while (true){
           String command = scanner.nextLine();
           if(command.equals("Q")){
               System.out.println("Kończę program");
               message.interrupt();
           }
         Thread.sleep(100);
            if(!message.isAlive()) {
    System.out.println("Koniec");
    return;
}
        }
    }
}
