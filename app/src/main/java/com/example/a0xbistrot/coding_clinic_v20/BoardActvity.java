package com.example.a0xbistrot.coding_clinic_v20;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActvity extends AppCompatActivity {

    String givenName;
    //Intent backTologin;
    TextView mainName;
    BottomNavigationView btNavigation;

    int MAX_PAGE = 3;

    Fragment cur_fragment = new Fragment();

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

    public void setting() {
        //backTologin = new Intent(this,MainActivity.class);
        givenName = getIntent().getStringExtra("givenName");
        mainName = (TextView) findViewById(R.id.textName);
        btNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        //viewPager.setAdapter(new adapter(getSupportFragmentManager()));

        boardFragment = new BoardFragment();
        messageFragment = new MessageFragment();
        userFragment = new UserFragment();
        notificationFragment = new NotificationFragment();

        //fgManager = getSupportFragmentManager();
        //fgTransaction = fgManager.beginTransaction();

        if (givenName == null) {
            return;
        } else {
            mainName.setText(givenName);
        }


        btNavigation.setOnNavigationItemSelectedListener(navigationListener);

/*
        btNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.bottom_menu_board:
                        fgTransaction.replace(R.id.onBoard, boardFragment);
                        return true;
                        //break;
                    case R.id.bottom_menu_message:
                        fgTransaction.replace(R.id.onBoard, messageFragment);
                        fgTransaction.commit();
                        return true;
                        //break;
                    case R.id.bottom_menu_notification:
                        fgTransaction.replace(R.id.onBoard, notificationFragment);
                        fgTransaction.commit();
                        return true;
                        //break;
                    case R.id.bottom_menu_user:
                        fgTransaction.replace(R.id.onBoard, userFragment);
                        fgTransaction.commit();
                        return true;
                        //break;

                }
                return false;
            }
        });
    }
    */
/*
    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i<0 || MAX_PAGE <= i)  return null;
            switch(i){
                case 0:
                    cur_fragment = boardFragment;
                    break;
                case 1:
                    cur_fragment = notificationFragment;
                    break;
                case 2:
                    cur_fragment = messageFragment;
                    break;
                case 3:
                    cur_fragment = userFragment;
                    break;
            }

            return cur_fragment;

        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
        */
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.bottom_menu_board:
                    displayToast("board selected");
                    setFrag(0);
                    return true;
                case R.id.bottom_menu_message:
                    displayToast("message selected");
                    setFrag(1);
                    return true;
                case R.id.bottom_menu_notification:
                    displayToast("notifaction selected");
                    setFrag(2);
                    return true;
                case R.id.bottom_menu_user:
                    displayToast("user selected");
                    setFrag(3);
                    return true;
            }
            return false;
        }
    };

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void setFrag(int n){
        fgManager = getSupportFragmentManager();
        fgTransaction = fgManager.beginTransaction();

        switch(n){
            case 0:
                fgTransaction.replace(R.id.onBoard, boardFragment);
                fgTransaction.commit();
                break;
            case 1:
                fgTransaction.replace(R.id.onBoard, messageFragment);
                fgTransaction.commit();
                break;
            case 2:
                fgTransaction.replace(R.id.onBoard, notificationFragment);
                fgTransaction.commit();
                break;
            case 3:
                fgTransaction.replace(R.id.onBoard, userFragment);
                fgTransaction.commit();
                break;
        }
    }

}
