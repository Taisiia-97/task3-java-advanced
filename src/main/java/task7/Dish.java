package task7;

public class Dish implements Ingredient {
private Ingredient[] ingredients;
private  final double DISH_PRICE;

    public Dish(Ingredient[] ingredients) {
        this.ingredients = ingredients;
        DISH_PRICE =countDishPrice();
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Ingredient ingredient : ingredients) {
            weight+=ingredient.weight();
        }
        return weight;
    }

    @Override
    public double calories() {
        double sumOfCalories = 0;
        for (Ingredient ingredient : ingredients) {
            sumOfCalories+=ingredient.calories();
        }
        return sumOfCalories;
    }
private double countDishPrice(){
        double dishPrice =0 ;
    for (Ingredient ingredient : ingredients) {
        if(ingredient instanceof Dish){
            dishPrice+=((Dish) ingredient).getDISH_PRICE();
        }
        if(ingredient instanceof ValuableIngredient){
            dishPrice+=((ValuableIngredient) ingredient).ingredientPrice();
        }
    }return dishPrice;
}

    public double getDISH_PRICE() {
        return DISH_PRICE;
    }
}
