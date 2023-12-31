package com.pradip.easycar.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.CarCategoryActivity;
import com.pradip.easycar.R;
import com.pradip.easycar.models.CarCategoryObject;

import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingViewHolder>{

    private static final String TAG = ListingAdapter.class.getSimpleName();

    private Context context;

    private List<CarCategoryObject> carList;


    public ListingAdapter(Context context, List<CarCategoryObject> carList) {
        this.context = context;
        this.carList = carList;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_category_layout, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        CarCategoryObject carCategoryObject = carList.get(position);

        holder.carName.setText(carCategoryObject.getImageName());
        //holder.carImage
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carCategoryIntent = new Intent(context, CarCategoryActivity.class);
                context.startActivity(carCategoryIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
