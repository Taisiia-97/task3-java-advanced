package task12;

import java.util.Objects;

public class Cheese implements Ingredient {
    private static final double CALORIES_PER_GRAM = 3.2;
    private final double weight;
    private final String name;

    public Cheese( String name, double weight) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cheese cheese = (Cheese) o;
        return Double.compare(cheese.weight, weight) == 0 &&
                Objects.equals(name, cheese.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, name);
    }

    @Override
    public String name() {
        return name;
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
