package com.agafonov.weatherapp.DailyForecastsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Night {
    @SerializedName("Icon")
    @Expose
    private Integer icon;
    @SerializedName("IconPhrase")
    @Expose
    private String iconPhrase;
    @SerializedName("HasPrecipitation")
    @Expose
    private Boolean hasPrecipitation;
    @SerializedName("PrecipitationType")
    @Expose
    private String precipitationType;
    @SerializedName("PrecipitationIntensity")
    @Expose
    private String precipitationIntensity;
    @SerializedName("ShortPhrase")
    @Expose
    private String shortPhrase;
    @SerializedName("LongPhrase")
    @Expose
    private String longPhrase;
    @SerializedName("PrecipitationProbability")
    @Expose
    private Integer precipitationProbability;
    @SerializedName("ThunderstormProbability")
    @Expose
    private Integer thunderstormProbability;
    @SerializedName("RainProbability")
    @Expose
    private Integer rainProbability;
    @SerializedName("SnowProbability")
    @Expose
    private Integer snowProbability;
    @SerializedName("IceProbability")
    @Expose
    private Integer iceProbability;
    @SerializedName("Wind")
    @Expose
    private Wind__1 wind;
    @SerializedName("WindGust")
    @Expose
    private WindGust__1 windGust;
    @SerializedName("TotalLiquid")
    @Expose
    private TotalLiquid__1 totalLiquid;
    @SerializedName("Rain")
    @Expose
    private Rain__1 rain;
    @SerializedName("Snow")
    @Expose
    private Snow__1 snow;
    @SerializedName("Ice")
    @Expose
    private Ice__1 ice;
    @SerializedName("HoursOfPrecipitation")
    @Expose
    private Double hoursOfPrecipitation;
    @SerializedName("HoursOfRain")
    @Expose
    private Double hoursOfRain;
    @SerializedName("HoursOfSnow")
    @Expose
    private Integer hoursOfSnow;
    @SerializedName("HoursOfIce")
    @Expose
    private Integer hoursOfIce;
    @SerializedName("CloudCover")
    @Expose
    private Integer cloudCover;
    @SerializedName("Evapotranspiration")
    @Expose
    private Evapotranspiration__1 evapotranspiration;
    @SerializedName("SolarIrradiance")
    @Expose
    private SolarIrradiance__1 solarIrradiance;

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    public String getShortPhrase() {
        return shortPhrase;
    }

    public void setShortPhrase(String shortPhrase) {
        this.shortPhrase = shortPhrase;
    }

    public String getLongPhrase() {
        return longPhrase;
    }

    public void setLongPhrase(String longPhrase) {
        this.longPhrase = longPhrase;
    }

    public Integer getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(Integer precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public Integer getThunderstormProbability() {
        return thunderstormProbability;
    }

    public void setThunderstormProbability(Integer thunderstormProbability) {
        this.thunderstormProbability = thunderstormProbability;
    }

    public Integer getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(Integer rainProbability) {
        this.rainProbability = rainProbability;
    }

    public Integer getSnowProbability() {
        return snowProbability;
    }

    public void setSnowProbability(Integer snowProbability) {
        this.snowProbability = snowProbability;
    }

    public Integer getIceProbability() {
        return iceProbability;
    }

    public void setIceProbability(Integer iceProbability) {
        this.iceProbability = iceProbability;
    }

    public Wind__1 getWind() {
        return wind;
    }

    public void setWind(Wind__1 wind) {
        this.wind = wind;
    }

    public WindGust__1 getWindGust() {
        return windGust;
    }

    public void setWindGust(WindGust__1 windGust) {
        this.windGust = windGust;
    }

    public TotalLiquid__1 getTotalLiquid() {
        return totalLiquid;
    }

    public void setTotalLiquid(TotalLiquid__1 totalLiquid) {
        this.totalLiquid = totalLiquid;
    }

    public Rain__1 getRain() {
        return rain;
    }

    public void setRain(Rain__1 rain) {
        this.rain = rain;
    }

    public Snow__1 getSnow() {
        return snow;
    }

    public void setSnow(Snow__1 snow) {
        this.snow = snow;
    }

    public Ice__1 getIce() {
        return ice;
    }

    public void setIce(Ice__1 ice) {
        this.ice = ice;
    }

    public Double getHoursOfPrecipitation() {
        return hoursOfPrecipitation;
    }

    public void setHoursOfPrecipitation(Double hoursOfPrecipitation) {
        this.hoursOfPrecipitation = hoursOfPrecipitation;
    }

    public Double getHoursOfRain() {
        return hoursOfRain;
    }

    public void setHoursOfRain(Double hoursOfRain) {
        this.hoursOfRain = hoursOfRain;
    }

    public Integer getHoursOfSnow() {
        return hoursOfSnow;
    }

    public void setHoursOfSnow(Integer hoursOfSnow) {
        this.hoursOfSnow = hoursOfSnow;
    }

    public Integer getHoursOfIce() {
        return hoursOfIce;
    }

    public void setHoursOfIce(Integer hoursOfIce) {
        this.hoursOfIce = hoursOfIce;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Evapotranspiration__1 getEvapotranspiration() {
        return evapotranspiration;
    }

    public void setEvapotranspiration(Evapotranspiration__1 evapotranspiration) {
        this.evapotranspiration = evapotranspiration;
    }

    public SolarIrradiance__1 getSolarIrradiance() {
        return solarIrradiance;
    }

    public void setSolarIrradiance(SolarIrradiance__1 solarIrradiance) {
        this.solarIrradiance = solarIrradiance;
    }
}
