package com.example.a0xbistrot.coding_clinic_v20.fragment;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a0xbistrot.coding_clinic_v20.BaseFragment;
import com.example.a0xbistrot.coding_clinic_v20.R;

public class BoardFragment extends BaseFragment {

    TextView text_hello;
    Button button_tap;
    String greetings[] = {"Hola!", "Bonjour!", "안녕!", "Ciao!", "Guten Tag!", "Hello!"};
    int i;

    View view;

    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_board, container, false);

        setting();
        return view;
    }


    public void setting(){
        text_hello = (TextView)view.findViewById(R.id.text_hello);
        button_tap = (Button)view.findViewById(R.id.button_tap);
        i = 0;

        button_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i= (i+1)%6;
                text_hello.setText(greetings[i]);
            }
        });
    }


    public void buttonPush(View v){

    }
}
