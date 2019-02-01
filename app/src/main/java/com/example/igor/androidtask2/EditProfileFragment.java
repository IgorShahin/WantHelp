package com.example.igor.androidtask2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.igor.androidtask2.dialog.ProfileDialog;

public class EditProfileFragment extends BaseFragment {

    ImageView profileImage;

    public static EditProfileFragment newInstance(){
        Bundle args = new Bundle();
        EditProfileFragment fragment = new EditProfileFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_profile, container, false);

        profileImage = v.findViewById(R.id.profile_pic);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        ((TextView)getActivity().findViewById(R.id.text_toolbar)).setText("Редактировать");

        Toolbar toolbar = getActivity().findViewById(R.id.toolBar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.icon_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).loadFragment(ProfileFragment.newInstance());
            }
        });

        return v;
    }

    public void openDialog(){
        ProfileDialog profileDialog = new ProfileDialog();
        profileDialog.show(getChildFragmentManager(), "ex");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_edit_profile, menu);
    }

    @Override
    protected void onReceiveBackPressed() {
        ((MainActivity)getActivity()).loadFragment(ProfileFragment.newInstance());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((Toolbar)getActivity().findViewById(R.id.toolBar)).setNavigationIcon(null);
    }
}
