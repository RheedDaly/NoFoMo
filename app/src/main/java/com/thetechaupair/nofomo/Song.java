package com.thetechaupair.nofomo;

/*
 * This is demo code to accompany the Mobiletuts+ series:
 * Android SDK: Creating a Music Player
 * 
 * Sue Smith - February 2014
 */

public class Song {
	
	private long id;
	private String title;
	
	public Song(long songId, String songTitle, String songArtist){
		this.id = songId;
		this.title = songTitle;
	}
	
	public long getID(){
		return this.id;
	}

	public String getTitle(){
		return this.title;
	}

}
