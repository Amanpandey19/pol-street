package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pollstreet.polstreet.R;

public class LoginActivity extends AppCompatActivity {

    LinearLayout bgImage;
    LinearLayout loginHeading,loginContainer;
    Animation animation1,animation2;
    Button login_button;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findIDS();

        login_button.setOnClickListener(v -> {
            launchPhoneNumberActivity();
        });
        setAnim();
        setTransparentStatusBar(getWindow(), this);
        //updateScreen();
    }

    void  findIDS(){
        loginHeading    = findViewById(R.id.login_heading);
        bgImage         = findViewById(R.id.login_bg_image);
        loginContainer  = findViewById(R.id.login_btn_container);
        login_button    = findViewById(R.id.Login_btn);
    }
    void launchPhoneNumberActivity(){
        Intent intent = new Intent(LoginActivity.this, PhoneNumberActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
    }

    public static void setTransparentStatusBar(Window window, Activity activity){
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.BLACK);
    }
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void setAnim(){
        animation1   = AnimationUtils.loadAnimation(LoginActivity.this,R.anim.animate_slide_down_enter);
        animation2   = AnimationUtils.loadAnimation(LoginActivity.this,R.anim.animate_slide_up_enter);
        loginHeading.setAnimation(animation1);
        loginContainer.setAnimation(animation2);
    }

}