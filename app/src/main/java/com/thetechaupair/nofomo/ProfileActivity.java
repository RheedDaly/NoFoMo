package com.thetechaupair.nofomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, RadioButton.OnCheckedChangeListener {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabPagerAdapter pagerAdapter;

    ImageView profilePicImageView;
    ImageView postsImageView;
    ImageView followersImageView;
    ImageView eventsImageView;
    ImageView liveEventsImageView;
    TextView UserNameTextView;
    Button followButton;
    ImageView biographyImageView;

    TextView titleTextView;
    RadioGroup radioGroupControls;
    RadioButton radioButtonPosts;
    RadioButton radioButtonPhotos;
    RadioButton radioButtonMusic;
    RadioButton radioButtonVideos;
    RadioButton radioButtonEvents;
    RadioButton radioButtonLiveEvents;

    ArrayList<RadioButton> radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        radioButtons = new ArrayList<RadioButton>();

//        profilePicImageView = (ImageView)findViewById(R.id.imageViewProfilePic);
//        postsImageView = (ImageView)findViewById(R.id.imageViewPosts);
//        followersImageView = (ImageView)findViewById(R.id.imageViewFollowers);
//        eventsImageView = (ImageView)findViewById(R.id.imageViewEvents);
//        liveEventsImageView = (ImageView)findViewById(R.id.imageViewLiveEvents);
//        UserNameTextView = (TextView)findViewById(R.id.textViewUserName);
//        followButton = (Button)findViewById(R.id.buttonFollow);
//        biographyImageView = (ImageView)findViewById(R.id.imageViewBiography);

        titleTextView = (TextView)findViewById(R.id.titleTextView);
        radioButtonPosts = (RadioButton)findViewById(R.id.radioButtonPosts);
        radioButtonPhotos = (RadioButton)findViewById(R.id.radioButtonPhotos);
        radioButtonMusic = (RadioButton)findViewById(R.id.radioButtonMusic);
        radioButtonVideos = (RadioButton)findViewById(R.id.radioButtonVideos);
        radioButtonEvents = (RadioButton)findViewById(R.id.radioButtonEvents);
        radioButtonLiveEvents = (RadioButton)findViewById(R.id.radioButtonLiveEvents);

//        profilePicImageView.setImageResource(R.drawable.rheed);
//        postsImageView.setImageResource(R.drawable.rheed);
//        followersImageView.setImageResource(R.drawable.rheed);
//        eventsImageView.setImageResource(R.drawable.rheed);
//        liveEventsImageView.setImageResource(R.drawable.rheed);
//        UserNameTextView.setOnClickListener(this);
//        followButton.setOnClickListener(this);
//        biographyImageView.setImageResource(R.drawable.info);

        profilePicImageView.setOnClickListener(this);
        postsImageView.setOnClickListener(this);
        followersImageView.setOnClickListener(this);
        eventsImageView.setOnClickListener(this);
        liveEventsImageView.setOnClickListener(this);
        biographyImageView.setOnClickListener(this);

        radioButtonPosts.setOnCheckedChangeListener(this);
        radioButtonPhotos.setOnCheckedChangeListener(this);
        radioButtonMusic.setOnCheckedChangeListener(this);
        radioButtonVideos.setOnCheckedChangeListener(this);
        radioButtonEvents.setOnCheckedChangeListener(this);
        radioButtonLiveEvents.setOnCheckedChangeListener(this);


        viewPager = (ViewPager)findViewById(R.id.pager);

        radioButtons.add(radioButtonPosts);
        radioButtons.add(radioButtonPhotos);
        radioButtons.add(radioButtonMusic);
        radioButtons.add(radioButtonVideos);
        radioButtons.add(radioButtonEvents);
        radioButtons.add(radioButtonLiveEvents);

        pagerAdapter = new TabPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new PostsActivity());
        pagerAdapter.addFragment(new PhotosActivity());
        pagerAdapter.addFragment(new MusicActivity());
        pagerAdapter.addFragment(new VideosActivity());
        pagerAdapter.addFragment(new EventsActivity());
        pagerAdapter.addFragment(new LiveEventsActivity());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        radioButtons.get(0).setChecked(true);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.imageViewProfilePic:
//                break;
//            case R.id.imageViewPosts:
//                viewPager.setCurrentItem(0);
//                break;
//            case R.id.imageViewFollowers:
//                Intent intent = new Intent("com.thetechaupair.nofomo.FOLLOWERSACTIVITY");
//                startActivity(intent);
//                break;
//            case R.id.imageViewEvents:
//                viewPager.setCurrentItem(4);
//                break;
//            case R.id.imageViewLiveEvents:
//                viewPager.setCurrentItem(5);
//                break;
//            case R.id.textViewUserName:
//                intent = new Intent("com.thetechaupair.nofomo.FOLLOWINGACTIVITY");
//                startActivity(intent);
//                break;
//            case R.id.buttonFollow:
//                break;
//            case R.id.imageViewBiography:
//                intent = new Intent("com.thetechaupair.nofomo.BIOGRAPHYACTIVITY");
//                startActivity(intent);
//                break;
//        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            onItemChecked(radioButtons.indexOf(compoundButton));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT).show();
        radioButtons.get(position).setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void onItemChecked(int position) {
        viewPager.setCurrentItem(position);
        titleTextView.setText(pagerAdapter.getPageTitle(position));
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

                Intent myIntent = new Intent(this, MainActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
