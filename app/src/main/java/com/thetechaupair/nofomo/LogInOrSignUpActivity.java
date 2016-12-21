package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInOrSignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSignUp;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_or_sign_up);

        buttonSignUp = (Button)findViewById(R.id.buttonSignUp);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);

        buttonSignUp.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignUp:

                break;
            case R.id.buttonSignIn:

                Intent intent = new Intent("com.thetechaupair.nofomo.MAINACTIVITY");
                startActivity(intent);

                break;
        }
    }
}
