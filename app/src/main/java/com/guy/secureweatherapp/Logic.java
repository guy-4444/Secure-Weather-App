package com.guy.secureweatherapp;

import android.content.Context;
import android.widget.Toast;

import com.guy.secureweatherapp.model.Location;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class Logic {

    interface CallBackData {
        void responseReady(String response);
    }

    interface CallBackLocationObject {
        void locationReady(Location location);
    }

    public static Location buildLocationObject(String response, UserPreferences userPreferences) {
        Location location = new Location();

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (jsonObject == null) {
            return location;
        }

        try {
            String cityName = jsonObject.getString("name");
            JSONObject mainObject = jsonObject.getJSONObject("main");
            double temperature = mainObject.getDouble("temp");

            location.setCityName(cityName);
            if (userPreferences.getTemp_type() == UserPreferences.TEMP_Type.FAHRENHEIT) {
                temperature = temperature - 32;
            } else {
                temperature = Logic.convertCalvinToCelsius(temperature);
            }

            location.setTemp(temperature);

            for (int i = 0; i < 7; i++) {
                location.getHistory().add(new Random().nextInt(50));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return location;
    }

    public static void serverCallToGetWeatherForLocation(final Context context, double lat, double lon, final UserPreferences userPreferences, final CallBackLocationObject callBackLocationObject) {
        String api = Constants.OPEN_WEATHER_API + "&lat=" + lat + "&lon=" + lon;
        new ApiTask(
                context,
                api,
                new ApiTask.CallBack_Response() {
                    @Override
                    public void response(final boolean success, final String response) {
                        if (success) {
                            Location location = buildLocationObject(response, userPreferences);
                            callBackLocationObject.locationReady(location);
                        } else {
                            Toast.makeText(context, "Image Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        ).execute();
    }

    public static void getBackgroundImage(final Context context, final CallBackData callBackData) {
        String api = Constants.DAILY_BACKGROUND_API;
        new ApiTask(
                context,
                api,
                new ApiTask.CallBack_Response() {
                    @Override
                    public void response(final boolean success, final String response) {
                        if (success) {
                            callBackData.responseReady(response);
                        } else {
                            Toast.makeText(context, "Image Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        ).execute();
    }

    public static double convertCalvinToCelsius(double temperature) {
        return temperature - 273.15;
    }
}
