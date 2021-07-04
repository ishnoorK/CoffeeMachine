package dao;

import domain.Beverage;
import domain.Ingredient;

import java.util.Map;

/**
 * This class holds all the information about the machine such as the number of outlets
 * and the total quantity of available ingredients.
 */
public interface MachineDAO {

    public void consumeIngredients(Map<Ingredient, Integer> ingredientQuantities);

    public Map<Ingredient, Integer> getAvailableIngredientQuantities();
}
