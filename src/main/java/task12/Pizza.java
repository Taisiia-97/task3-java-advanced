package task12;

import java.lang.reflect.Array;
import java.util.*;

public class Pizza extends Dish implements Ingredient{
private Map<String,Ingredient> ingredients;

    public Pizza(String name) {
        super(name);
        ingredients = new HashMap<>();
    }

    public Map<String,Ingredient> getIngredients() {
       return  new HashMap<>(ingredients);
    }


    public boolean addCake(Cake cake) {
        if(ingredients.containsKey("Cake")) return false;
        ingredients.put("Cake",cake);
        return true;
    }
    public boolean addTomato(Tomato tomato){
        if(ingredients.containsKey("Tomato")) return false;
        ingredients.put("Tomato",tomato);
        return true;
    }
    public boolean addCheese(Cheese cheese){
        if(ingredients.containsKey("Cheese")) return false;
        ingredients.put("Cheese",cheese);
        return true;
    }
    public boolean isReady(){

      return ingredients.containsKey("Tomato")&& ingredients.containsKey("Cake")&&ingredients.containsKey("Cheese");


// return ingredients.size()==3;

    }
}
