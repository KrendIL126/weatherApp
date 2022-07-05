package com.agafonov.weatherapp.HourlyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust {
    @SerializedName("Speed")
    @Expose
    private Speed__1 speed;

    public Speed__1 getSpeed() {
        return speed;
    }

    public void setSpeed(Speed__1 speed) {
        this.speed = speed;
    }
}
