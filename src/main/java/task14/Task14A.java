package task14;

import java.io.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * CZĘŚĆ 1
 * W pliku task14.txt znajduje się tekst. Wczytaj go i policz:
 * - liczbę słów
 * - liczbę wierszy
 * - liczbę słów 4-literowych
 * - liczbę słów, które są liczbami (całkowite lub dziesiętne np. 12, 34,45 itd.)
 * <p>
 * CZĘŚĆ 2
 * Zapisz do pliku out_task14.txt wyniki uzyskane z części 1 plus:
 * - listę słów 4-literowych
 * - listę wszystkich liczb
 * Lokalizację pliku out_task14.txt możesz wybrać dowolną np. w bieżącym katalogu
 */
public class Task14A {
    public static void main(String[] args) throws FileNotFoundException {
        //W taki sposób tworzymy strumień wejściowy do plików w katalogu resources
        InputStream input = Task14A.class.getResourceAsStream("../../task114.txt");
        //sekwencja ../ powoduje przejście o katalog wyżej
        //dwie sa konieczne ponieważ każdy pakiet to katalog, a mamy pakiet task14 w pakiecie homework
        //wczytanie tekstu


        System.out.println(lineCounter(new FileReader("c:\\data\\task14.txt")));
        System.out.println(wordCounter(new FileReader("c:\\data\\task14.txt")));
        System.out.println(fourWordCounter());

//zapisujemy wyniki do pliku
        File file = new File("c:\\data\\out_task14.txt");
      
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(Integer.toString(lineCounter(new FileReader("c:\\data\\task14.txt"))) + " ");
            writer.write(Integer.toString(wordCounter(new FileReader("c:\\data\\task14.txt"))) + " ");
            writer.write(Integer.toString(fourWordCounter()) + " ");
            wordList().stream().forEach(word -> {
                try {
                    writer.write(word + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
  //metoda zwracająca liste słow 4-literowych
    public static List<String> wordList(){
        List<String> words = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("c:\\data\\task14.txt"))) {
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split(" ")).filter(l -> l.length() == 4 && l.matches("\\w+")).forEach(element->words.add(element));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

        return words;
    }

    //metoda licząca ilość słow w pliku
    public static int wordCounter(FileReader fileReader) {
        int wordCounter = 0;
        String line;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                wordCounter += line.split(" ").length;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }
        return wordCounter;
    }

    //metoda obliczająca ilość linijek w pliku
    public static int lineCounter(FileReader fileReader) {
        int lineCounter = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.readLine() != null) {
                lineCounter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }
        return lineCounter;
    }

    //metoda obliczająca ilość słow 4-literowych w pliku
    public static int fourWordCounter() {
        int counter = 0;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("c:\\data\\task14.txt"))) {
            while ((line = reader.readLine()) != null) {
                List<String> word4 = Arrays.stream(line.split(" ")).filter(l -> l.length() == 4 && l.matches("\\w+")).collect(Collectors.toList());
                counter += word4.size();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

        return counter;
    }
}
