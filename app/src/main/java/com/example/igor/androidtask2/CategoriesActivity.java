package com.example.igor.androidtask2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.igor.androidtask2.adapter.CategoriesAdapter;

import java.util.ArrayList;

public class CategoriesActivity extends Activity {

    final static int CATEGORIES_LAYOUT_SPAN_COUNT   =   2;

    final static String CATEGORY_NAME_ONE_COUNT     = "Дети";
    final static String CATEGORY_NAME_TWO_COUNT     = "Взрослые";
    final static String CATEGORY_NAME_THREE_COUNT   = "Пожилые";
    final static String CATEGORY_NAME_FOUR_COUNT     = "Животные";
    final static String CATEGORY_NAME_FIVE_COUNT    = "Мероприятия";

    private Toolbar toolbar;
    private RecyclerView recyclerCategories;

    private ArrayList<Drawable> categoriesImageURL = new ArrayList<>();
    private ArrayList<String> categoriesText = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.categories_layout);

        recyclerCategories = findViewById(R.id.recyclerCategory);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getCategoriesImageURL(), getCategoriesText());
        recyclerCategories.setLayoutManager(new GridLayoutManager(this, CATEGORIES_LAYOUT_SPAN_COUNT));
        recyclerCategories.setHasFixedSize(true);
        recyclerCategories.setAdapter(categoriesAdapter);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public ArrayList<Drawable> getCategoriesImageURL() {
        categoriesImageURL.add(getResources().getDrawable(R.drawable.invalid_name));
        categoriesImageURL.add(getResources().getDrawable(R.drawable.adults));
        categoriesImageURL.add(getResources().getDrawable(R.drawable.aged));
        categoriesImageURL.add(getResources().getDrawable(R.drawable.animals));
        categoriesImageURL.add(getResources().getDrawable(R.drawable.arrangement));

        return categoriesImageURL;
    }

    public ArrayList<String> getCategoriesText() {
        categoriesText.add(CATEGORY_NAME_ONE_COUNT);
        categoriesText.add(CATEGORY_NAME_TWO_COUNT);
        categoriesText.add(CATEGORY_NAME_THREE_COUNT);
        categoriesText.add(CATEGORY_NAME_FOUR_COUNT);
        categoriesText.add(CATEGORY_NAME_FIVE_COUNT);

        return categoriesText;
    }

}
