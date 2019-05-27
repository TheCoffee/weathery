package com.coffee.weathery;

public class Weather {

    private String mainWeather;
    private String descWeather;
    private Double temp;
    private Double tempMin;
    private Double tempMax;
    private String city;

    public Weather(String mainWeather, String descWeather, Double temp, Double tempMin, Double tempMax, String city) {
        this.mainWeather = mainWeather;
        this.descWeather = descWeather;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.city = city;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getDescWeather() {
        return descWeather;
    }

    public void setDescWeather(String descWeather) {
        this.descWeather = descWeather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
