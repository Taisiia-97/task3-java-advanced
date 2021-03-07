package task14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    private static File addressBook = new File("c:\\data\\AddressBook.txt");
    private static List<AddressItem> book = new ArrayList<>();
    private static FileInputStream inputStream;
    private static FileOutputStream outputStream;

    private AddressBookService() {

    }

    public static void addAddress(AddressItem addressItem) {
book.add(addressItem);
        try (ObjectOutputStream outputstream = new ObjectOutputStream(new FileOutputStream(addressBook))) {
            for (AddressItem item : book) {
                outputstream.writeObject(item);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

    }

    public static void removeAddress(AddressItem addressItem) {


    }

    public static void addressBook()  {


    }

    public static void findAddress(String input) {

    }
}
