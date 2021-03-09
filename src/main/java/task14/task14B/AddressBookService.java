package task14.task14B;


import java.io.*;

import java.util.ArrayList;
import java.util.List;


public class AddressBookService {

    private final static File addressBook = new File("c:\\data\\AddressBook.txt");

    private AddressBookService() {

    }

    public static void addAddress(AddressItem addressItem, List<AddressItem> items) {
        items.add(addressItem);
    }

    public static void removeAddress(int number, List<AddressItem> book) {

        try {
            book.remove(book.get(number));
            System.out.println("Podany przez ciebie adress został usunięty z bazy");

        } catch (Exception e) {
            System.out.println("Podany przez ciebie kontakt nie istnieje w bazie");
        }

    }

    public static void bookContent(List<AddressItem> items) {
        if (items.isEmpty()) System.out.println("Książka adresowa jest pusta");
        items.stream().forEach(element -> {
            System.out.println(items.indexOf(element) + ". " + element);
        });

    }


    public static void findAddress(String input, List<AddressItem> items) {
        for (AddressItem item : items
        ) {
            if (item.getName().equalsIgnoreCase(input) || item.getFullName().equalsIgnoreCase(input) ||
                    item.getEmailAddress().equals(input) || item.getPhoneNumber().equals(input)) {
                System.out.println(item);
            }

        }


    }

    //metoda służącą do odczytu z pliku do kolekcji
    public static List<AddressItem> getItems() {
        List<AddressItem> items;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            items = (ArrayList) in.readObject();
            in.close();
            return items;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono klasy");
        }
        return new ArrayList<>();
    }

    //metoda do zapisu kolekcji do pliku
    public static void writeItems(List<AddressItem> items) {
        try {
            ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(addressBook));
            in.writeObject(items);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
