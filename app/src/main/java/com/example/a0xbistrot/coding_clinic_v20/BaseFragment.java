package com.example.a0xbistrot.coding_clinic_v20;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

public class BaseFragment extends Fragment{

    protected final String TAG = getClass().getSimpleName();
    protected Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        context = getContext();
    }
}
