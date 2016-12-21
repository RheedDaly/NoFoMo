package com.thetechaupair.nofomo;

import java.util.ArrayList;

/**
 * Created by Rheed on 12/2/2016.
 */

public class Post {

    private String username;
    private int imageResourceId;

    public Post(String username, int imageResourceId) {
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
