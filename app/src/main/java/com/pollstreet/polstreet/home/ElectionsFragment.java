package com.pollstreet.polstreet.home;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pollstreet.polstreet.Model.ElectionsItem;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;
import java.util.Objects;


public class ElectionsFragment extends Fragment {

    RecyclerView recyclerView;
    ElectionsRVAdapter electionsRVAdapter;
    ArrayList<ElectionsItem> electionsItemArrayList;
    ImageView wallet;
    CardView walletCard;
    boolean walletOpened;
    CardView recyclerViewContainer;
    TextView goToAddMoney;
    TextView goback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elections, container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setStatusBarTextAndBgColor();

        findIds(view);

        electionsItemArrayList=new ArrayList<>();
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item),"By Polls"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item2),"Local Elections"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item3),"General Elections"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item4),"Assembly Elections"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item),"By Polls"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item2),"Local Elections"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item3),"General Elections"));
        electionsItemArrayList.add(new ElectionsItem(requireActivity().getDrawable(R.drawable.elections_item4),"Assembly Elections"));

        electionsRVAdapter = new ElectionsRVAdapter(requireContext(),electionsItemArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(electionsRVAdapter);

        wallet.setOnClickListener(v -> buildDialog());

        Animation animation= AnimationUtils.loadAnimation(requireContext(),R.anim.animate_slide_down_enter);
        recyclerView.setAnimation(animation);

        goback.setOnClickListener(v -> getParentFragmentManager().popBackStack());
    }

    private void findIds(View view){
        recyclerView            = view.findViewById(R.id.elections_rv);
        wallet                  = view.findViewById(R.id.openMyWallet);
        recyclerViewContainer   = view.findViewById(R.id.recyclerViewContainer);
        goback                  = view.findViewById(R.id.gobacktohome);
    }



    void setStatusBarTextAndBgColor(){
        Window window = requireActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.mainTheme1));
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
    }

    private void buildDialog() {
        final Dialog dialog=new Dialog(requireContext());
        dialog.setContentView(R.layout.wallet_card);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setGravity(Gravity.TOP);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);

        goToAddMoney = dialog.findViewById(R.id.goToAddMoney);
        goToAddMoney.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), AddMoneyActivity.class);
            startActivity(intent);
            requireActivity().overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
        });
        dialog.show();
    }
}