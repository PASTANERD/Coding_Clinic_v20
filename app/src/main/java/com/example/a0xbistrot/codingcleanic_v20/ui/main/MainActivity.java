package com.example.a0xbistrot.codingcleanic_v20.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseActivity;
import com.example.a0xbistrot.codingcleanic_v20.ui.feed.FeedFragment;
import com.example.a0xbistrot.codingcleanic_v20.ui.search.SearchFragment;
import com.example.a0xbistrot.codingcleanic_v20.ui.setting.SettingFragment;
import com.example.a0xbistrot.codingcleanic_v20.ui.user.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setArgument();
        initFragments();

        findView();
        setBottomNavigationView();

        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_feed);

    }

    private void setArgument(){
        userID = getIntent().getStringExtra(USER_KEY);
        displayToast("Hello. "+ userID);


        initFragments();
    }

    private void initFragments(){
        feedFragment = new FeedFragment();
        searchFragment = new SearchFragment();
        settingFragment = new SettingFragment();
        userFragment = new UserFragment();

        fgManager.beginTransaction().add(R.id.main_fragment_board, feedFragment).hide(feedFragment)
                .add(R.id.main_fragment_board, searchFragment).hide(searchFragment)
                .add(R.id.main_fragment_board, settingFragment).hide(settingFragment)
                .add(R.id.main_fragment_board, userFragment).hide(userFragment)
                .commit();
    }

    private void settingFragments(Fragment fragment){
        fgTransaction = fgManager.beginTransaction();
        if(activeFragment != null) fgTransaction.hide(activeFragment);
        fgTransaction.show(fragment).commit();
        activeFragment = fragment;

    }

    private void findView(){
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void setBottomNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_menu_feed:
                        settingFragments(feedFragment);
                        return true;
                    case R.id.bottom_menu_search:
                        settingFragments(searchFragment);
                        return true;
                    case R.id.bottom_menu_setting:
                        settingFragments(settingFragment);
                        return true;
                    case R.id.bottom_menu_user:
                        settingFragments(userFragment);
                        return true;
                }

                return false;


            }
        });
    }

    private Fragment feedFragment;
    private Fragment searchFragment;
    private Fragment settingFragment;
    private Fragment userFragment;

    private final FragmentManager fgManager = getSupportFragmentManager();
    private FragmentTransaction fgTransaction;
    private Fragment activeFragment;
    private String userID;
    private BottomNavigationView bottomNavigationView;

    protected static final String USER_KEY = "USER_KEY";




}
