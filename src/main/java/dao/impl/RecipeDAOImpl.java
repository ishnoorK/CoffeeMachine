package dao.impl;

import dao.RecipeDAO;
import domain.Beverage;
import domain.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class RecipeDAOImpl implements RecipeDAO {

    private static Map<Beverage,Map<Ingredient, Integer>> beverageRecepies = new HashMap<>();

    @Override
    public Map<Ingredient, Integer> getBeverageRecipe(Beverage beverage) {
        return beverageRecepies.get(beverage);
    }

    @Override
    public void addBeverageRecepie(Beverage beverage, Map<Ingredient, Integer> ingredientQuantities) {
        beverageRecepies.put(beverage, ingredientQuantities);
    }
}
