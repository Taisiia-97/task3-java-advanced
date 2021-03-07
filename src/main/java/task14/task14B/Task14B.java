package task14.task14B;


import java.util.*;

/**
 * Napisz program, który obsługuje książkę adresową zapisywaną w pliku.
 * Format pliku jest binarny, a zapisywane są serializowane obiekty klasy
 * AddressItem. Dodaj do tej klasy odpowiedni interfejs, który umożliwia serializację.
 * Program powinien umożliwiać:
 * - dodanie nowego adresu
 * - usunięcie adresu
 * - wyświetlenie całej zawartości
 * - wyszukanie na podstawie pola name lub phoneNumber adresu lub adresów (dla pola name)
 */
public class Task14B {
    static Scanner scanner = new Scanner(System.in);
    static LoadData loadData = new LoadData();

    public static void main(String[] args) {


        MenuItem addAddress = new MenuItem("Dodaj adres do książki adresowej", 1);
        MenuItem removeAddress = new MenuItem("Usuń address z książki adresowej", 2);
        MenuItem bookContent = new MenuItem("Pokaż zawartość ksiażki adresowej", 3);
        MenuItem findAddress = new MenuItem("Wyszukaj adres w książce adresowej", 4);
        MenuItem exit = new MenuItem("Zakończ na dzisiaj", 0);
        exit.setCallback(() -> {
            System.exit(0);
        });

        addAddress.setCallback(() -> {
            System.out.println("Podaj dane do zapisu: ");
            AddressBookService.addAddress(loadData.loadData());
            System.out.println("Wprowadzone przez ciebie dane zostały zapisane do książki adresowej");


        });
        removeAddress.setCallback(() -> {
            System.out.println("Podaj dane do usuniącia");
            AddressBookService.removeAddress(loadData.loadData());

        });
        bookContent.setCallback(() -> {
            AddressBookService.bookContent();
        });
        findAddress.setCallback(() -> {
            System.out.println("Podaj numer telefonu, email lub imie");
            String input = scanner.nextLine();
            AddressBookService.findAddress(input);
        });

        Menu menu = new Menu(new ArrayList<>(Arrays.asList(addAddress, removeAddress, bookContent, findAddress, exit)));
        while (true) {
            menu.print();
            String command = scanner.nextLine();
            while (!menu.verifyMenuItem(command)) {
                System.out.println("Nieopoprawny numer z menu!!! Spróbój ponownie");
                command = scanner.nextLine();
            }
            menu.process(Integer.parseInt(command));

        }

    }
}
