package com.richard;

import com.richard.decorator.Beverage;
import com.richard.decorator.Espresso;
import com.richard.decorator.Mocha;
import org.junit.Test;

public class DecoratorTest {

    @Test
    public void coffeeTest() {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
            + " $" + beverage.cost());

        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());

    }
}
