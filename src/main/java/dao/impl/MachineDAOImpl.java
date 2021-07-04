package dao.impl;

import dao.MachineDAO;
import domain.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class MachineDAOImpl implements MachineDAO {

    private static Integer numberOfOutlets = 4;
    private static Map<Ingredient, Integer> ingredientsAvailable = new HashMap<>();

    public MachineDAOImpl(){
        ingredientsAvailable.put(Ingredient.HOT_WATER, 500);
        ingredientsAvailable.put(Ingredient.HOT_MILK,500);
        ingredientsAvailable.put(Ingredient.GINGER_SYRUP,100);
        ingredientsAvailable.put(Ingredient.SUGAR_SYRUP,100);
        ingredientsAvailable.put(Ingredient.TEA_LEAVES_SYRUP,100);
    }

    @Override
    public void consumeIngredients(Map<Ingredient, Integer> ingredientQuantities) {
        for(Ingredient ingredient : ingredientQuantities.keySet()){
            // deducting input ingredient quantities from ingredients available in system
            ingredientsAvailable.put(ingredient,
                    ingredientsAvailable.get(ingredient)-ingredientQuantities.get(ingredient));
        }
    }

    @Override
    public Map<Ingredient, Integer> getAvailableIngredientQuantities() {
        return ingredientsAvailable;
    }
}
