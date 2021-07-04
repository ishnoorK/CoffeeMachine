package service.impl;

import dao.RecipeDAO;
import dao.impl.RecipeDAOImpl;
import domain.Beverage;
import domain.Ingredient;
import service.RecipeService;

import java.util.Map;

/**
 * Service to read/write Recipes
 */
public class RecipeServiceImpl implements RecipeService {

    RecipeDAO recipeDAO = new RecipeDAOImpl();

    @Override
    public void addRecipe(Beverage beverage, Map<Ingredient, Integer> ingredientQuantities) {
        if (recipeDAO.getBeverageRecipe(beverage) != null) {
            // System.out.println("Updating the already existing recipe for " + beverage.getDisplayName());
        }
        recipeDAO.addBeverageRecepie(beverage, ingredientQuantities);
    }

    @Override
    public Map<Ingredient, Integer> getRecipe(Beverage beverage) {
        return recipeDAO.getBeverageRecipe(beverage);
    }
}
