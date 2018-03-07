package pl.beataryczek.weather.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.beataryczek.weather.models.Utils;
import pl.beataryczek.weather.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherService {

    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() {
    }

    public WeatherModel getWeather(String city) {
        String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + ",pl&appid=88095a62ecd9fee86c8365defdd57b25");
        String description = null;
        int temperature;
        int pressure;
        int humidity;
        int clouds;

        JSONObject root = new JSONObject(websiteResponse);
        JSONArray weatherObject = root.getJSONArray("weather");
        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("main");
        }

        JSONObject main = root.getJSONObject("main");
        temperature = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

        JSONObject cloudsObject = root.getJSONObject("clouds");
        clouds = cloudsObject.getInt("all");


        return new WeatherModel
                .Builder(city)
                .setClouds(clouds)
                .setPressure(pressure)
                .setTemperature(temperature-273)
                .setWeatherComment(description)
                .setHumidity(humidity)
                .build();
    }



}



