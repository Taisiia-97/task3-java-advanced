package equipment;

public class Main {
    public static void main(String[] args) {
        /**
         * Po wykonaniu zadania zmień typ referencji na zdefiniowaną klasę abstrakcyjną w poniższych trzeh wierszach
         */
        CellPhone superZi = new CellPhone("Szamsuk", 4000, "1678876", 12_000_000);
        Laptop iDaisy = new Laptop("Daisy Co", 8000, "XYZ-100 RW", 120);
        SmartWatch handyWatch = new SmartWatch("Quququ", 1000, "black");
        /**
         * Jeśli po zmianie program wyświetli dokładnie takie same komunikaty, to znaczy, że zadanie zostało wykonane poprawnie
         */
        System.out.println(superZi.getProducer());
        System.out.println(iDaisy.getProducer());
        System.out.println(handyWatch.getProducer());
        System.out.println(superZi.sendSMS("Hello"));
        System.out.println(handyWatch.sendSMS("Hello"));
        System.out.println(iDaisy.sendSMS("Hello"));
        handyWatch.setWiFi(true);
        System.out.println(handyWatch.sendSMS("Hello"));
        superZi.setWiFi(true);
        superZi = new CellPhone("Czułałej", 3000, null, 16_000_000);
        System.out.println(superZi.sendSMS("Hello again"));
    }
}
