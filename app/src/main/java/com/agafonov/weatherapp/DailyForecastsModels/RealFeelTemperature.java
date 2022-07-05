package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealFeelTemperature {
    @SerializedName("Minimum")
    @Expose
    private Minimum__1 minimum;
    @SerializedName("Maximum")
    @Expose
    private Maximum__1 maximum;

    public Minimum__1 getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum__1 minimum) {
        this.minimum = minimum;
    }

    public Maximum__1 getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum__1 maximum) {
        this.maximum = maximum;
    }
}
