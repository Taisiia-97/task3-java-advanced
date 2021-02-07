package task7;

public interface ValuableIngredient extends Valuable, Ingredient {
    @Override
    double weight();

    @Override
    double calories();

    @Override
    double ingredientPrice();
}
