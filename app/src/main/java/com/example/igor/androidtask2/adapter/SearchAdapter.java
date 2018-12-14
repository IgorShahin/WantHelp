package com.example.igor.androidtask2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igor.androidtask2.R;
import com.example.igor.androidtask2.entity.SearchEntity;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private ArrayList<SearchEntity> listSearch;

    public SearchAdapter(ArrayList<SearchEntity> listSearch) {
        this.listSearch = listSearch;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_item_view, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bindItem(listSearch.get(position));
    }

    @Override
    public int getItemCount() {
        return listSearch.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{

        private TextView searchTextView;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            searchTextView = itemView.findViewById(R.id.search_text_view);
        }

        public void bindItem(SearchEntity searchEntity) {
            searchTextView.setText(searchEntity.getText());
        }
    }
}
