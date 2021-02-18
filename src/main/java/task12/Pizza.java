package task12;

import java.lang.reflect.Array;
import java.util.*;

public class Pizza extends Dish implements Ingredient{
private Set<Ingredient> ingredients ;

    public Pizza(String name) {
        super(name);
        this.ingredients = new HashSet<>();
    }


    public Set<Ingredient> getIngredients() {
        Set<Ingredient> copy = new HashSet<>(ingredients);
        return copy;
    }

    public boolean addCake(Cake cake) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Cake) return false;
        }
        ingredients.add(cake);
        return true;
    }
    public boolean addTomato(Tomato tomato){
        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Tomato) return false;
        }
        ingredients.add(tomato);
        return true;
    }
    public boolean addCheese(Cheese cheese){
        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Cheese) return false;
        }
        ingredients.add(cheese);
        return true;
    }
    public boolean isReady(){
        int counter = 0;
        for (Ingredient ingredient : ingredients) {
            if(ingredient instanceof Cake) counter++;
           else if (ingredient instanceof Cheese) counter++;
           else if(ingredient instanceof Tomato) counter++;
        }
        return counter==3;


// return ingredients.size()==3;

    }
}
