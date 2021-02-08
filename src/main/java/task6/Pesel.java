package task6;

import java.time.LocalDate;
import java.util.Scanner;

public class Pesel {
    private static int[] PESEL;
    private LocalDate birthday;
    private String gender;

    private Pesel() {
        PESEL = setPesel();
    }

    private int[] setPesel() {
        return new int[9];
    }
   /* Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer PESEL:");
    String Pesel = scanner.nextLine();
    int[] PESEL = new int[11];

        if (Pesel.length() != 11) {
        System.out.println("Wprowadzony numer Pesel nie jest poprawny");
    }

    char znak;
    int suma = 0, suma1 = 0;
        for (int i = 0; i < Pesel.length(); i++) {
        znak = Pesel.charAt(i);
        int cyfra = Character.getNumericValue(znak);// zamienia znak char na cyfre
        if ((i == 0) || (i == 4) || (i == 8) || (i == 10)) {
            PESEL[i] = (cyfra * 1);
        } else if ((i == 1) || (i == 5) || (i == 9)) {
            PESEL[i] = (cyfra * 3);
        } else if ((i == 2) || (i == 6)) {
            PESEL[i] = (cyfra * 7);
        } else if ((i == 3) || (i == 7)) {
            PESEL[i] = (cyfra * 9);
        }

    }
        for (int j = 0; j < PESEL.length; j++) {
        suma += PESEL[j];

    }
        System.out.println(suma);
    int reszta = suma%10;

        if (reszta == 0 ) {
        System.out.println("Podany numer PESEL jest poprawny");
    } else {
        System.out.println("Podany numer PESEL nie jest poprawny");
    }
*/

}



