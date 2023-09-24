package com.pollstreet.polstreet.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.imageview.ShapeableImageView;
import com.pollstreet.polstreet.Model.Bets;
import com.pollstreet.polstreet.Model.Offers;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {

    RecyclerView horizontalRV;
    ArrayList<Offers> offers;
    OffersRVAdapter offersRVAdapter;
    RecyclerView betsRV;
    ArrayList<Bets> bets;
    BetsRVAdapter betsRVAdapter;
    Button elections_btn, events_btn;
    ShapeableImageView userImage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        horizontalRV  = view.findViewById(R.id.home_page_hz_recyclerview);
        betsRV        = view.findViewById(R.id.participating_bets_recycler_view);
        elections_btn = view.findViewById(R.id.elections_btn);
        events_btn    = view.findViewById(R.id.events_btn);
        userImage     = view.findViewById(R.id.user_image);

        setStatusBarTextAndBgColor();

        elections_btn.setOnClickListener(v -> launchElectionsScreen());
        events_btn.setOnClickListener(v -> launchEventsScreen());

        offers=new ArrayList<>();
        offers.add(new Offers(requireContext().getDrawable(R.drawable.list_item)));
        offers.add(new Offers(requireContext().getDrawable(R.drawable.list_item)));
        offers.add(new Offers(requireContext().getDrawable(R.drawable.list_item)));
        offers.add(new Offers(requireContext().getDrawable(R.drawable.list_item)));

        bets = new ArrayList<>();
        bets.add(new Bets(requireActivity().getDrawable(R.drawable.bet_img),getString(R.string.sample_bet_text)));
        bets.add(new Bets(requireContext().getDrawable(R.drawable.bet_img2),getString(R.string.sample_bet_text2)));
        bets.add(new Bets(requireContext().getDrawable(R.drawable.bet_img),getString(R.string.sample_bet_text)));

        betsRVAdapter = new BetsRVAdapter(getContext(),bets, requireActivity());
        betsRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        betsRV.setAdapter(betsRVAdapter);


        offersRVAdapter=new OffersRVAdapter(getContext(),offers);
        horizontalRV.setLayoutManager(new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        horizontalRV.setAdapter(offersRVAdapter);

        userImage.setOnClickListener(v -> launchAccountActivity());

    }

    void launchElectionsScreen(){
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().addToBackStack("Starting Elections Fragment").replace(R.id.flFragment, new ElectionsFragment()).commit();
    }

    void launchEventsScreen(){
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().addToBackStack("Starting Events Fragment").replace(R.id.flFragment, new EventsFragment()).commit();
    }

    void launchAccountActivity()
    {
        Intent intent = new Intent(getActivity(), AccountActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
    }

    void setStatusBarTextAndBgColor(){
        Window window = requireActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        window.setStatusBarColor(ContextCompat.getColor(requireContext(),R.color.white));// set status background white
    }
}