package service.impl;

import dao.MachineDAO;
import dao.impl.MachineDAOImpl;
import domain.Beverage;
import domain.Ingredient;
import service.CoffeeMachineService;
import service.RecipeService;

import java.util.Map;

/**
 * Service to vend out {@link Beverage}. This will be the service exposed to users.
 * All results will be written to system.out
 */
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    MachineDAO machineDAO = new MachineDAOImpl();
    RecipeService recipeService = new RecipeServiceImpl();

    private static final String CANNOT_BE_PREP_MESSAGE = " cannot be prepared because ";

    @Override
    public void prepareBeverage(Beverage beverage) {
        Map<Ingredient, Integer> recipe = recipeService.getRecipe(beverage);
        // basic validations
        if (recipe == null) {
            System.out.println("No recipe available for this beverage in the machine");
            return;
        }
        if (!areIngredientsAvailable(beverage, recipe)) {
            // appropriate error will be displayed
            return;
        }

        // Now we prepare and vend out the Beverage
        machineDAO.consumeIngredients(recipe);
        System.out.println(beverage.getDisplayName() + " is prepared");
    }

    private boolean areIngredientsAvailable(Beverage beverage, Map<Ingredient, Integer> recipe) {
        Map<Ingredient, Integer> availableIngredients = machineDAO.getAvailableIngredientQuantities();
        for (Ingredient ingredient : recipe.keySet()) {
            Integer quantity = availableIngredients.get(ingredient);
            // if the ingredient is absent -> not available
            if (quantity == null || quantity == 0) {
                System.out.println(beverage.getDisplayName() + CANNOT_BE_PREP_MESSAGE + ingredient.getDisplayName()
                        + " is not available");
                return false;
            }
            // if available quantity is less than required -> not sufficient
            if (quantity < recipe.get(ingredient)) {
                System.out.println(beverage.getDisplayName() + CANNOT_BE_PREP_MESSAGE + ingredient.getDisplayName()
                        + " is not sufficient");
                return false;
            }
        }
        // if all is successful, we return true
        return true;
    }
}
