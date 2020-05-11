package com.guy.secureweatherapp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtils {

    public static void putImageLinkIntoImageView(Context context, String link, ImageView imageView) {
        Glide
                .with(context)
                .load(link)
                .centerCrop()
                .into(imageView);
    }
}
