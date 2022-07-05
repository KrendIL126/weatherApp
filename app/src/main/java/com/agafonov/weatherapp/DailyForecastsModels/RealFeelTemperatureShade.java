package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealFeelTemperatureShade {
    @SerializedName("Minimum")
    @Expose
    private Minimum__2 minimum;
    @SerializedName("Maximum")
    @Expose
    private Maximum__2 maximum;

    public Minimum__2 getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum__2 minimum) {
        this.minimum = minimum;
    }

    public Maximum__2 getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum__2 maximum) {
        this.maximum = maximum;
    }
}
