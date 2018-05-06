package com.richard;

import com.richard.strategy.Duck;
import com.richard.strategy.FlyRocketPowered;
import com.richard.strategy.MallardDuck;
import com.richard.strategy.ModelDuck;
import org.junit.Test;

public class StrategyTest {

    @Test
    public void TestMallardDuck(){
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
    }

    @Test
    public void TestModelDuck(){
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();

        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
