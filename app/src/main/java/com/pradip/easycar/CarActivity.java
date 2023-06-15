package com.pradip.easycar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.adapter.FeatureAdapter;
import com.pradip.easycar.models.FeatureObject;

import java.util.ArrayList;
import java.util.List;

public class CarActivity extends AppCompatActivity {

    private static final String TAG = CarActivity.class.getSimpleName();

    private ImageView carImage;

    private RecyclerView featureRecyclerView, priceRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setTitle("Toyota Camry");

        carImage = (ImageView)findViewById(R.id.selected_car);

        featureRecyclerView = (RecyclerView)findViewById(R.id.car_features);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        featureRecyclerView.setLayoutManager(linearLayoutManager);
        featureRecyclerView.setHasFixedSize(true);

        FeatureAdapter mAdapter = new FeatureAdapter(this, getTestData());
        featureRecyclerView.setAdapter(mAdapter);

        priceRecyclerView = (RecyclerView)findViewById(R.id.car_price);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        priceRecyclerView.setLayoutManager(linear);
        priceRecyclerView.setHasFixedSize(true);

        FeatureAdapter priceAdapter = new FeatureAdapter(this, getTestDataTwo());
        priceRecyclerView.setAdapter(priceAdapter);

        Button bookingButton = (Button)findViewById(R.id.continue_booking);
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookingIntent = new Intent(CarActivity.this, BookingActivity.class);
                startActivity(bookingIntent);
            }
        });
    }

    private List<FeatureObject> getTestData() {
        List<FeatureObject> testdata = new ArrayList<>();
        testdata.add(new FeatureObject("Mileage", "23 km"));
        testdata.add(new FeatureObject("Fuel Type", "Petrol"));
        testdata.add(new FeatureObject("Engine", "Automatic"));
        testdata.add(new FeatureObject("Number of Seats", "7 seaters"));
        testdata.add(new FeatureObject("Fuel Economy", "Yes"));
        return testdata;
    }

    private List<FeatureObject> getTestDataTwo() {
        List<FeatureObject> testdata = new ArrayList<>();
        testdata.add(new FeatureObject("Daily Price", "$120"));
        testdata.add(new FeatureObject("Total Amount", "$140"));
        return testdata;
    }
}
