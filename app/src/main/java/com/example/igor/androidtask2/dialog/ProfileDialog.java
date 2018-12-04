package com.example.igor.androidtask2.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.example.igor.androidtask2.R;

public class ProfileDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = View.inflate(getContext(), R.layout.dialog_item, null);

        view.findViewById(R.id.dialog_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Фото выбрано", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.dialog_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Снимок сделан", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.dialog_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Фото удалено", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        builder.setView(view);

        return builder.create();
    }
}
