package com.example.igor.androidtask2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.arlib.floatingsearchview.FloatingSearchView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingSearchView searchView;
    private BottomNavigationView navigationView;
    private ImageButton heartButton;

    public static final String SELECTED_MENU_ITEM_KEY   = "SelectedMenuItemId";
    public static final String SEARCH_KEY               = "SearchVisibility";

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.fragment_news:
                    return true;
                case R.id.fragment_search:
                    loadFragment(SearchFragment.newInstance());
                    return true;
                case R.id.fragment_heart: {
                    loadFragment(CategoriesFragment.newInstance());
                    return true;
                }
                case R.id.fragment_history:
                    return true;
                case R.id.fragment_profile: {
                    loadFragment(ProfileFragment.newInstance());
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("finish", false)) finish();

        setContentView(R.layout.main_layout);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        searchView = findViewById(R.id.searchView);

        navigationView = findViewById(R.id.menu);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.fragment_heart);

        heartButton = findViewById(R.id.heartButton);
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setSelectedItemId(R.id.fragment_heart);
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU_ITEM_KEY, navigationView.getSelectedItemId());
        outState.putInt(SEARCH_KEY, searchView.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        navigationView.setSelectedItemId(savedInstanceState.getInt(SELECTED_MENU_ITEM_KEY));
        searchView.setVisibility(savedInstanceState.getInt(SEARCH_KEY));
    }

    @Override
    public void onBackPressed() {
        LocalBroadcastManager mgr = LocalBroadcastManager.getInstance(this);
        mgr.sendBroadcast(new Intent(BaseFragment.ACTION_BACK_PRESSED));
    }
}