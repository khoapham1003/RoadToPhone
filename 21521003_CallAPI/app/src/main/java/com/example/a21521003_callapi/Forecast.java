package com.example.a21521003_callapi;

public class Forecast {
    private String city;
    private double temperature;
    private double wind;
    private double humidity;
    private double visibility;
    private String photo;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhotesrc(String photo) {
        this.photo = photo;
    }
    //{"city":"Ho Chi Minh City","temperature":30.0,"wind":16.0,"humidity":0.92,"visibility":9.66,"photo":"https://mfiles.alphacoders.com/701/701818.jpg"}
}
