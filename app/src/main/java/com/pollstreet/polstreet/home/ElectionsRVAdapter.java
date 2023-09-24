package com.pollstreet.polstreet.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pollstreet.polstreet.Model.Bets;
import com.pollstreet.polstreet.Model.ElectionsItem;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;

public class ElectionsRVAdapter extends RecyclerView.Adapter<ElectionsRVAdapter.RecyclerviewHolder> {
    private ArrayList<ElectionsItem> electionsItemArrayList;
    Context context;


    public ElectionsRVAdapter(Context context, ArrayList<ElectionsItem> electionsItemArrayList) {
        this.context                             = context;
        this.electionsItemArrayList              = electionsItemArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.election_rv_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.img.setBackground((electionsItemArrayList.get(position).getImg()));
        holder.txt.setText(electionsItemArrayList.get(position).getHeading());

        holder.bet_now.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    holder.bet_now_img.setVisibility(View.VISIBLE);
                }else{
                    holder.bet_now_img.setVisibility(View.GONE);
                }
            }
        });

        holder.bet_now_txt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    holder.bet_now_img.setVisibility(View.VISIBLE);
                }else{
                    holder.bet_now_img.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return electionsItemArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        LinearLayout img;
        TextView  txt;
        LinearLayout bet_now;
        ImageView    bet_now_img;
        TextView     bet_now_txt;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            img                    =   itemView.findViewById(R.id.elections_list_item_img);
            txt                    =   itemView.findViewById(R.id.elections_list_item_text);
            bet_now                =   itemView.findViewById(R.id.bet_now_layout);
            bet_now_img            =   itemView.findViewById(R.id.bet_now_arrow);
            bet_now_txt            =   itemView.findViewById(R.id.bet_now_text);
        }

    }

}
