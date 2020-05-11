package com.guy.secureweatherapp;

import android.app.Activity;
import android.location.Location;
import android.util.Log;

import com.robin.locationgetter.EasyLocation;

public class MyLocationManager {

    public interface CallBack_Location {
        void locationReady(boolean success, double latitude, double longitude);
    }

    public static void getCurrentLocationLatLon(Activity activity, final CallBack_Location callBack_location) {
        EasyLocation easyLocation = new EasyLocation(activity, new EasyLocation.EasyLocationCallBack() {
            @Override
            public void permissionDenied() {
                Log.i("Location", "permission  denied");
                if (callBack_location != null) {
                    callBack_location.locationReady(false, 0, 0);
                }
            }

            @Override
            public void locationSettingFailed() {
                Log.i("Location", "setting failed");
                if (callBack_location != null) {
                    callBack_location.locationReady(false, 0, 0);
                }
            }

            @Override
            public void getLocation(Location location) {

                Log.i("Location_lat_lng", "Latitude= " + location.getLatitude() + " Longitude= " + location.getLongitude());
                if (callBack_location != null) {
                    callBack_location.locationReady(true, location.getLatitude(), location.getLongitude());
                }
            }
        });

    }
}
