package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.pollstreet.polstreet.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        gotoLogin();

        //Setting status bar transparent
        LoginActivity.setTransparentStatusBar(getWindow(),this);
    }

    public void gotoLogin() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);
        }, 1000);
    }
}