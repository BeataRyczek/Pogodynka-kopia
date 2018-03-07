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

    String websiteResponse = Utils.readWebsiteContent("http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",pl&appid=88095a62ecd9fee86c8365defdd57b25");
    String description = null;
    int temperature;
    int pressure;
    int humidity ;
    int clouds ;
    String dt_txt = null;

    JSONObject root = new JSONObject(websiteResponse);
    JSONArray listArray = root.getJSONArray("list");
    JSONObject elementInArrayList = listArray.getJSONObject(j);

    JSONArray weatherObject = elementInArrayList.getJSONArray("weather");
        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("main");
        }
        JSONObject main = elementInArrayList.getJSONObject("main");

        temperature = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");

        JSONObject cloudsObject = elementInArrayList.getJSONObject("clouds");
        clouds = cloudsObject.getInt("all");

        dt_txt = elementInArrayList.getString("dt_txt");


      return new WeatherModel
                .Builder(city)
                .setClouds(clouds)
                .setHumidity(humidity)
                .setPressure(pressure)
                .setTemperature(temperature -273)
                .setWeatherComment(description)
                .setDt_txt(dt_txt)
                .build();

}
}