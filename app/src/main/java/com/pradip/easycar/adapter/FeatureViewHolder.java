package com.pradip.easycar.adapter;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.R;

public class FeatureViewHolder extends RecyclerView.ViewHolder{

    public TextView title;
    public TextView detail;

    public FeatureViewHolder(View itemView) {
        super(itemView);

        title = (TextView)itemView.findViewById(R.id.car_feature_title);
        detail = (TextView)itemView.findViewById(R.id.car_price_title);

    }
}
