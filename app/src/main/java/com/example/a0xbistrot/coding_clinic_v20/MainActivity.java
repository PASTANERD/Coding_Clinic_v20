package com.example.a0xbistrot.coding_clinic_v20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a0xbistrot.coding_clinic_v20.R;

public class MainActivity extends AppCompatActivity {

    Button theButton;
    TextView variaed_text;
    int i = 0;
    String greeting[] = {"Hello!", "Hola!", "안녕!", "Ciao!", "Bonjour!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theButton = (Button)findViewById(R.id.theButton);
        variaed_text = (TextView)findViewById(R.id.centered_text);

    }

    public void buttonPush(View v){

        i = (i+1)%5;
        variaed_text.setText(greeting[i]);
    }


}
