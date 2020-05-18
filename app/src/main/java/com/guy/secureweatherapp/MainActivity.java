package com.guy.secureweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.guy.secureweatherapp.model.Location;

public class MainActivity extends AppCompatActivity {

    private MainViewController mainViewController;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewController = new MainViewController(this);
        userPreferences = new UserPreferences();
        userPreferences.setTemp_type(UserPreferences.TEMP_Type.CELSIUS);


        initBackground();
        initData();
        splashScreen();
        settings();
        privacyPolicyPage();
    }

    private void privacyPolicyPage() {

    }

    private void settings() {

    }

    private void splashScreen() {

    }

    private void initData() {
        MyLocationManager.getCurrentLocationLatLon(this, callBack_location);
    }

    private MyLocationManager.CallBack_Location callBack_location = new MyLocationManager.CallBack_Location() {
        @Override
        public void locationReady(boolean success, double latitude, double longitude) {
            Logic.serverCallToGetWeatherForLocation(MainActivity.this, latitude, longitude, userPreferences, callBackLocationObject);
        }
    };

    private Logic.CallBackLocationObject callBackLocationObject = new Logic.CallBackLocationObject() {
        @Override
        public void locationReady(Location location) {
            mainViewController.updateUI(location);
        }
    };

    private void initBackground() {
        Logic.getBackgroundImage(this, callBackBackgroundData);
    }

    private Logic.CallBackData callBackBackgroundData = new Logic.CallBackData() {
        @Override
        public void responseReady(final String response) {
            // response - daily link
            mainViewController.changeBackground(response);
        }
    };

}
