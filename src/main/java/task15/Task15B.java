package task15;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Napisz program, który pobiera jednocześnie kilka plików graficznych. Każdy plik ma być pobierany w osobnym wątku, a
 * wszystkie wątki należy uruchomić jednocześnie. Wykorzystaj klasę Executors i ExecutorService do tworzenia wątków.
 * Pobranie każdego z plików należy potwierdzić komunikatem na ekranie, a gdy ostatni plik zostanie pobrany i zapisany program kończy działanie.
 * Przykładowe adresy plików:
 * https://stormit.pl/wp-content/uploads/java-historia.png
 * https://developer.android.com/studio/images/write/desugar_diagram.png
 * https://www.eginnovations.com/blog/wp-content/uploads/2019/06/how-to-troubleshoot-java-cpu.jpg
 * https://static01.helion.com.pl/global/okladki/326x466/javp11.jpg
 * Do pobierania wykorzystaj metodę download.
 */
public class Task15B {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> urlAddresses = new ArrayList<>(Arrays.asList(
                "https://stormit.pl/wp-content/uploads/java-historia.png",
                "https://developer.android.com/studio/images/write/desugar_diagram.png",
                "https://www.eginnovations.com/blog/wp-content/uploads/2019/06/how-to-troubleshoot-java-cpu.jpg",
                "https://static01.helion.com.pl/global/okladki/326x466/javp11.jpg"));
        ExecutorService service = Executors.newFixedThreadPool(urlAddresses.size());
        urlAddresses.stream().forEach(url -> service.execute(new ImageLoader(url)));
        service.shutdown();


    }

    public static void download(String url, String localFilename) {
        //try with resource, tutaj możemy otwierać strumienie, które automatycznie zostaną zamknięte po wyjściu z bloku try (klasy implementujace AutoCloseable)
        try (
                BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());    //strumień wejściowy
                FileOutputStream fileOutputStream = new FileOutputStream(localFilename)         //strumień wyjsciowy skojarzony z plikiem lkoklanym
        ) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            //odczytujemy w pętli ciąg bajtów ze strumienia wejściowego porcjami i umieszaczmy w buforze, gdy brak danych zwraca -1
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);           //zawartości bufora przesyłana jest do strumienia wyjściowego
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
