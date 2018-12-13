package com.example.igor.androidtask2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.igor.androidtask2.ExampleFragment;
import com.example.igor.androidtask2.SearchEventFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);

        tabs = new String[]{
            "По мероприятиям",
            "По НКО"
        };
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return SearchEventFragment.newInstance();
            case 1:
                return ExampleFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
