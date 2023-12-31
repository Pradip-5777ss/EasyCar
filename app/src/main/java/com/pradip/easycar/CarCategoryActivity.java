package com.pradip.easycar;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pradip.easycar.adapter.CategoryAdapter;
import com.pradip.easycar.models.CarCategoryObject;
import com.pradip.easycar.models.CarListObject;

import java.util.ArrayList;
import java.util.List;

public class CarCategoryActivity extends AppCompatActivity {

    private static final String TAG = CarCategoryObject.class.getSimpleName();

    private RecyclerView carRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_category);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        setTitle("Toyota Cars");

        Spinner carOptionSpinner = (Spinner)findViewById(R.id.select_car_option);
        String[] optionSelect = getResources().getStringArray(R.array.car_option);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionSelect); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carOptionSpinner.setAdapter(spinnerArrayAdapter);

        carRecycler = (RecyclerView)findViewById(R.id.cars_in_category);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        carRecycler.setLayoutManager(linearLayoutManager);
        carRecycler.setHasFixedSize(true);

        CategoryAdapter mAdapter = new CategoryAdapter(CarCategoryActivity.this, getTestData());
        carRecycler.setAdapter(mAdapter);
    }

    private List<CarListObject> getTestData() {
        List<CarListObject> testData = new ArrayList<>();
        testData.add(new CarListObject(1, "Camry", "", "", "", "", "", "", 100));
        testData.add(new CarListObject(1, "Golf", "", "", "", "", "", "", 150));
        testData.add(new CarListObject(1, "Passat", "", "", "", "", "", "", 120));
        testData.add(new CarListObject(1, "Yaris", "", "", "", "", "", "", 130));
        testData.add(new CarListObject(1, "Benz", "", "", "", "", "", "", 200));
        return testData;
    }
}
