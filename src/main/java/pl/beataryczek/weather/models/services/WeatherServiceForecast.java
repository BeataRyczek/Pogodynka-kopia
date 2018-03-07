package pl.beataryczek.weather.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.beataryczek.weather.models.Utils;
import pl.beataryczek.weather.models.WeatherModel;

public class WeatherServiceForecast {
    private static WeatherServiceForecast ourInstance = new WeatherServiceForecast();

    public static WeatherServiceForecast getInstance() {
        return ourInstance;
    }

    private WeatherServiceForecast() {
    }

    public WeatherModel getWeather(String city, int j){

    String websiteResponse = Utils.readWebsiteContent("http://http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",pl&appid=88095a62ecd9fee86c8365defdd57b25");
    String description = null;
    int temp=0;
    int pressure=0;
    int humidity =0;
    int clouds = 0;
    String dt_txt = null;

    JSONObject root = new JSONObject(websiteResponse);
    JSONArray listArray = root.getJSONArray("list");
    JSONObject elementListArray = listArray.getJSONObject(1);
    JSONObject mainObject = elementListArray.getJSONObject("main");

    temp = (int) mainObject.getFloat("temp");
    pressure = mainObject.getInt("pressure");
    humidity = mainObject.getInt("humidity");

    JSONArray weatherArray = elementListArray.getJSONArray("weather");
        for (int i = 0; i < weatherArray.length(); i++) {
            JSONObject elementInArrayWeather = weatherArray.getJSONObject(i);
            description = elementInArrayWeather.getString("description");
        }
        JSONObject cloudsObject = elementListArray.getJSONObject("clouds");
        clouds = cloudsObject.getInt("all");

        dt_txt=elementListArray.getString("dt_txt");


      return new WeatherModel
                .Builder(city)
                .setClouds(clouds)
                .setHumidity(humidity)
                .setPressure(pressure)
                .setTemperature(temp)
                .setWeatherComment(description)
                .setDt_txt(dt_txt)
                .build();

}
}