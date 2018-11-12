package com.example.a0xbistrot.codingcleanic_v20.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseActivity;

public class LoginActivity extends BaseActivity {

    private EditText login_id;
    private EditText login_pw;
    private Button login_button;
    private String data_id;
    private String data_pw;

    private Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setButton();

    }

    private void findView(){
        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_pw);
        login_button = findViewById(R.id.login_btn);

    }

    private void readInput(){
        data_id = login_id.getText().toString();
        data_pw = login_pw.getText().toString();
    }


    public void loginButton(View view){
        /*
        mainActivity = new Intent(context, MainActivity.class);
        readInput();
        if(data_id.length() == 0){
            displayToast("Please write your ID.");
        }
        else if(data_pw.length() == 0){
            displayToast("Please write your Password.");
        }
        else {
            mainActivity.putExtra(MainActivity.USER_KEY, data_id);
            //mainActivity.putExtra("userPassword", data_pw)
            startActivity(mainActivity);
        }
        */
    }

    private void setButton(){
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity = new Intent(context, MainActivity.class);
                readInput();
                if(data_id.length() == 0){
                    displayToast("Please write your ID.");
                }
                else if(data_pw.length() == 0){
                    displayToast("Please write your Password.");
                }
                else {
                    mainActivity.putExtra(MainActivity.USER_KEY, data_id);
                    //mainActivity.putExtra("userPassword", data_pw)
                    startActivity(mainActivity);
                }
            }
        });
    }


}
