package com.thetechaupair.nofomo;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewVideosActivity extends AppCompatActivity {

    private static final int ANIM_DURATION = 600;
    private ImageView videoImageView;
    private TextView videoTitle;

    private int mLeftDelta;
    private int mTopDelta;
    private float mWidthScale;
    private float mHeightScale;

    private FrameLayout frameLayout;
    private ColorDrawable colorDrawable;

    private int thumbnailTop;
    private int thumbnailLeft;
    private int thumbnailWidth;
    private int thumbnailHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_videos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //retrieves the thumbnail data
        Bundle bundle = getIntent().getExtras();
        thumbnailTop = bundle.getInt("top");
        thumbnailLeft = bundle.getInt("left");
        thumbnailWidth = bundle.getInt("width");
        thumbnailHeight = bundle.getInt("height");

        String title = bundle.getString("title");
        int image = bundle.getInt("image");

        //Set image url
        videoImageView = (ImageView) findViewById(R.id.videoImageView);
        Picasso.with(this).load(image).into(videoImageView);

        //initialize and set the image description
        videoTitle = (TextView) findViewById(R.id.videoTitle);
        videoTitle.setText(title);

        //Set the background color to black
        frameLayout = (FrameLayout) findViewById(R.id.main_background);
        colorDrawable = new ColorDrawable(Color.BLACK);
        frameLayout.setBackground(colorDrawable);

        // Only run the animation if we're coming from the parent activity, not if
        // we're recreated automatically by the window manager (e.g., device rotation)
        if (savedInstanceState == null) {
            ViewTreeObserver observer = videoImageView.getViewTreeObserver();
            observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

                @Override
                public boolean onPreDraw() {
                    videoImageView.getViewTreeObserver().removeOnPreDrawListener(this);

                    // Figure out where the thumbnail and full size versions are, relative
                    // to the screen and each other
                    int[] screenLocation = new int[2];
                    videoImageView.getLocationOnScreen(screenLocation);
                    mLeftDelta = thumbnailLeft - screenLocation[0];
                    mTopDelta = thumbnailTop - screenLocation[1];

                    // Scale factors to make the large version the same size as the thumbnail
                    mWidthScale = (float) thumbnailWidth / videoImageView.getWidth();
                    mHeightScale = (float) thumbnailHeight / videoImageView.getHeight();

                    enterAnimation();

                    return true;
                }
            });
        }
    }

    /**
     * The enter animation scales the picture in from its previous thumbnail
     * size/location.
     */
    public void enterAnimation() {

        // Set starting values for properties we're going to animate. These
        // values scale and position the full size version down to the thumbnail
        // size/location, from which we'll animate it back up
        videoImageView.setPivotX(0);
        videoImageView.setPivotY(0);
        videoImageView.setScaleX(mWidthScale);
        videoImageView.setScaleY(mHeightScale);
        videoImageView.setTranslationX(mLeftDelta);
        videoImageView.setTranslationY(mTopDelta);

        // interpolator where the rate of change starts out quickly and then decelerates.
        TimeInterpolator sDecelerator = new DecelerateInterpolator();

        // Animate scale and translation to go from thumbnail to full size
        videoImageView.animate().setDuration(ANIM_DURATION).scaleX(1).scaleY(1).
                translationX(0).translationY(0).setInterpolator(sDecelerator);

        // Fade in the black background
        ObjectAnimator bgAnim = ObjectAnimator.ofInt(colorDrawable, "alpha", 0, 255);
        bgAnim.setDuration(ANIM_DURATION);
        bgAnim.start();

    }

    /**
     * The exit animation is basically a reverse of the enter animation.
     * This Animate image back to thumbnail size/location as relieved from bundle.
     *
     * @param endAction This action gets run after the animation completes (this is
     *                  when we actually switch activities)
     */
    public void exitAnimation(final Runnable endAction) {

        TimeInterpolator sInterpolator = new AccelerateInterpolator();
        videoImageView.animate().setDuration(ANIM_DURATION).scaleX(mWidthScale).scaleY(mHeightScale).
                translationX(mLeftDelta).translationY(mTopDelta)
                .setInterpolator(sInterpolator).withEndAction(endAction);

        // Fade out background
        ObjectAnimator bgAnim = ObjectAnimator.ofInt(colorDrawable, "alpha", 0);
        bgAnim.setDuration(ANIM_DURATION);
        bgAnim.start();
    }

    @Override
    public void onBackPressed() {
        exitAnimation(new Runnable() {
            public void run() {
                finish();
            }
        });
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
