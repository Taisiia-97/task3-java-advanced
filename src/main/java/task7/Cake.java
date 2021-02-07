package task7;

public class Cake implements ValuableIngredient {
    private static final double CALORIES_PER_GRAM = 5.02;
    private static final double  PRICE_PER_KG = 30;
    private final double weight;
    private final String name;

    public Cake(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return weight*CALORIES_PER_GRAM;
    }

    @Override
    public double ingredientPrice() {
        return (weight/1000) * PRICE_PER_KG;
    }
}
