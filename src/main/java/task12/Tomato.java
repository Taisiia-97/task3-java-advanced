package task12;

import java.util.Objects;

public class Tomato implements Ingredient{
    private static final double CALORIES_PER_GRAM = 0.5;
    final String name;
    final double weight;
    final double calories;

    public Tomato(String name, double weight, double calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
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
        return weight * CALORIES_PER_GRAM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tomato tomato = (Tomato) o;
        return Double.compare(tomato.weight, weight) == 0 &&
                Double.compare(tomato.calories, calories) == 0 &&
                Objects.equals(name, tomato.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, calories);
    }

    @Override
    public String toString() {
        return "Tomato{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                '}';
    }
}
