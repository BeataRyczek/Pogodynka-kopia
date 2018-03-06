package pl.beataryczek.weather.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.beataryczek.weather.models.Utils;
import pl.beataryczek.weather.models.WeatherModel;

public class WeatherService {
    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() {
    }

    public WeatherModel getWeather(String city){

        String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + ",pl&appid=88095a62ecd9fee86c8365defdd57b25");
        String description = null;
        int temp=0;
        int pressure=0;
        int humidity =0;
        int clouds = 0;




        JSONObject root = new JSONObject(websiteResponse);  // root calosc JSON zawiera najwazniejsze elementy
        JSONArray weatherObject = root.getJSONArray("weather");  //obiekt "weather" - tab, iterujemy i dostajemu sie do indeksow
        for(int i =0; i<weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i); // poszczegolny element w tablicy

            description = elementInArray.getString("main"); // element.. nalezy do weather, odwolujemy sie do szcegolowego "main" w "weather"

        }
            JSONObject main = root.getJSONObject("main");
            temp = (int) main.getFloat("temp");
            pressure = main.getInt("pressure");
            humidity = main.getInt("humidity");

            JSONObject cloudsObject = root.getJSONObject("clouds");
            clouds = cloudsObject.getInt("all");



        return new WeatherModel
                .Builder(city)
                .setClouds(clouds)
                .setHumidity(humidity)
                .setPressure(pressure)
                .setTemp(temp)
                .setWeatherComment(description)
                .build();

    }



}
