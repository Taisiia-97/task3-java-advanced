package task7;

public class Cheese implements ValuableIngredient{
    private static final double CALORIES_PER_GRAM = 3.2;
    private static  final double PRICE_PER_KG = 25.5;
    private final double weight;
    private final String name;

    public Cheese(double weight, String name) {
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
        return  (weight/1000)*PRICE_PER_KG;
    }
}
