package taskstreams;

public class Car {
    private String carType;
  private   double  enginePower;
  private double mileage;
  private  Color color;
  private double prise;
  private  int seatsPlaces;

    public Car(String carType, double enginePower, double mileage, Color color, double prise, int seatsPlaces) {
        this.carType = carType;
        this.enginePower = enginePower;
        this.mileage = mileage;
        this.color = color;
        this.prise = prise;
        this.seatsPlaces = seatsPlaces;
    }

    public String getCarType() {
        return carType;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getMileage() {
        return mileage;
    }

    public Color getColor() {
        return color;
    }

    public double getPrise() {
        return prise;
    }

    public int getSeatsPlaces() {
        return seatsPlaces;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", enginePower=" + enginePower +
                ", mileage=" + mileage +
                ", color=" + color +
                ", prise=" + prise +
                ", seatsPlaces=" + seatsPlaces +
                '}';
    }
}
