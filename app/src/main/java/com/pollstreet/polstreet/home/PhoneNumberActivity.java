package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.pollstreet.polstreet.R;

public class PhoneNumberActivity extends AppCompatActivity {

    RelativeLayout verifyNumberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        findIDs();
        verifyNumberBtn.setOnClickListener(v -> goToOTPActivity());
        LoginActivity.setTransparentStatusBar(getWindow(),this);
    }
    void goToOTPActivity(){
        Intent intent = new Intent(PhoneNumberActivity.this, OTPVerificationActivity.class);
        startActivity(intent);
        finish();
    }
    void findIDs()
    {
        verifyNumberBtn = findViewById(R.id.verifyNumber);
    }
}