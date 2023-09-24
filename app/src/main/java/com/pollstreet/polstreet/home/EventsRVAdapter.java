package com.pollstreet.polstreet.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pollstreet.polstreet.Model.ElectionsItem;
import com.pollstreet.polstreet.R;

import java.util.ArrayList;

public class EventsRVAdapter extends RecyclerView.Adapter<EventsRVAdapter.RecyclerviewHolder> {
    private ArrayList<ElectionsItem> electionsItemArrayList;
    Context context;


    public EventsRVAdapter(Context context, ArrayList<ElectionsItem> electionsItemArrayList) {
        this.context                             = context;
        this.electionsItemArrayList              = electionsItemArrayList;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_rv_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.img.setBackground((electionsItemArrayList.get(position).getImg()));
        holder.txt.setText(electionsItemArrayList.get(position).getHeading());
    }

    @Override
    public int getItemCount() {
        return electionsItemArrayList.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        RelativeLayout img;
        TextView  txt;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            img            =   itemView.findViewById(R.id.events_list_item_img);
            txt            =   itemView.findViewById(R.id.events_list_item_text);
        }

    }

}
