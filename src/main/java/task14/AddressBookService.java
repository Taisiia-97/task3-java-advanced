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
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            Object addressItem;
            while ((addressItem = in.readObject()) != null) {
                addressItem = (AddressItem) addressItem;
                System.out.println(addressItem);
            }

        } catch (Exception e) {
            System.err.println("Konic pliku");
        }

    }

    public static void findAddress(String input) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            Object addressItem;
            while ((addressItem = in.readObject()) != null) {
                if (((AddressItem) addressItem).getName().equals(input)
                        || ((AddressItem) addressItem).getFullName().equals(input)
                        || ((AddressItem) addressItem).getEmailAddress().equals(input)
                        || ((AddressItem) addressItem).getPhoneNumber().equals(input)) {
                    System.out.println((AddressItem)addressItem);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Koniec pliku");;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
