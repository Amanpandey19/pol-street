package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pollstreet.polstreet.R;

public class BetPaymentActivity extends AppCompatActivity {

    TextView addNewCard;
    TextView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet_payment);
        addNewCard = findViewById(R.id.add_new_card);
        goBack     = findViewById(R.id.goback);
        setStatusBarTextAndBgColor();
        addNewCard.setOnClickListener(v -> {
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bottomSheet.show(getSupportFragmentManager(),
                    "AddNewCardBottomSheet");
        });
        goBack.setOnClickListener(v -> finish());
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