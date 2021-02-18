package task12;

import java.util.Objects;

public class Ham implements Ingredient{
    final String name;
    final double weight;
    final double caloriesPerGram;

    public Ham(String name, double weight, double caloriesPerGram) {
        this.name = name;
        this.weight = weight;
        this.caloriesPerGram = caloriesPerGram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ham ham = (Ham) o;
        return Double.compare(ham.weight, weight) == 0 &&
                Double.compare(ham.caloriesPerGram, caloriesPerGram) == 0 &&
                Objects.equals(name, ham.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, caloriesPerGram);
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
        return weight * caloriesPerGram;
    }
}
