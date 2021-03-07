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
            outputstream.writeObject(book);
            outputstream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

    }

    public static void removeAddress(AddressItem addressItem) {
        if (book.contains(addressItem)) {
            book.remove(addressItem);
            try {
                ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(addressBook));
                in.writeObject(book);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void addressBook() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            List<AddressItem> items = (ArrayList) in.readObject();
            System.out.println(items);
            in.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void findAddress(String input) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            List<AddressItem> items = (ArrayList) in.readObject();
            for (AddressItem item : items
            ) {
                if (item.getName().equals(input) || item.getFullName().equals(input) ||
                        item.getEmailAddress().equals(input) || item.getPhoneNumber().equals(input)) {
                    System.out.println(item);
                }

            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Koniec pliku");
            ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
