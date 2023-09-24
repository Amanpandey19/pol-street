package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pollstreet.polstreet.R;

public class ProfileActivity extends AppCompatActivity {

    TextView goBack, verifyEmail, verifyPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        findIds();
        setStatusBarTextAndBgColor();

        goBack.setOnClickListener(v -> {
            finish();
        });

        verifyEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendVerficationBottomSheet bottomSheet = new SendVerficationBottomSheet();
                bottomSheet.show(getSupportFragmentManager(),
                        "SendVerificationBottomSheet");
            }
        });

        verifyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PhoneNumberVerificationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
            }
        });
    }

    private void findIds()
    {
        goBack = findViewById(R.id.gobacktohome);
        verifyEmail = findViewById(R.id.verify_email_tv);
        verifyPhone = findViewById(R.id.verify_phoneNumber_tv);
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