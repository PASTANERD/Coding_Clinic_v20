package com.example.a0xbistrot.coding_clinic_v20;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActvity extends AppCompatActivity {

    String givenName;
    Intent backTologin;
    TextView mainName;
    BottomNavigationView btNavigation;

    FragmentManager fgManager;
    FragmentTransaction fgTransaction;
    BoardFragment boardFragment;
    MessageFragment messageFragment;
    UserFragment userFragment;
    NotificationFragment notificationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_actvity);
        setting();

    }

    public void setting(){
        backTologin = new Intent(this,MainActivity.class);
        givenName = getIntent().getStringExtra("givenName");
        mainName = (TextView)findViewById(R.id.textName);
        btNavigation = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        boardFragment = new BoardFragment();
        messageFragment = new MessageFragment();
        userFragment = new UserFragment();
        notificationFragment = new NotificationFragment();

        fgManager = getFragmentManager();
        fgTransaction = fgManager.beginTransaction();

        if(givenName == null){
            return;
        }
        else{
            mainName.setText(givenName);
        }


        btNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.bottom_menu_board:
                        fgTransaction.replace(R.id.onBoard, boardFragment);
                        break;
                    case R.id.bottom_menu_message:
                        fgTransaction.replace(R.id.onBoard, messageFragment);
                        fgTransaction.commit();
                        break;
                    case R.id.bottom_menu_notification:
                        fgTransaction.replace(R.id.onBoard, notificationFragment);
                        fgTransaction.commit();
                        break;
                    case R.id.bottom_menu_user:
                        fgTransaction.replace(R.id.onBoard, userFragment);
                        fgTransaction.commit();
                        break;

                }
                return false;
            }
        });
    }


}
