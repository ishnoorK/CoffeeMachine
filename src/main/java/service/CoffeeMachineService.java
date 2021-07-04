package service;

import domain.Beverage;

/**
 * This service handles user requests for {@link Beverage}s
 */
public interface CoffeeMachineService {

    public void prepareBeverage(Beverage beverage);

}
