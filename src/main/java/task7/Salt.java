package task7;

public class Salt implements Ingredient{
    private static final double CALORIES_PER_GRAM = 0;
    private final double weight;
    private final String name;

    public Salt(double weight, String name) {
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
}
