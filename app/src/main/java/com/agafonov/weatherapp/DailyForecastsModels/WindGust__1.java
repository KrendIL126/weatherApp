package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust__1 {
    @SerializedName("Speed")
    @Expose
    private Speed__3 speed;
    @SerializedName("Direction")
    @Expose
    private Direction__3 direction;

    public Speed__3 getSpeed() {
        return speed;
    }

    public void setSpeed(Speed__3 speed) {
        this.speed = speed;
    }

    public Direction__3 getDirection() {
        return direction;
    }

    public void setDirection(Direction__3 direction) {
        this.direction = direction;
    }
}
