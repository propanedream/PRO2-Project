package controller;

import model.Ingredient;

import java.util.HashMap;

public class IngredientController implements IngredientControllerI {

    private HashMap<String, Ingredient> ingredients;

    public IngredientController() {
        this.ingredients = new HashMap<>();
    }

    public HashMap<String, Ingredient> getIngredients() {
        return ingredients;
    }

    @Override

    public Ingredient storeIngredient(Ingredient ingredient) {
        Ingredient ingredientStored = ingredients.get(ingredient.getName());
        if (ingredientStored != null) {
            //if sætning der tjekker om unit er ens
            if (ingredientStored.getUnit() == ingredient.getUnit()) {
                ingredientStored.setAmount(ingredientStored.getAmount() + ingredient.getAmount());
                return ingredientStored;
            } else {
                throw new RuntimeException("Forkert enhed.");
            }
        } else {
            ingredients.put(ingredient.getName(), ingredient);
            return ingredient;
        }
    }

    @Override
    public void collectIngredient(String name, int amount) {
        Ingredient ingredientStored = ingredients.get(name);

        if (ingredientStored != null) {
            ingredientStored.setAmount(ingredientStored.getAmount() - amount);
        } else {
            String message = String.format("No supply of '%s' registered", name);
            throw new RuntimeException(message);
        }
    }
}
