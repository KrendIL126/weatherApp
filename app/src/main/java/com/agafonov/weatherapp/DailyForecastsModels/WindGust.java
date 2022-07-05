package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust {
    @SerializedName("Speed")
    @Expose
    private Speed__1 speed;
    @SerializedName("Direction")
    @Expose
    private Direction__1 direction;

    public Speed__1 getSpeed() {
        return speed;
    }

    public void setSpeed(Speed__1 speed) {
        this.speed = speed;
    }

    public Direction__1 getDirection() {
        return direction;
    }

    public void setDirection(Direction__1 direction) {
        this.direction = direction;
    }
}
