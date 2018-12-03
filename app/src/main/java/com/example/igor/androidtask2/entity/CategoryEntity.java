package com.example.igor.androidtask2.entity;

import android.graphics.drawable.Drawable;

public class CategoryEntity {

    private Drawable drawableImage;
    private String text;

    public CategoryEntity(Drawable drawableImage, String text) {
        this.drawableImage = drawableImage;
        this.text = text;
    }

    public Drawable getDrawableImage() {
        return drawableImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
