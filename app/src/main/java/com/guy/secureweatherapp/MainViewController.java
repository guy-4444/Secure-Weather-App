package com.guy.secureweatherapp;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.majorik.sparklinelibrary.SparkLineLayout;

import java.util.Locale;

public class MainViewController {

    private Activity activity;

    private SparkLineLayout main_SPC_graph;
    private ImageView main_IMG_back;
    private TextView main_LBL_city;
    private TextView main_LBL_temp;


    public MainViewController(Activity activity) {
        this.activity = activity;

        findViews();
    }

    private void findViews() {
        main_SPC_graph = activity.findViewById(R.id.main_SPC_graph);
        main_IMG_back = activity.findViewById(R.id.main_IMG_back);
        main_LBL_city = activity.findViewById(R.id.main_LBL_city);
        main_LBL_temp = activity.findViewById(R.id.main_LBL_temp);
    }


    public void changeBackground(String imageLink) {
        ImageUtils.putImageLinkIntoImageView(activity, imageLink, main_IMG_back);
    }

    public void updateUI(final Location location) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                main_LBL_city.setText(location.getCityName());
                main_LBL_temp.setText(String.format(Locale.US, "%.2f", location.getTemp()) + "°C");
                main_SPC_graph.setData(location.getHistory());
                main_SPC_graph.invalidate();
            }
        });
    }
}
