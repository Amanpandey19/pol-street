package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pollstreet.polstreet.R;

public class AccountActivity extends AppCompatActivity {

    TextView goBack;
    RelativeLayout goToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findIds();
        setStatusBarTextAndBgColor();

        goBack.setOnClickListener(v -> {
            finish();
        });
        goToProfile.setOnClickListener(v -> launchProfileActivity());
    }


    private void findIds()
    {
        goBack      = findViewById(R.id.gobacktohome);
        goToProfile = findViewById(R.id.goToProfile);
    }

    private void launchProfileActivity(){
        Intent intent = new Intent(AccountActivity.this, ProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
    }

    void setStatusBarTextAndBgColor(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.mainTheme1));
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
    }
}