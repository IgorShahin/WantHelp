package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

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


        BottomNavigationView navigationView = findViewById(R.id.menu);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.fragment_heart);

    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }
}
