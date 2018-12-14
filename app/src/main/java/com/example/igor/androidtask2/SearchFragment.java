package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igor.androidtask2.adapter.TabsPagerFragmentAdapter;

public class SearchFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static SearchFragment newInstance(){
        Bundle args = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_layout, container, false);

        viewPager = v.findViewById(R.id.viewPager);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        ((TextView)getActivity().findViewById(R.id.text_toolbar)).setText("Поиск");

        ((Toolbar)getActivity().findViewById(R.id.toolBar)).setNavigationIcon(null);

        return v;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.searchMenu).setVisible(true);
        menu.findItem(R.id.profileMenu).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }
}
