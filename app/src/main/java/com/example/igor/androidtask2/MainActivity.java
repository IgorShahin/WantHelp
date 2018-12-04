package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    TextView textToolbar;
    private Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.fragment_news:
                    return true;
                case R.id.fragment_search:
                    return true;
                case R.id.fragment_heart: {
                    textToolbar.setText(getResources().getString(R.string.text_toolbar_heart));
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    loadFragment(CategoriesFragment.newInstance());
                    return true;
                }
                case R.id.fragment_history:
                    return true;
                case R.id.fragment_profile: {
                    toolbar.setNavigationIcon(null);
                    textToolbar.setText(getResources().getString(R.string.text_toolbar_profile));
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

        setContentView(R.layout.main_layout);

        toolbar = findViewById(R.id.toolb);
        textToolbar = findViewById(R.id.text_toolbar);
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
