package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.igor.androidtask2.adapter.SearchAdapter;
import com.example.igor.androidtask2.entity.SearchEntity;

import java.util.ArrayList;

public class ExampleFragment extends Fragment {

    private RecyclerView recyclerSearch;

    ArrayList<SearchEntity> searchEntities = new ArrayList<>();

    public static ExampleFragment newInstance(){
        Bundle args = new Bundle();
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_example, container, false);

        recyclerSearch = v.findViewById(R.id.recyclerSearch);
        SearchAdapter searchAdapter = new SearchAdapter(getCategories());
        recyclerSearch.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recyclerSearch.setHasFixedSize(true);
        recyclerSearch.addItemDecoration(new DividerItemDecoration(v.getContext(), LinearLayoutManager.VERTICAL));
        recyclerSearch.setItemAnimator(new DefaultItemAnimator());

        recyclerSearch.setAdapter(searchAdapter);

        return v;
    }

    public ArrayList<SearchEntity> getCategories() {
        searchEntities.add(new SearchEntity("Во имя жизни"));
        searchEntities.add(new SearchEntity("Благотворительный Фонд В. Потанина"));
        searchEntities.add(new SearchEntity("Детские домики"));
        searchEntities.add(new SearchEntity("Мозайка счастья"));
        searchEntities.add(new SearchEntity("Благотворительный Фонд Алины"));

        return searchEntities;
    }
}
