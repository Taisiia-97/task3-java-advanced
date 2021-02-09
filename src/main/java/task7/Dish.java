package task7;

public class Dish implements Ingredient {
private Ingredient[] ingredients;
private   double dishPrice;

    public Dish(Ingredient[] ingredients) {
        this.ingredients = ingredients;
       this.dishPrice =countDishPrice();
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
    for (Ingredient ingredient : ingredients) {
        if(ingredient instanceof Dish){
            dishPrice+=((Dish) ingredient).getDishPrice();
        }
        else if(ingredient instanceof ValuableIngredient){
            dishPrice+=((ValuableIngredient) ingredient).ingredientPrice();
        }
    }return dishPrice;
}

    public  double getDishPrice() {
        return dishPrice;
    }


}
