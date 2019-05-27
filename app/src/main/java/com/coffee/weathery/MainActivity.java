package com.coffee.weathery;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etCity;
    private Button btnFetch;
    private TextView tvTemp, tvMinTemp, tvMaxTemp, tvWeather, tvDesc;
    private String apiKey = ""; // TODO: Replace with your API Key from Open Weather Maps
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etCity = findViewById(R.id.etCity);
        btnFetch = findViewById(R.id.btnFetch);
        tvTemp = findViewById(R.id.tvTemp);
        tvMinTemp = findViewById(R.id.tvMinTemp);
        tvMaxTemp = findViewById(R.id.tvMaxTemp);
        tvWeather = findViewById(R.id.tvWeather);
        tvDesc = findViewById(R.id.tvDesc);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = etCity.getText().toString();

                String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&units=metric&appid=" + apiKey;
                WeatherTask wt = new WeatherTask(new WeatherTaskCompleteListener() {
                    @Override
                    public void onWeatherTaskCompleted(Weather weather) {
                        //This will run once the weathertask finishes
                        tvTemp.setText(weather.getTemp() + "°C");
                        tvMaxTemp.setText(weather.getTempMax() + "°C");
                        tvMinTemp.setText(weather.getTempMin() + "°C");
                        tvWeather.setText(weather.getMainWeather());
                        tvDesc.setText(weather.getDescWeather());
                    }
                });
                wt.execute(url);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
