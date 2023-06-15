package com.pradip.easycar.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pradip.easycar.R;


public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private TextView name, email, phone, address;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Profile");

        name = (TextView)view.findViewById(R.id.user_name);
        email = (TextView)view.findViewById(R.id.user_email);
        phone = (TextView)view.findViewById(R.id.user_phone);
        address = (TextView)view.findViewById(R.id.user_address);

        return view;
    }

}
