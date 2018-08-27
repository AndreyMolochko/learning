package com.example.user.roomandroid.imageLoader;

import android.widget.ImageView;

/**
 * Created by User on 27.08.2018.
 */

public class UIL {
    private ImageView imageView;
    private String imageUrl;

    public UIL(ImageView imageView, String imageUrl){
        this.imageView=imageView;
        this.imageUrl=imageUrl;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
