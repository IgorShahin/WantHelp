package com.example.igor.androidtask2.entity;

import android.widget.ImageView;

public class ProfileEntity {

    ImageView profileImage;
    String text;

    public ProfileEntity(ImageView profileImage, String text) {
        this.profileImage = profileImage;
        this.text = text;
    }

    public ImageView getProfileImage() {
        return profileImage;
    }

    public String getText() {
        return text;
    }
}
