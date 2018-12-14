package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.androidtask2.dialog.ProfileDialog;

public class ProfileFragment extends Fragment {

    ImageView profileImage;

    public static ProfileFragment newInstance(){
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
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

        ((TextView)getActivity().findViewById(R.id.text_toolbar)).setText("Профиль");

        ((Toolbar)getActivity().findViewById(R.id.toolBar)).setNavigationIcon(null);

        return v;
    }

    public void openDialog(){
        ProfileDialog profileDialog = new ProfileDialog();
        profileDialog.show(getFragmentManager(), "ex");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.searchMenu).setVisible(false);
        menu.findItem(R.id.profileMenu).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}
