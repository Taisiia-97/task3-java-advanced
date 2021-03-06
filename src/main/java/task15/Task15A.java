package task15;

import javax.swing.plaf.TableHeaderUI;
import java.util.Scanner;

public class Task15A {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message("Hello");
        message.start();
        Scanner scanner = new Scanner(System.in);
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
