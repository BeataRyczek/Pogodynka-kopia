package pl.beataryczek.weather.models;

public class WeatherModel {

    private String cityName;
    private int temp;
    private int pressure;
    private int humidity;
    private int clouds;
    private String weatherComment;

    private WeatherModel(Builder builder) {
        cityName = builder.getCityName();
        temp = builder.getTemp();
        pressure = builder.getPressure();
        humidity = builder.getHumidity();
        clouds = builder.getClouds();
        weatherComment = builder.getWeatherComment();
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getWeatherComment() {
        return weatherComment;
    }

    public void setWeatherComment(String weatherComment) {
        this.weatherComment = weatherComment;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "cityName='" + cityName + '\'' +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", clouds=" + clouds +
                ", weatherComment='" + weatherComment + '\'' +
                '}';
    }


    public static class Builder{

        private String cityName;
        private int temp;
        private int pressure;
        private int humidity;
        private int clouds;
        private String weatherComment;

        public Builder(String cityName){
            this.cityName=cityName;
        }
        public Builder setTemp(int temp){
            this.temp = temp;
            return this;
        }
        public Builder setPressure(int pressure){
            this.pressure=pressure;
            return this;
        }
        public Builder setHumidity(int humidity){
            this.humidity=humidity;
            return this;
        }
        public Builder setClouds(int clouds){
            this.clouds=clouds;
            return this;
        }
        public Builder setWeatherComment(String weatherComment){
            this.weatherComment = weatherComment;
            return this;
        }



        public String getCityName() {
            return cityName;
        }

        public int getTemp() {
            return temp;
        }

        public int getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getClouds() {
            return clouds;
        }

        public String getWeatherComment() {
            return weatherComment;
        }

        public WeatherModel build(){
            return new WeatherModel(this);
        }
    }
}
