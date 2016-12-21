package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(4000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent a = new Intent("com.thetechaupair.nofomo.LOGINORSIGNUPACTIVITY");
                    startActivity(a);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
