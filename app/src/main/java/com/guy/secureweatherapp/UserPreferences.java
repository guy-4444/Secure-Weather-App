package com.guy.secureweatherapp;

public class UserPreferences {

    enum TEMP_Type {
        CELSIUS,
        FAHRENHEIT
    }

    private TEMP_Type temp_type = TEMP_Type.FAHRENHEIT;

    public TEMP_Type getTemp_type() {
        return temp_type;
    }

    public UserPreferences setTemp_type(TEMP_Type temp_type) {
        this.temp_type = temp_type;
        return this;
    }

    public double getTempByPref(double calvinTemp) {
        if (temp_type == TEMP_Type.FAHRENHEIT) {
            return calvinTemp - 32;
        } else {
            return Logic.convertCalvinToCelsius(calvinTemp);
        }
    }
}
