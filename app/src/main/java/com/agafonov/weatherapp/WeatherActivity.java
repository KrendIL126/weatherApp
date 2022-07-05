package com.agafonov.weatherapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.agafonov.weatherapp.HourlyForecastsModels.HourlyForecast;
import com.agafonov.weatherapp.LocationModels.Location;
import com.agafonov.weatherapp.DailyForecastsModels.CityWeather;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private CityWeather DailyForecast;
    private Location CoordsLocation;
    private List<HourlyForecast> hourlyForecast;
    private Gson gson;
    private String IMAGE_URL = "https://developer.accuweather.com/sites/default/files/";
    private TextView weatherActCity;
    private TextView weatherActTempepature;
    private ImageView weatherActDayImg;
    private TextView weatherActDayStatus;
    private TextView weatherActDayTempMin;
    private TextView weatherActDayTempMax;
    private TextView weatherActDayPrecipProbability;
    private TextView weatherActDayWindSpeed;
    private ImageView weatherActNightImg;
    private TextView weatherActNightStatus;
    private TextView weatherActNightTempMin;
    private TextView weatherActNightTempMax;
    private TextView weatherActNightPrecipProbability;
    private TextView weatherActNightWindSpeed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        gson = new Gson();
        CoordsLocation = gson.fromJson(getIntent().getExtras().getString("location"), Location.class);
        DailyForecast = gson.fromJson(getIntent().getExtras().getString("daily_forecast"), CityWeather.class);
        ArrayList<String> stringHourlyForecast = getIntent().getStringArrayListExtra("hourly_forecast");
        HourlyForecast forecast = gson.fromJson(stringHourlyForecast.get(0), HourlyForecast.class);
//        for(String s : stringHourlyForecast){
//            hourlyForecast.add(gson.fromJson(s, HourlyForecast.class));
//        }


//        LinearLayout layout = findViewById(R.id.weather_layout);
//        TableLayout table = findViewById(R.id.weather_layout_table);
//        TableRow row = new TableRow(this);
//        row.setLayoutParams(new
//                TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//
//        TextView tv = new TextView(this);
//        tv.setLayoutParams(new
//                TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//        tv.setText("Added tv");
//        tv.setPadding(10, 10, 10, 10);
//
//        row.addView(tv);
//        table.addView(row);
//        //layout.addView(tv);


        weatherActCity = findViewById(R.id.weather_act_city);
        weatherActTempepature = findViewById(R.id.weather_act_temperature);
        weatherActDayImg = findViewById(R.id.weather_act_day_img);
        weatherActDayStatus = findViewById(R.id.weather_act_day_status);
        weatherActDayTempMin = findViewById(R.id.weather_act_day_temp_min);
        weatherActDayTempMax = findViewById(R.id.weather_act_day_temp_max);
        weatherActDayPrecipProbability = findViewById(R.id.weather_act_day_precipitation_probability);
        weatherActDayWindSpeed = findViewById(R.id.weather_act_day_wind_speed);
        weatherActNightImg = findViewById(R.id.weather_act_night_img);
        weatherActNightStatus = findViewById(R.id.weather_act_night_status);
        weatherActNightTempMin = findViewById(R.id.weather_act_night_temp_min);
        weatherActNightTempMax = findViewById(R.id.weather_act_night_temp_max);
        weatherActNightPrecipProbability = findViewById(R.id.weather_act_night_precipitation_probability);
        weatherActNightWindSpeed = findViewById(R.id.weather_act_night_wind_speed);

        weatherActCity.setText(CoordsLocation.getLocalizedName());
        weatherActTempepature.setText(hourlyForecast.get(0).getTemperature().getValue() + hourlyForecast.get(0).getTemperature().getUnit());
        if (DailyForecast.getDailyForecasts().get(0).getDay().getIcon() < 10) {Picasso.get().load(IMAGE_URL + "0" + DailyForecast.getDailyForecasts().get(0).getDay().getIcon() + "-s.png").resize(375, 225).into(weatherActDayImg);}
        else {Picasso.get().load(IMAGE_URL + DailyForecast.getDailyForecasts().get(0).getDay().getIcon() + "-s.png").resize(375, 225).into(weatherActDayImg);}
        weatherActDayStatus.setText(DailyForecast.getDailyForecasts().get(0).getDay().getIconPhrase());
        weatherActDayTempMin.setText(DailyForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue() + DailyForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getUnit());
        weatherActDayTempMax.setText(DailyForecast.getDailyForecasts().get(0).getTemperature().getMaximum().getValue() + DailyForecast.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit());
        weatherActDayPrecipProbability.setText(DailyForecast.getDailyForecasts().get(0).getDay().getPrecipitationProbability() + "%");
        weatherActDayWindSpeed.setText(DailyForecast.getDailyForecasts().get(0).getDay().getWind().getSpeed().getValue() + DailyForecast.getDailyForecasts().get(0).getDay().getWind().getSpeed().getUnit());

        if (DailyForecast.getDailyForecasts().get(0).getNight().getIcon() < 10) {Picasso.get().load(IMAGE_URL + "0" + DailyForecast.getDailyForecasts().get(0).getNight().getIcon() + "-s.png").resize(375, 225).into(weatherActNightImg);}
        else {Picasso.get().load(IMAGE_URL + DailyForecast.getDailyForecasts().get(0).getNight().getIcon() + "-s.png").resize(375, 225).into(weatherActNightImg);}
        weatherActNightStatus.setText(DailyForecast.getDailyForecasts().get(0).getNight().getIconPhrase());
        weatherActNightTempMin.setText(DailyForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue() + DailyForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getUnit());
        weatherActNightTempMax.setText(DailyForecast.getDailyForecasts().get(0).getTemperature().getMaximum().getValue() + DailyForecast.getDailyForecasts().get(0).getTemperature().getMaximum().getUnit());
        weatherActNightPrecipProbability.setText(DailyForecast.getDailyForecasts().get(0).getNight().getPrecipitationProbability() + "%");
        weatherActNightWindSpeed.setText(DailyForecast.getDailyForecasts().get(0).getNight().getWind().getSpeed().getValue() + DailyForecast.getDailyForecasts().get(0).getNight().getWind().getSpeed().getUnit());


//        Picasso.get().load(IMAGE_URL + DailyForecast.getWeather().get(0).getIcon() + "@2x.png").into(weatherActImg);
//        weatherActCity.setText(coords_weather.getName());
//        weatherActStatus.setText(coords_weather.getWeather().get(0).getDescription());
//        weatherActTemp.setText(coords_weather.getMain().getTemp() + "°C");
//        weatherActFeelsLike.setText(coords_weather.getMain().getFeelsLike() + "°C");
//        weatherActPressure.setText(coords_weather.getMain().getPressure() + "мм рт. ст.");
//        weatherActHumidity.setText(coords_weather.getMain().getHumidity() + "%");
//        weatherActWindSpeed.setText(coords_weather.getWind().getSpeed() + "м/с");
    }
}
