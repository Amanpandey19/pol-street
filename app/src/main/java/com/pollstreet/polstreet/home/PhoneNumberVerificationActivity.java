package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.pollstreet.polstreet.R;

public class PhoneNumberVerificationActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_verification);
        setStatusBarTextAndBgColor();
        findIds();
        addListenerToEditText();
    }
    void addListenerToEditText(){
        et1.addTextChangedListener(new OTPTextWatcher(et1,et1,et2,et3,et4));
        et2.addTextChangedListener(new OTPTextWatcher(et2,et1,et2,et3,et4));
        et3.addTextChangedListener(new OTPTextWatcher(et3,et1,et2,et3,et4));
        et4.addTextChangedListener(new OTPTextWatcher(et4,et1,et2,et3,et4));
    }
    void findIds(){
        et1                   = findViewById(R.id.et1_otp);
        et2                   = findViewById(R.id.et2_otp);
        et3                   = findViewById(R.id.et3_otp);
        et4                   = findViewById(R.id.et4_otp);
    }

    void setStatusBarTextAndBgColor(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.white));// set status background white
    }
}

class OTPTextWatcher implements TextWatcher
{
    private final View view;
    EditText et1,et2,et3,et4;
    public OTPTextWatcher(View view, EditText et1,EditText et2,EditText et3,EditText et4)
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