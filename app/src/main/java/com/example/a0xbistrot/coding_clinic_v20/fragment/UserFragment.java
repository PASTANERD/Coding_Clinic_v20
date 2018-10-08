package com.example.a0xbistrot.coding_clinic_v20.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0xbistrot.coding_clinic_v20.BaseFragment;
import com.example.a0xbistrot.coding_clinic_v20.R;

public class UserFragment extends BaseFragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_user, container, false);

        return view;
    }
}