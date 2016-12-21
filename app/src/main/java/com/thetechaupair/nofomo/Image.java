package com.thetechaupair.nofomo;

import java.io.Serializable;

/**
 * Created by Lincoln on 04/04/16.
 */
public class Image implements Serializable{

    private int imageResourceId;
    private String name;
    private String small, medium, large;
    private String timestamp;

    public Image() {
    }

    public Image(int imageResourceId, String name) {
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public Image(String small, String medium, String large, String timestamp) {
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
