package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind__1 {
    @SerializedName("Speed")
    @Expose
    private Speed__2 speed;
    @SerializedName("Direction")
    @Expose
    private Direction__2 direction;

    public Speed__2 getSpeed() {
        return speed;
    }

    public void setSpeed(Speed__2 speed) {
        this.speed = speed;
    }

    public Direction__2 getDirection() {
        return direction;
    }

    public void setDirection(Direction__2 direction) {
        this.direction = direction;
    }
}
