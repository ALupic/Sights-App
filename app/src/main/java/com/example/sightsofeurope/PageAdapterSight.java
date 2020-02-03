package com.example.sightsofeurope;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapterSight extends FragmentPagerAdapter {
    private int numOfTabs;

    PageAdapterSight(FragmentManager fm, int numOfTabs) {        // Communicates with CountryActivity
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {                             // Initializes the fragments for TabLayout
        switch (i) {
            case 0:
                return new SightInfoFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new ForumFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {                                 // Returns the number of tabs used
        return numOfTabs;
    }
}
