package com.thetechaupair.nofomo;

/**
 * Created by Rheed on 12/5/2016.
 */

public class Video {

    private int videoResourceId;
    private String videoTitle;

    public Video(int videoResourceId, String videoTitle) {
        this.videoResourceId = videoResourceId;
        this.videoTitle = videoTitle;
    }

    public int getVideoResourceId() {
        return videoResourceId;
    }

    public void setVideoResourceId(int videoResourceId) {
        this.videoResourceId = videoResourceId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}
