package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pollstreet.polstreet.R;

public class OTPVerificationActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    TextView editPhoneNumberTv;
    RelativeLayout verify_otp;
    Button verify_btn_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        findIds();
        editPhoneNumberTv.setOnClickListener(v -> editPhoneNumber());
        verify_otp.setOnClickListener(v -> {
            verify_otp.setVisibility(View.GONE);
            verify_btn_selected.setVisibility(View.VISIBLE);
            afterOtpVerified();
        });
        LoginActivity.setTransparentStatusBar(getWindow(),this);
        addListenerToEditText();
    }

    //adding listener to 4 otp edittext
    void addListenerToEditText(){
        et1.addTextChangedListener(new GenericTextWatcher(et1,et1,et2,et3,et4));
        et2.addTextChangedListener(new GenericTextWatcher(et2,et1,et2,et3,et4));
        et3.addTextChangedListener(new GenericTextWatcher(et3,et1,et2,et3,et4));
        et4.addTextChangedListener(new GenericTextWatcher(et4,et1,et2,et3,et4));
    }
    void findIds(){
        verify_otp            = findViewById(R.id.verify_otp_btn);
        verify_btn_selected   = findViewById(R.id.verifying_btn_selected);
        et1                   = findViewById(R.id.et1_otp);
        et2                   = findViewById(R.id.et2_otp);
        et3                   = findViewById(R.id.et3_otp);
        et4                   = findViewById(R.id.et4_otp);
        editPhoneNumberTv     = findViewById(R.id.edit_phone_number_tv);
    }

    //go back to phone number activity
    void editPhoneNumber(){
        Intent intent = new Intent(OTPVerificationActivity.this, PhoneNumberActivity.class);
        startActivity(intent);
        finish();
    }

    void afterOtpVerified()
    {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(OTPVerificationActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
        }, 2000);
    }
}


//Class for Switching Edittext
class GenericTextWatcher implements TextWatcher
{
    private final View view;
    EditText et1,et2,et3,et4;
    public GenericTextWatcher(View view, EditText et1,EditText et2,EditText et3,EditText et4)
    {
        this.view = view;
        this.et1=et1;
        this.et2=et2;
        this.et3=et3;
        this.et4=et4;
    }

    @Override
    public void afterTextChanged(Editable editable) {
        // TODO Auto-generated method stub
        String text = editable.toString();
        switch(view.getId())
        {

            case R.id.et1_otp:
                if(text.length()==1)
                    et2.requestFocus();
                break;
            case R.id.et2_otp:
                if(text.length()==1)
                    et3.requestFocus();
                else if(text.length()==0)
                    et1.requestFocus();
                break;
            case R.id.et3_otp:
                if(text.length()==1)
                    et4.requestFocus();
                else if(text.length()==0)
                    et2.requestFocus();
                break;
            case R.id.et4_otp:
                if(text.length()==0)
                    et3.requestFocus();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }
}