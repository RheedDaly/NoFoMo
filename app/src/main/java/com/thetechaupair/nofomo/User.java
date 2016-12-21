package com.thetechaupair.nofomo;

/**
 * Created by Rheed on 12/5/2016.
 */

public class User {

    private String username;
    private int imageResourceId;

    public User(String username, int imageResourceId) {
        this.username = username;
        this.imageResourceId = imageResourceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
