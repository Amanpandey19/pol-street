package com.pollstreet.polstreet.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.tabs.TabLayout;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;
import java.util.Objects;

public class BetInformationActivity extends AppCompatActivity {

    LineChart lineChart;
    ArrayList<ILineDataSet> dataSets=new ArrayList<>();

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    BetTabsAdapter betTabsAdapter;
    ImageView openMyWallet;

    CardView walletCard;
    TextView goToAddMoney;
    TextView goback;
    LinearLayout containerLayout;
    RadioGroup radioGroup;
    TextView amount;
    Button buyBtn;
    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bet_information);
        setStatusBarTextAndBgColor();
        lineChart    = findViewById(R.id.line_chart);
        tabLayout    = findViewById(R.id.tabLayout);
        viewPager2   = findViewById(R.id.viewPager);
        openMyWallet = findViewById(R.id.openMyWallet);
        goback       = findViewById(R.id.goback);
        containerLayout = findViewById(R.id.container_layout);
        radioGroup      = findViewById(R.id.radio_group);
        amount          = findViewById(R.id.amount);
        buyBtn          = findViewById(R.id.buy_btn);

        betTabsAdapter = new BetTabsAdapter(this);
        viewPager2.setAdapter(betTabsAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animate_slide_down_enter);
        containerLayout.setAnimation(animation);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });

        setGraph();

        openMyWallet.setOnClickListener(v -> {
            buildDialog();
        });

        goback.setOnClickListener(v -> finish());


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId)
            {
                case R.id.buy_yes:
                    buyBtn.setText("Buy Yes");
                    amount.setText("₹200");
                    break;
                case R.id.buy_no:
                    buyBtn.setText("Buy No");
                    amount.setText("₹180");
                default:
                    break;
            }
        });

        buyBtn.setOnClickListener(v -> {
            Intent intent = new Intent(BetInformationActivity.this, BetPaymentActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
        });
    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataValue =new ArrayList<>();
        dataValue.add(new Entry(0,63));
        dataValue.add(new Entry(16,78));
        dataValue.add(new Entry(24,73));
        dataValue.add(new Entry(38,90));
        dataValue.add(new Entry(47,82));
        dataValue.add(new Entry(62,95));
        dataValue.add(new Entry(74,82));
        dataValue.add(new Entry(80,95));

        return dataValue;
    }

    void setStatusBarTextAndBgColor(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.mainTheme1));
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
    }

    void setGraph()
    {
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"");

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.graph_bg);
        lineDataSet1.setDrawFilled(true);
        lineDataSet1.setFillDrawable(drawable);
        lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet1.setHighlightEnabled(false);
        lineDataSet1.setDrawValues(false);
        lineDataSet1.setCircleColor(R.color.mainTheme1);
        lineDataSet1.setDrawCircles(true);
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        YAxis yAxisRight = lineChart.getAxisRight();
        XAxis xAxis = lineChart.getXAxis();
        yAxisRight.setEnabled(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setLabelCount(4);
        xAxis.setDrawLabels(false);
        setupGradient(lineChart);
        lineDataSet1.setLineWidth(2);
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.invalidate();
    }


    private void setupGradient(LineChart mChart) {
        Paint paint = mChart.getRenderer().getPaintRender();
        int height = mChart.getHeight();

        LinearGradient linGrad = new LinearGradient(0, 0, 0, height,
                getResources().getColor(R.color.mainTheme1),
                getResources().getColor(R.color.mainTheme1),
                Shader.TileMode.REPEAT);
        paint.setShader(linGrad);
    }


    private void buildDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.wallet_card);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setGravity(Gravity.TOP);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;

        goToAddMoney = dialog.findViewById(R.id.goToAddMoney);
        goToAddMoney.setOnClickListener(v -> {
            Intent intent = new Intent(BetInformationActivity.this, AddMoneyActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
        });
        dialog.show();
    }
}