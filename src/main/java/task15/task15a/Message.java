package task15.task15a;

import java.util.stream.Stream;

public class Message extends Thread{
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (!this.interrupted()){
            System.out.println(message);
            try {
                Thread.sleep(5000);

            }catch (InterruptedException e){
                this.interrupt();
            }
        }
    }
}
