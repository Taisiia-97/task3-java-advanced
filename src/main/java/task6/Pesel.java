package task6;

import java.time.LocalDate;

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

}
