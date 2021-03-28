package task15;


import java.io.File;
import java.util.Scanner;

public class ImageLoader extends Thread {
    private final String url;
    private static Scanner scanner = new Scanner(System.in);


    public ImageLoader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        {
            File file = new File(url);
            String choice;
            synchronized (scanner) {
                System.out.println("Podtwierź pobranie pliku napisem t");
                choice = scanner.nextLine();
            }
            if (choice.equalsIgnoreCase("t")) {
                System.out.println("Download started");
                Task15B.download(url, "c:\\data\\" + file.getName());
                System.out.println("File downloaded");
                this.interrupt();
            } else {
                System.out.println("Podbranie odrzucone");
                this.interrupt();
            }
        }
    }
}
