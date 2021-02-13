package task6;

import java.time.LocalDate;
import java.util.Scanner;

public class Pesel {
    private final String PESEL;
    private LocalDate birthday;
    private String gender;

    private Pesel(String PESEL) {
       this.PESEL = PESEL;
    }

   public static Pesel of(String pesel){
       int controlNumber = countControlNumber(pesel);
        if(pesel.length()!=11 || controlNumber!=Character.getNumericValue(pesel.charAt(10))) return null;

        return new Pesel(pesel);
   }



    private static int countControlNumber(String pesel) {
        int[] PESEL = new int[11];
        int suma = 0;
        for (int i = 0; i < pesel.length(); i++) {
           char znak = pesel.charAt(i);
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
        return suma%10;
    }

    public String getPESEL() {
        return PESEL;
    }


}



