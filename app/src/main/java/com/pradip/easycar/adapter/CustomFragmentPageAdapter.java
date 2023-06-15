package com.pradip.easycar.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pradip.easycar.fragment.CancelledFragment;
import com.pradip.easycar.fragment.CompleteFragment;
import com.pradip.easycar.fragment.UpcomingFragment;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 3;


    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UpcomingFragment();
            case 1:
                return new CompleteFragment();
            case 2:
                return new CancelledFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Upcoming";
            case 1:
                return "Complete";
            case 2:
                return "Cancelled";
        }
        return null;
    }
}
