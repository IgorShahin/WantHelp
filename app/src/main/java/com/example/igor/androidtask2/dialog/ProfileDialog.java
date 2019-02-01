package com.example.igor.androidtask2.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.example.igor.androidtask2.R;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class ProfileDialog extends DialogFragment {

    static final int GALLERY_REQUEST = 1;
    CircleImageView imageView;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View viewDialog = View.inflate(getContext(), R.layout.dialog_item, null);

        imageView = getParentFragment().getView().findViewById(R.id.profile_pic);

        viewDialog.findViewById(R.id.dialog_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.image_man_small);

                Toast.makeText(getContext(), "Фото выбрано", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        viewDialog.findViewById(R.id.dialog_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

                Toast.makeText(getContext(), "Снимок сделан", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        viewDialog.findViewById(R.id.dialog_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.user_icon);
                Toast.makeText(getContext(), "Фото удалено", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        builder.setView(viewDialog);

        return builder.create();
    }
}
