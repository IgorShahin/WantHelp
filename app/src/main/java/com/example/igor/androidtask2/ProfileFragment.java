package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.igor.androidtask2.dialog.ProfileDialog;

public class ProfileFragment extends Fragment {

    ImageView profileImage;

    public static ProfileFragment newInstance(){
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_layout, container, false);

        profileImage = v.findViewById(R.id.imageProfile);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        return v;
    }

    public void openDialog(){
        ProfileDialog profileDialog = new ProfileDialog();
        profileDialog.show(getFragmentManager(), "ex");
    }
}
