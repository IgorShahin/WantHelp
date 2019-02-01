package com.example.igor.androidtask2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;

public class BaseFragment extends Fragment {

    public static final String ACTION_BACK_PRESSED = "ACTION_BACK_PRESSED";

    protected LocalBroadcastManager mManager;
    protected BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onReceiveBackPressed();
        }
    };

    protected IntentFilter mFilter = new IntentFilter(ACTION_BACK_PRESSED);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mManager = LocalBroadcastManager.getInstance(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        mManager.registerReceiver(mReceiver, mFilter);
    }

    @Override
    public void onPause() {
        mManager.unregisterReceiver(mReceiver);
        super.onPause();
    }

    protected void onReceiveBackPressed() {
        getActivity().finish();
    }
}
