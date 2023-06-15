package com.pradip.easycar.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pradip.easycar.R;
import com.pradip.easycar.adapter.CustomFragmentPageAdapter;


public class ReservationFragment extends Fragment {

    private static final String TAG = ReservationFragment.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;


    public ReservationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        getActivity().setTitle("Reservation");

        tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        viewPager = (ViewPager)view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new CustomFragmentPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
