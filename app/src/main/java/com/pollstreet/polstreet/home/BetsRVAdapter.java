package com.pollstreet.polstreet.home;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pollstreet.polstreet.Model.Bets;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;

public class BetsRVAdapter extends RecyclerView.Adapter<BetsRVAdapter.RecyclerviewHolder> {
    private ArrayList<Bets> bets;
    Context context;
    Activity activity;


    public BetsRVAdapter(Context context, ArrayList<Bets> bets, Activity activity) {
        this.context           = context;
        this.bets              = bets;
        this.activity          = activity;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bets_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(bets.get(position).getBetImg());
        holder.txt.setText(bets.get(position).getBetText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BetInformationActivity.class);
                context.startActivity(intent);
                //activity.overridePendingTransition(R.anim.animate_left_to_right,R.anim.animate_right_to_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bets.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView  txt;
        CardView  cardView;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            img            =   itemView.findViewById(R.id.bet_img);
            txt            =   itemView.findViewById(R.id.bet_text);
            cardView       =   itemView.findViewById(R.id.bet_card);
        }

    }

}
