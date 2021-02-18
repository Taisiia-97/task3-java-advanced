package task12;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dish implements Ingredient {
  private   List<Ingredient> ingredients;
    private String name;

    public Dish(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public Dish(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }


    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);

    }

    public  List<Ingredient> ingredients() {
        List<Ingredient> copy = new ArrayList<>(ingredients);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Ingredient ingredient : ingredients) {
            weight += ingredient.weight();
        }
        return weight;
    }

    @Override
    public double calories() {
        double calories = 0;
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.calories();
        }
        return 0;
    }
}
