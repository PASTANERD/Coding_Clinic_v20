package com.example.a0xbistrot.coding_clinic_v20.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a0xbistrot.coding_clinic_v20.BaseFragment;
import com.example.a0xbistrot.coding_clinic_v20.R;


public class BoardFragment extends BaseFragment {

    //TextView text_hello;
    Button button_tap;

    ImageView glide_image;
    String puppy_url;

    //String greetings[] = {"Hola!", "Bonjour!", "안녕!", "Ciao!", "Guten Tag!", "Hello!"};
    int i;

    View view;

    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_board, container, false);

        setting();
        glideLoad();
        return view;
    }


    public void setting(){
        //text_hello = (TextView)view.findViewById(R.id.text_hello);
        glide_image = (ImageView)view.findViewById(R.id.gilde_image);
        puppy_url = getResources().getString(R.string.glide_puppy_url);
        button_tap = (Button)view.findViewById(R.id.button_tap);
        //i = 0;

        /*
        button_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i= (i+1)%6;
                text_hello.setText(greetings[i]);
            }
        });
        */
    }


    public void buttonPush(View v){

    }

    private void glideLoad(){
        Glide.with(view).load(puppy_url).into(glide_image);
    }
}
