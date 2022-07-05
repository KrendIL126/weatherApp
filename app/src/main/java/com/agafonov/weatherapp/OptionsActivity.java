package com.agafonov.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class OptionsActivity extends AppCompatActivity {
    private Spinner langSpinner;
    private Spinner systemSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        langSpinner = findViewById(R.id.language_spinner);
        systemSpinner = findViewById(R.id.system_spinner);

        ArrayList<String> languagesArray = new ArrayList<>();
        languagesArray.add("eng");
        languagesArray.add("rus");

        ArrayList<String> systemsArray = new ArrayList<>();
        systemsArray.add("метрическая");
        systemsArray.add("как в США");

        ArrayAdapter<String> langSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languagesArray);
        langSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(langSpinnerAdapter);
        //langSpinner.setSelection(0);

        ArrayAdapter<String> systemSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, systemsArray);
        systemSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSpinner.setAdapter(systemSpinnerAdapter);
        //langSpinner.setSelection(0);
    }
}