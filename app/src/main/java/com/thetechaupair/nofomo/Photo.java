package com.thetechaupair.nofomo;

import java.io.Serializable;

/**
 * Created by Rheed on 12/5/2016.
 */

public class Photo implements Serializable {

    private int imageResourceId;
    private String imageTitle;

    public Photo(int imageResourceId, String imageTitle) {
        this.imageResourceId = imageResourceId;
        this.imageTitle = imageTitle;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return imageTitle;
    }

    public void setTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }
}
