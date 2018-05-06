package com.richard;

import com.richard.observer.CurrentConditionDisplay;
import com.richard.observer.CurrentConditionDisplayJdk;
import com.richard.observer.WeatherData;
import com.richard.observer.WeatherDataJdk;
import org.junit.Test;

public class ObserverTest {

    @Test
    public void weatherTest() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(38,42,30);
        weatherData.setMeasurements(23,42,30);
    }

    @Test
    public void weatherJdkTest() {
        WeatherDataJdk weatherData = new WeatherDataJdk();
        CurrentConditionDisplayJdk conditionDisplay = new CurrentConditionDisplayJdk(weatherData);
        weatherData.setMeasurements(38,42,30);
        weatherData.setMeasurements(23,42,30);
    }

}
