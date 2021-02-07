package task7;

public class Egg implements ValuableIngredient{
    private static final double CALORIES_PER_GRAM = 1.5;
    private static final double PRICE_PER_KG = 4.5;
    private final double weight;
    private final String name;

    public Egg( double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double calories() {
        return weight * CALORIES_PER_GRAM;
    }

    @Override
    public double ingredientPrice() {
        //weight for ingredient is added in g
        return (weight/1000)*PRICE_PER_KG;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
