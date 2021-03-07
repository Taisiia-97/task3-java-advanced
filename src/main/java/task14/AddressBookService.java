package task14;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    private static File addressBook = new File("c:\\data\\AddressBook.txt");
    private static List<AddressItem> book = new ArrayList<>();


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

    public static void addressBook() {
        try {
            FileInputStream fileIn = new FileInputStream(addressBook);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object adressItem;
           while ( (adressItem =in.readObject())!=null){
adressItem = (AddressItem) adressItem;
               System.out.println(adressItem);
           }

        } catch (Exception e) {
            System.err.println("Nie udało sie");
        }

    }

    public static void findAddress(String input) {

    }
}
