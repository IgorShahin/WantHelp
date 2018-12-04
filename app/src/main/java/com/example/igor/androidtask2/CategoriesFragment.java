package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.igor.androidtask2.adapter.CategoriesAdapter;
import com.example.igor.androidtask2.entity.CategoryEntity;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    final static int CATEGORIES_LAYOUT_SPAN_COUNT   =   2;

    private RecyclerView recyclerCategories;

    ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();

    public static CategoriesFragment newInstance(){
        return new CategoriesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.categories_layout, container, false);

        recyclerCategories = v.findViewById(R.id.recyclerCategory);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getCategories());
        recyclerCategories.setLayoutManager(new GridLayoutManager(v.getContext(), CATEGORIES_LAYOUT_SPAN_COUNT));
        recyclerCategories.setHasFixedSize(true);
        recyclerCategories.setAdapter(categoriesAdapter);

        return v;
    }

    public ArrayList<CategoryEntity> getCategories() {
        categoryEntities.add(new CategoryEntity(getResources().getDrawable(R.drawable.invalid_name), getResources().getString(R.string.Children)));
        categoryEntities.add(new CategoryEntity(getResources().getDrawable(R.drawable.adults), getResources().getString(R.string.Adults)));
        categoryEntities.add(new CategoryEntity(getResources().getDrawable(R.drawable.aged), getResources().getString(R.string.Aged)));
        categoryEntities.add(new CategoryEntity(getResources().getDrawable(R.drawable.animals), getResources().getString(R.string.Animals)));
        categoryEntities.add(new CategoryEntity(getResources().getDrawable(R.drawable.arrangement), getResources().getString(R.string.Arrangement)));

        return categoryEntities;
    }
}
