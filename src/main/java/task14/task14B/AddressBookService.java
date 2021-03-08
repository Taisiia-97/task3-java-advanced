package task14.task14B;



import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class AddressBookService {

    private final static File addressBook = new File("c:\\data\\AddressBook.txt");



    private AddressBookService() {

    }

    public static void addAddress(AddressItem addressItem) {
        List<AddressItem> items = getItems();
        items.add(addressItem);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(addressBook))) {
            out.writeObject(items);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd odczytu");
        }

    }

    public static void removeAddress(AddressItem addressItem) {
        List<AddressItem> items = getItems();
        if (items.contains(addressItem)) {
            items.remove(addressItem);
            try {
                ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(addressBook));
                in.writeObject(items);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Podany przez ciebie kontakt nie istnieje w bazie");
        }

    }

    public static void bookContent() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(addressBook));
            List<AddressItem> items = (ArrayList) in.readObject();
            if(items!=null) {
                items.stream().forEach(System.out::println);
            }
            else {
                System.out.println("Plik jest pusty");
            }
            in.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Plik jest pusty");
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono klasy");
        }

    }


    public static void findAddress(String input) {
        List<AddressItem> items = getItems();
            for (AddressItem item : items
            ) {
                if (item.getName().equals(input) || item.getFullName().equals(input) ||
                        item.getEmailAddress().equals(input) || item.getPhoneNumber().equals(input)) {
                    System.out.println(item);
                }

            }


    }
private static List<AddressItem> getItems(){
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
}
