package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MaterialSearchView materialSearchView;

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

        materialSearchView = findViewById(R.id.searchView);

        BottomNavigationView navigationView = findViewById(R.id.menu);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigationView.setSelectedItemId(R.id.fragment_heart);

    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.searchMenu);
        materialSearchView.setMenuItem(menuItem);

        getMenuInflater().inflate(R.menu.menu_profile, menu);
        menu.findItem(R.id.profileMenu);
        return super.onCreateOptionsMenu(menu);
    }
}
