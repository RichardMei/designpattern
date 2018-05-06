package com.richard.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayJdk implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplayJdk(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("Current conditions: " + this.temperature
                + "F degrees and " + this.humidity + "% humidity");
    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataJdk) {
            WeatherDataJdk weatherDataJdk = (WeatherDataJdk)o;
            this.temperature = weatherDataJdk.getTemperature();
            this.humidity = weatherDataJdk.getHumidity();
            display();
        }
    }
}
