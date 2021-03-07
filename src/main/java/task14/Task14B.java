package task14;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

            System.out.println("Podaj imię: ");
            String name = scanner.nextLine();
            while (!DataVerification.verifyName(name)) {
                System.out.println("Podane imie nie jest poprawne!!! Spróbój ponownie");
                name = scanner.nextLine();

            }
            System.out.println("Podaj nazwisko: ");
            String fullName = scanner.nextLine();
            while (!DataVerification.verifyFullName(fullName)) {
                System.out.println("Podane przez ciebie nazwisko nie jest poprawne!!! Spróbój ponownie");
                fullName = scanner.nextLine();
            }
            System.out.println("Podaj email address");
            String email = scanner.nextLine();
            while (!DataVerification.verifyEmail(email)) {
                System.out.println("Podany email nie jest poprawny!!! Spróbój ponownie");
                email = scanner.nextLine();
            }
            System.out.println("Podaj numer telefonu");
            String phoneNumber = scanner.nextLine();
            while (!DataVerification.verifyPhone(phoneNumber)) {
                System.out.println("Podany numer telefonu nie jest poprawny!!! Spróbój ponownie");
                phoneNumber = scanner.nextLine();
            }
            LocalDate birthDay;
            while (true) {
                System.out.println("Wpisz date urodzenia w postaci rrrr-mm-dd");
                String data = scanner.nextLine();
                try {
                    birthDay = LocalDate.parse(data);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Wpisana przez ciebie data nie jest poprawna!!!");
                }
            }
            AddressBookService.addAddress(new AddressItem(name, fullName, email, phoneNumber, birthDay));

        });
        removeAddress.setCallback(() -> {

        });
        bookContent.setCallback(() -> {
            AddressBookService.addressBook();
        });
        findAddress.setCallback(() -> {

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
