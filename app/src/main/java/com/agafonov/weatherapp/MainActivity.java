package com.agafonov.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agafonov.weatherapp.HourlyForecastsModels.HourlyForecast;
import com.agafonov.weatherapp.LocationModels.Location;
import com.agafonov.weatherapp.DailyForecastsModels.CityWeather;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.directions.DirectionsFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.mapview.MapView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private MapView yandexMap;
    private Button weather_button;
    private RequestQueue queue;
    private Gson gson;
    private String MAP_API_KEY = "412a0bff-5aa2-4df8-aaa7-0643c332f056";
    private String WEATHER_API_KEY = "y3ahwb87KGACEASiWl6reJmRsUlAlS3d";
    private String LOCATION_URL = "https://dataservice.accuweather.com/locations/v1/cities/geoposition/search?&details=false";
    private String WEATHER_DAILY_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/1day/";
    private String WEATHER_HOURLY_URL = "https://dataservice.accuweather.com/forecasts/v1/hourly/12hour/291662?details=true";
    private String IMAGE_URL = "https://developer.accuweather.com/sites/default/files/";
    private CityWeather dailyForecast;
    private Location coordsLocation;
    private List<HourlyForecast> hourlyForecast;
    private Point pointTapped = new Point(53.380825, 83.725913);
    private Context context;
    private Toolbar toolbar;


    private final InputListener mapListener = new InputListener() {
        @Override
        public void onMapTap(@NonNull Map map, @NonNull Point point) {
            Toast.makeText(getApplicationContext(), "wait...", Toast.LENGTH_LONG).show();
            pointTapped = point;
            getCoordsLocation();
        }

        @Override
        public void onMapLongTap(@NonNull Map map, @NonNull Point point) {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_menu_options:
                Intent optionsIntent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(optionsIntent);
                break;
            case R.id.toolbar_menu_about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.toolbar_menu_libraries:
                Intent librariesIntent = new Intent(MainActivity.this, LibrariesActivity.class);
                startActivity(librariesIntent);
                break;
        }
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapKitFactory.setApiKey(MAP_API_KEY);
        MapKitFactory.initialize(this);
        DirectionsFactory.initialize(this);

        setContentView(R.layout.activity_main);
        context =this;
        yandexMap = findViewById(R.id.yandex_map);
        yandexMap.getMap().addInputListener(mapListener);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        weather_button = findViewById(R.id.get_weather_button);
        weather_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dailyForecast.getDailyForecasts() == null){
                    Toast.makeText(getApplicationContext(), "Выберите точку", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    intent.putExtra("location", gson.toJson(coordsLocation));
                    intent.putExtra("daily_forecast", gson.toJson(dailyForecast));

                    ArrayList<String> stringHourlyForecast = new ArrayList<String>();
                    for(HourlyForecast forecast : hourlyForecast){
                        stringHourlyForecast.add(gson.toJson(forecast));
                    }
                    intent.putStringArrayListExtra("hourly_forecast", stringHourlyForecast);
                    startActivity(intent);
                }
            }
        });



        gson = new Gson();
        queue = Volley.newRequestQueue(this);
        dailyForecast = new CityWeather();


    }

    @Override
    protected void onStop() {
        super.onStop();
        yandexMap.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        yandexMap.onStart();
        MapKitFactory.getInstance().onStart();
    }

    void getCoordsLocation() {
        StringRequest request = new StringRequest(
                0,
                LOCATION_URL + "&apikey=" + WEATHER_API_KEY + "&q=" + pointTapped.getLatitude() + "%2C%20" + pointTapped.getLongitude() + "&language=" + Locale.getDefault().getLanguage(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        coordsLocation = gson.fromJson(response, Location.class);
                        getDailyForecast();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Location Error :/", Toast.LENGTH_LONG).show();
                    }
                }
        );
        queue.add(request);
    }

    void getDailyForecast() {
        // Locale.getDefault().getLanguage()
        StringRequest request = new StringRequest(
                0,
                WEATHER_DAILY_URL + coordsLocation.getKey() + "?details=true&apikey=" + WEATHER_API_KEY + "&language=" + Locale.getDefault().getLanguage() + "&metric=" + true,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dailyForecast = gson.fromJson(response, CityWeather.class);
                        getHourlyForecast();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Daily Error :/", Toast.LENGTH_LONG).show();
                    }
                }
        );
        queue.add(request);
    }

    void getHourlyForecast(){
        StringRequest request = new StringRequest(
                0,
                WEATHER_HOURLY_URL + "&apikey=" + WEATHER_API_KEY + "&language=" + Locale.getDefault().getLanguage() + "&metric=" + true,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            hourlyForecast = new ArrayList<HourlyForecast>();
                            for(int i=0; i < jsonArray.length(); i++){
                                hourlyForecast.add(gson.fromJson(jsonArray.getString(i), HourlyForecast.class));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        LayoutInflater inflater = LayoutInflater.from(context);
                        View layout = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.custom_toast_container));


                        Toast toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        TextView textView = layout.findViewById(R.id.text);
                        textView.setText(coordsLocation.getLocalizedName());
                        ImageView imageView = layout.findViewById(R.id.image);
                        if (dailyForecast.getDailyForecasts().get(0).getDay().getIcon() < 10) {Picasso.get().load(IMAGE_URL + "0" + dailyForecast.getDailyForecasts().get(0).getDay().getIcon() + "-s.png").resize(150, 90).into(imageView);}
                        else {Picasso.get().load(IMAGE_URL + dailyForecast.getDailyForecasts().get(0).getDay().getIcon() + "-s.png").resize(150, 90).into(imageView);}
                        toast.show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Hourly Error :/", Toast.LENGTH_LONG).show();
                    }
                }
        );
        queue.add(request);
    }
}