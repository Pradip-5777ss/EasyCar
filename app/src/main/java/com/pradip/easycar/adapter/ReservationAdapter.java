package com.pradip.easycar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.FullOrderActivity;
import com.pradip.easycar.R;
import com.pradip.easycar.models.ReservationObject;

import java.util.List;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {

    private static final String TAG = ReservationViewHolder.class.getSimpleName();

    private Context context;
    private List<ReservationObject> reservedList;

    public ReservationAdapter(Context context, List<ReservationObject> reservedList) {
        this.context = context;
        this.reservedList = reservedList;
    }


    @Override
    public ReservationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_layout, parent, false);
        return new ReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReservationViewHolder holder, int position) {
        ReservationObject rObject = reservedList.get(position);

        holder.carName.setText(rObject.getCarName());
        holder.location.setText(rObject.getPickUpLocation());
        holder.date.setText(rObject.getPickUpDate());
        holder.time.setText(rObject.getPickUpTime());
        holder.price.setText(rObject.getPrice());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderIntent = new Intent(context, FullOrderActivity.class);
                context.startActivity(orderIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservedList.size();
    }
}