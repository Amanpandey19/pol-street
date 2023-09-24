package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pollstreet.polstreet.R;

public class AddMoneyActivity extends AppCompatActivity {

    TextView goBack;
    RadioGroup radioGroup;
    EditText amountToBeAdded;

    Button addMoney;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        goBack          = findViewById(R.id.goback);
        radioGroup      = findViewById(R.id.radio_group);
        amountToBeAdded = findViewById(R.id.amount_to_be_added);
        addMoney        = findViewById(R.id.add_money_btn);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.twohundred:
                    amountToBeAdded.setText("200");
                    break;
                case R.id.fivehundred:
                    amountToBeAdded.setText("500");
                    break;
                case R.id.oneThousand:
                    amountToBeAdded.setText("1000");
                    break;
                case R.id.twoThousand:
                    amountToBeAdded.setText("2000");
                    break;
                default:
                    break;
            }
        });

        setStatusBarTextAndBgColor();
        goBack.setOnClickListener(v -> finish());
        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMoneyActivity.this, PaymentActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
            }
        });
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