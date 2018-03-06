package pl.beataryczek.weather.controllers;
import pl.beataryczek.weather.models.SaveToFile;
import pl.beataryczek.weather.models.services.WeatherService;
import pl.beataryczek.weather.models.services.WeatherServiceForecast;
import pl.beataryczek.weather.views.MainMenu;

public class MainController {
    private WeatherService weatherService = WeatherService.getInstance();
    //private WeatherServiceForecast weatherServiceForecast = WeatherServiceForecast.getInstance();
    private SaveToFile saveToFile;


    public MainController() {
        saveToFile = new SaveToFile();
    }

    public void run() {
        //todo test
        System.out.println(weatherService.getWeather("Kraków"));
       // System.out.println(weatherServiceForecast.getWeather("Kraków"));

        MainMenu mainMenu = new MainMenu();
        mainMenu.printMenu();

        WeatherService weatherService = WeatherService.getInstance();
        String city = mainMenu.getCityFromUser();
        String result = weatherService.getWeather(city).toString();

       // WeatherServiceForecast weatherServiceForecast = WeatherServiceForecast.getInstance();
       // String result1 = weatherServiceForecast.getWeather(city).toString();



        System.out.println(result);
       // System.out.println(result1);

        saveToFile.saveToFile(result, city);
       // saveToFile.saveToFile(result1, city);
    }

}