import domain.Beverage;
import domain.Ingredient;
import org.junit.Before;
import org.junit.Test;
import service.CoffeeMachineService;
import service.RecipeService;
import service.impl.CoffeeMachineServiceImpl;
import service.impl.RecipeServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is meant for testing the complete working of this project.
 */
public class CoffeeMachineTest {

    private CoffeeMachineService coffeeMachineService;

    @Test
    public void testNotAvailableCase(){
        coffeeMachineService.prepareBeverage(Beverage.GREEN_TEA);
    }

    @Test
    public void testScenario1() {
        coffeeMachineService.prepareBeverage(Beverage.HOT_TEA);
        coffeeMachineService.prepareBeverage(Beverage.HOT_COFFEE);
        coffeeMachineService.prepareBeverage(Beverage.GREEN_TEA);
        coffeeMachineService.prepareBeverage(Beverage.BLACK_TEA);
    }

    @Test
    public void testScenario2() {
        coffeeMachineService.prepareBeverage(Beverage.HOT_TEA);
        coffeeMachineService.prepareBeverage(Beverage.BLACK_TEA);
        coffeeMachineService.prepareBeverage(Beverage.GREEN_TEA);
        coffeeMachineService.prepareBeverage(Beverage.HOT_COFFEE);
    }

    @Test
    public void testScenario3() {
        coffeeMachineService.prepareBeverage(Beverage.HOT_COFFEE);
        coffeeMachineService.prepareBeverage(Beverage.BLACK_TEA);
        coffeeMachineService.prepareBeverage(Beverage.GREEN_TEA);
        coffeeMachineService.prepareBeverage(Beverage.HOT_TEA);
    }

    @Before
    public void initializeRecipes() {
        coffeeMachineService = new CoffeeMachineServiceImpl();
        RecipeService recipeService = new RecipeServiceImpl();

        // making tea
        Map<Ingredient, Integer> hotTeaIngredients = new HashMap<>();
        hotTeaIngredients.put(Ingredient.HOT_WATER, 200);
        hotTeaIngredients.put(Ingredient.HOT_MILK, 100);
        hotTeaIngredients.put(Ingredient.GINGER_SYRUP, 10);
        hotTeaIngredients.put(Ingredient.SUGAR_SYRUP, 10);
        hotTeaIngredients.put(Ingredient.TEA_LEAVES_SYRUP, 30);
        recipeService.addRecipe(Beverage.HOT_TEA, hotTeaIngredients);
        // making hot coffee
        Map<Ingredient, Integer> hotCoffeeIngredients = new HashMap<>();
        hotCoffeeIngredients.put(Ingredient.HOT_WATER, 100);
        hotCoffeeIngredients.put(Ingredient.HOT_MILK, 400);
        hotCoffeeIngredients.put(Ingredient.GINGER_SYRUP, 30);
        hotCoffeeIngredients.put(Ingredient.SUGAR_SYRUP, 50);
        hotCoffeeIngredients.put(Ingredient.TEA_LEAVES_SYRUP, 30);
        recipeService.addRecipe(Beverage.HOT_COFFEE, hotCoffeeIngredients);
        //making black tea
        Map<Ingredient, Integer> blackTeaIngredients = new HashMap<>();
        blackTeaIngredients.put(Ingredient.HOT_WATER, 300);
        blackTeaIngredients.put(Ingredient.GINGER_SYRUP, 30);
        blackTeaIngredients.put(Ingredient.SUGAR_SYRUP, 50);
        blackTeaIngredients.put(Ingredient.TEA_LEAVES_SYRUP, 30);
        recipeService.addRecipe(Beverage.BLACK_TEA, blackTeaIngredients);
        // making green tea
        Map<Ingredient, Integer> greenTeaIngredients = new HashMap<>();
        greenTeaIngredients.put(Ingredient.GREEN_MIXTURE, 30);
        greenTeaIngredients.put(Ingredient.HOT_WATER, 200);
        greenTeaIngredients.put(Ingredient.GINGER_SYRUP, 30);
        greenTeaIngredients.put(Ingredient.SUGAR_SYRUP, 50);
        recipeService.addRecipe(Beverage.GREEN_TEA, greenTeaIngredients);
    }
}
