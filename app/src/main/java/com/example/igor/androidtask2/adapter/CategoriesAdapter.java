package com.example.igor.androidtask2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.androidtask2.R;
import com.example.igor.androidtask2.entity.CategoryEntity;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private ArrayList<CategoryEntity> listCategories;

    public CategoriesAdapter(ArrayList<CategoryEntity> listCategories) {
        this.listCategories = listCategories;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_view, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.bindItem(listCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return listCategories.size();
    }

    class CategoriesViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoriesImageView;
        private TextView categoriesTextView;

        public CategoriesViewHolder(View itemView) {
            super(itemView);
            categoriesImageView = itemView.findViewById(R.id.image_categories);
            categoriesTextView = itemView.findViewById(R.id.text_categories);
        }

        public void bindItem(CategoryEntity item){
            categoriesImageView.setImageDrawable(item.getDrawableImage());
            categoriesTextView.setText(item.getText());
        }
    }
}
