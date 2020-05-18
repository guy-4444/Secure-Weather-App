package com.guy.secureweatherapp.model;

import java.util.ArrayList;

public class Location {

    private String cityName = "";
    private double temp = 0;
    private ArrayList<Integer> history = new ArrayList<>();

    public Location() {
    }

    public String getCityName() {
        return cityName;
    }

    public Location setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public double getTemp() {
        return temp;
    }

    public Location setTemp(double temp) {
        this.temp = temp;
        return this;
    }

    public ArrayList<Integer> getHistory() {
        return history;
    }

    public Location setHistory(ArrayList<Integer> history) {
        this.history = history;
        return this;
    }
}
