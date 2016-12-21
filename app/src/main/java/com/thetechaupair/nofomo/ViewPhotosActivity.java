package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewPhotosActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private int position;
    private ArrayList<Photo> photos;
    private PhotoPagerAdapter photoPagerAdapter;

    private ViewPager photosViewPager;
    private TextView photosCountTextView;
    private TextView photosTitleTextView;
    private TextView photosDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        photosViewPager = (ViewPager)findViewById(R.id.photosViewPager);
        photosCountTextView = (TextView)findViewById(R.id.photosCountTextView);
        photosTitleTextView = (TextView)findViewById(R.id.photosTitleTextView);
        photosDateTextView = (TextView)findViewById(R.id.photosDateTextView);

        Bundle bundle = getIntent().getExtras();

        position = bundle.getInt("position", 0);
        photos = (ArrayList<Photo>) bundle.getSerializable("photos");

        photoPagerAdapter = new PhotoPagerAdapter(this, photos);
        photosViewPager.setAdapter(photoPagerAdapter);
        photosViewPager.addOnPageChangeListener(this);

        setCurrentItem(position);
    }

    private void setCurrentItem(int position) {
        photosViewPager.setCurrentItem(position, false);
        displayMetaInfo(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        displayMetaInfo(position);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void displayMetaInfo(int position) {
        photosCountTextView.setText((position + 1) + " of " + photos.size());

        Photo photo = photos.get(position);
        photosTitleTextView.setText(photo.getTitle());
        photosDateTextView.setText(photo.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent myIntent = new Intent(this, ProfileActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
