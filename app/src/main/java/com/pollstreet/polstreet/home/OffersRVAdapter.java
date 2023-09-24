package com.pollstreet.polstreet.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pollstreet.polstreet.Model.Offers;
import com.pollstreet.polstreet.R;
import java.util.ArrayList;

public class OffersRVAdapter extends RecyclerView.Adapter<OffersRVAdapter.RecyclerviewHolder> {
    private ArrayList<Offers> offers;
    Context context;


    public OffersRVAdapter(Context context, ArrayList<Offers> offers) {
        this.context           = context;
        this.offers            = offers;
    }


    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_recylerview_item, parent, false);
        return new RecyclerviewHolder(mRootView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {

        holder.img.setImageDrawable(offers.get(position).getDrawable());


    }

    @Override
    public int getItemCount() {
        return offers.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            img            =   itemView.findViewById(R.id.recyclerViewItem);
        }

    }

}
