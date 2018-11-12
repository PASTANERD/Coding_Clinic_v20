package com.example.a0xbistrot.codingcleanic_v20.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UserFragment extends BaseFragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user, container, false);

        return view;
    }
}
