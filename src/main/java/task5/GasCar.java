package task5;

public final class GasCar {
    private double fuelLevel;
    private final double fuelCapacity;

    public GasCar(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    public  double levelOfCapacity(){
        return fuelLevel;
    }
    /**
     * Metoda tankowania, powinna zmieniać poziom paliwa w fuelLevel
     * @param fuel objętość paliwa, które chce się dolać do baku
     * @return rzeczywista objętośc paliwa dolanego do baku
     *
     *
     * PRZYKLADY
     * Dla obiektu o parametrach
     * fuelCapacity równe 30
     * fuelLLevel równe 10
     * Przykład 1
     * wywołano metodę refuel(25) i zwrócona wartość wynosi 5, gdyż w baku jest miejsce tylko dla 20 litrów
     * Przykład 2
     * wywołano metodę refuel(-10) i zwrócona wartość wynosi 0, gdyż nie można dolać ujemnej wartości paliwa
     * Przykład 3
     * wywołano metodę refuel(5) i zwrócona wartość wynosi 5, gdyż cała porcja zmieściła się w abku
     */
    public double refuel(double fuel) {
        double addedToTank = 0;
        if (fuel < 0 || fuelLevel == fuelCapacity) return 0;
        while (fuelLevel != fuelCapacity && fuel > 0) {
            fuelLevel++;
            addedToTank++;
            fuel--;
        }
        return addedToTank;
    }

    /**
     * Metoda symulująca zużycie podanej porcji paliwa i zmieniająca fuelLevel
     * @param fuel objętość paliwa, które chce się zużyć
     * @return rzeczywista objętość zużytego paliwa
     *
     * Kontrakt jest podobny do metody refuel, z tą różnica, że powoduje zmniejszenie poziomu paliwa
     * PRZYKLADY
     * Dla obiektu o parametrach
     *  fuelCapacity równe 30
     *  fuelLLevel równe 10
     *Przykład 1
     * wywołano metodę consume(30) i otrzymano wartość 10, gdyż tylko tyle można zużyć, bak został pusty
     * wywołano metodę consume(-10) i otrzymano wartośc 0, bo nie można zużyć ujemnego paliwa
     * wywołano metodę consume(2) i otrzymano wartość 2, gdyż w baku było 10, więc zużyto 2 i pozostało jeszcze 8
     */
    public double consume(double fuel){
        double usedFuel = 0;
        if(fuel<0 || fuelLevel == 0) return 0;
        while (fuelLevel!=0 && fuel>0){
            fuelLevel--;
            fuel--;
            usedFuel++;
        }
        return usedFuel;

    }
}
