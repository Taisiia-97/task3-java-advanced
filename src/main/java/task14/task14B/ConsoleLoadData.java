package task14.task14B;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleLoadData implements Load<AddressItem> {

    private static Scanner in = new Scanner(System.in);

    public ConsoleLoadData() {
    }

    @Override
    public AddressItem loadData() {
        System.out.println("Podaj imię: ");
        String name = in.nextLine();
        while (!DataVerification.verifyName(name)) {
            System.out.println("Podane imie nie jest poprawne!!! Spróbój ponownie");
            name = in.nextLine();

        }
        System.out.println("Podaj nazwisko: ");
        String fullName = in.nextLine();
        while (!DataVerification.verifyFullName(fullName)) {
            System.out.println("Podane przez ciebie nazwisko nie jest poprawne!!! Spróbój ponownie");
            fullName = in.nextLine();
        }
        System.out.println("Podaj email address");
        String email = in.nextLine();
        while (!DataVerification.verifyEmail(email)) {
            System.out.println("Podany email nie jest poprawny!!! Spróbój ponownie");
            email = in.nextLine();
        }
        System.out.println("Podaj numer telefonu");
        String phoneNumber = in.nextLine();
        while (!DataVerification.verifyPhone(phoneNumber)) {
            System.out.println("Podany numer telefonu nie jest poprawny!!! Spróbój ponownie");
            phoneNumber = in.nextLine();
        }
        LocalDate birthDay;
        while (true) {
            System.out.println("Wpisz date urodzenia w postaci rrrr-mm-dd");
            String data = in.nextLine();
            try {
                birthDay = LocalDate.parse(data);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Wpisana przez ciebie data nie jest poprawna!!!");
            }
        }
        return new AddressItem(name, fullName, email, phoneNumber, birthDay);
    }
}
