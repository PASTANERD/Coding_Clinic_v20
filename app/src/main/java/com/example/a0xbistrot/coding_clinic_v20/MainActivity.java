package com.example.a0xbistrot.coding_clinic_v20;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a0xbistrot.coding_clinic_v20.R;

public class MainActivity extends AppCompatActivity {

    String inputName;
    Button theButton;
    TextView variaed_text;
    EditText editName;
    Intent loginPhase;

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
