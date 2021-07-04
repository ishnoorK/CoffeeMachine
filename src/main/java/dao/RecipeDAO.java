package dao;

import domain.Beverage;
import domain.Ingredient;

import java.util.Map;

/**
 * This class contains information about the Recepies of all {@link Beverage}s
 */
public interface RecipeDAO {

    public Map<Ingredient, Integer> getBeverageRecipe(Beverage beverage);

    public void addBeverageRecepie(Map<Ingredient, Integer> ingredientQuantities);
}
