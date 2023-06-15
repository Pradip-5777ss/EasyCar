package com.pradip.easycar.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.ProductActivity;
import com.pradip.easycar.R;
import com.pradip.easycar.models.CarListObject;

import java.util.List;



public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>{

    private static final String TAG = CategoryAdapter.class.getSimpleName();

    private Context context;
    private List<CarListObject> carList;

    public CategoryAdapter(Context context, List<CarListObject> carList) {
        this.context = context;
        this.carList = carList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_car_layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        CarListObject carListObject = carList.get(position);
        holder.carType.setText(carListObject.getCarName());
        holder.carName.setText(carListObject.getCarName());
        holder.price.setText("$" + String.valueOf((int)carListObject.getPrice()));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carIntent = new Intent(context, ProductActivity.class);
                context.startActivity(carIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
