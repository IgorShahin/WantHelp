package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.example.igor.androidtask2.adapter.TabsPagerFragmentAdapter;

public class SearchFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingSearchView searchView;

    public static final String POSITION = "POSITION";

    public static SearchFragment newInstance(){
        Bundle arguments = new Bundle();
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView = getActivity().findViewById(R.id.searchView);

        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_layout, container, false);

        viewPager = v.findViewById(R.id.viewPager);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if(i == 0 && viewPager.getCurrentItem() == 0){
                    viewPager.getAdapter().notifyDataSetChanged();
                }
            }
        });

        tabLayout = v.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        searchView = getActivity().findViewById(R.id.searchView);
        searchView.setQueryTextSize(14);
        searchView.setQueryTextColor(R.color.black__38);
        searchView.setDismissOnOutsideClick(true);

        ((TextView)getActivity().findViewById(R.id.text_toolbar)).setText("Поиск");

        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, tabLayout.getSelectedTabPosition());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.searchMenu){
            searchView.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.search_scale_on);
            searchView.startAnimation(anim);
        }
        return true;
    }

    @Override
    protected void onReceiveBackPressed() {
        if(searchView.getVisibility() != View.GONE){
            searchView.setVisibility(View.GONE);

            Animation anim = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.search_scale_of);
            searchView.startAnimation(anim);
            searchView.clearQuery();
        }else ((BottomNavigationView)getActivity().findViewById(R.id.menu)).setSelectedItemId(R.id.fragment_heart);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        searchView.setVisibility(View.GONE);
        searchView.clearQuery();
    }
}
