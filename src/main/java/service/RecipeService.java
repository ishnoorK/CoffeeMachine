package service;

import domain.Beverage;
import domain.Ingredient;

import java.util.Map;

/**
 * This service is used to add a Recipe to the system, or read one for a {@link Beverage}
 */
public interface RecipeService {

    public void addRecipe(Map<Ingredient, Integer> ingredientQuantities);

    public Map<Ingredient, Integer> getRecipe(Beverage beverage);
}
