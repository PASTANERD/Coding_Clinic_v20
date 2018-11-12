package com.example.a0xbistrot.codingcleanic_v20.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingFragment extends BaseFragment {


    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_setting, container, false);


        return view;
    }
}
