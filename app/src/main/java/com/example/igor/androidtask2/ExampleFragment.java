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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class ExampleFragment extends Fragment {

    private RecyclerView recyclerSearch;
    private String[] arrList;

    ArrayList<SearchEntity>  searchEntities = new ArrayList<>();

    public static ExampleFragment newInstance(){
        Bundle args = new Bundle();
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_example, container, false);

        arrList = getResources().getStringArray(R.array.search_NKO);

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
        SecureRandom secureRandom = new SecureRandom();
        int randomSizeList = secureRandom.nextInt(arrList.length) + 1;

        ArrayList<Integer> randomElem = new ArrayList<>();
        for(int i = randomSizeList; i > 0; i--){
            randomElem.add(i);
        }
        Collections.shuffle(randomElem);

        for(int i = randomSizeList; i > 0; i--){
            searchEntities.add(new SearchEntity(arrList[(randomElem.get(randomElem.size() - i))-1]));
        }

        return searchEntities;
    }
}
