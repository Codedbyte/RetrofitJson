package com.codedbyte.retrofitjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Model> dataArray;
    private Context ctx;
    public CustomAdapter(Context ctx, ArrayList<Model> dataArray) {
        this.dataArray = dataArray;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_country, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(ctx).load(dataArray.get(i).getFlag()).into(viewHolder.imageView);
        viewHolder.country.setText(dataArray.get(i).getName());
        viewHolder.capital.setText(dataArray.get(i).getCapital());
    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }
}class ViewHolder extends RecyclerView.ViewHolder {
    TextView country, capital;
    CircleImageView imageView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        country = (TextView)itemView.findViewById(R.id.country);
        capital = (TextView)itemView.findViewById(R.id.capital);
        imageView = (CircleImageView)itemView.findViewById(R.id.flag);

    }
}