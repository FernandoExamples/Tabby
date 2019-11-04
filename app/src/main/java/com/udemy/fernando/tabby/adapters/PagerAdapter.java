package com.udemy.fernando.tabby.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.udemy.fernando.tabby.fragments.FormFragment;
import com.udemy.fernando.tabby.fragments.ListFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;
    private Fragment fragmets[];

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        fragmets = new Fragment[numberOfTabs];
    }

    @Override
    public Fragment getItem(int position) {

        if(fragmets[position] == null){
            switch (position){
                case 0:
                    fragmets[position] = new FormFragment();
                    break;
                case 1:
                    fragmets[position] = new ListFragment();

            }
        }

        return fragmets[position];
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
