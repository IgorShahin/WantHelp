package com.example.igor.androidtask2.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.igor.androidtask2.ExampleFragment;
import com.example.igor.androidtask2.SearchEventFragment;

public class TabsPagerFragmentAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);

        tabs = new String[]{
            "По мероприятиям",
            "По НКО"
        };
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:{
                return SearchEventFragment.newInstance();
            }
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
