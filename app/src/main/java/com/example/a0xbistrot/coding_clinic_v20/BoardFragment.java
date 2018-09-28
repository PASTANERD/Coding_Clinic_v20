package com.example.a0xbistrot.coding_clinic_v20;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BoardFragment extends Fragment {

    TextView text_hello;
    String greetings[] = {"Hola!", "Bonjour!", "안녕!", "Ciao!", "Guten Tak!", "Hello!"};
    int i;

    View view;
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_board, container, false);
        setting();
        return view;
    }

    public void setting(){
        text_hello = (TextView)text_hello.findViewById(R.id.text_hello);

        i = 0;

    }


    public void buttonPush(View v){
        i= (i+1)%6;
        text_hello.setText(greetings[i]);

    }
}
