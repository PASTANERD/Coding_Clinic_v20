package com.example.a0xbistrot.coding_clinic_v20.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a0xbistrot.coding_clinic_v20.BaseActivity;
import com.example.a0xbistrot.coding_clinic_v20.R;

public class MainActivity extends BaseActivity {

    public static final String NAME_KEY = "NAME_KEY";

    private String inputName;
    private Button theButton;
    private TextView variaed_text;
    private EditText editName;
    private Intent loginPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setting();

    }




    public void buttonPush(View v){
        inputName = editName.getText().toString();
        if(inputName.length() == 0){
            displayToast("Please write your name.");
        }
        else {
            loginPhase.putExtra("givenName", inputName);
            startActivity(loginPhase);
        }
    }


    public void setting(){
        theButton = (Button)findViewById(R.id.theButton);
        variaed_text = (TextView)findViewById(R.id.centered_text);
        editName = (EditText)findViewById(R.id.editName);
        loginPhase = new Intent(this, BoardActvity.class);

    }

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
