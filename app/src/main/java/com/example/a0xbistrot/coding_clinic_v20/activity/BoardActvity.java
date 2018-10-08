package com.example.a0xbistrot.coding_clinic_v20.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a0xbistrot.coding_clinic_v20.BaseActivity;
import com.example.a0xbistrot.coding_clinic_v20.adapter.RecyclerAdapter;
import com.example.a0xbistrot.coding_clinic_v20.fragment.BoardFragment;
import com.example.a0xbistrot.coding_clinic_v20.fragment.MessageFragment;
import com.example.a0xbistrot.coding_clinic_v20.fragment.NotificationFragment;
import com.example.a0xbistrot.coding_clinic_v20.R;
import com.example.a0xbistrot.coding_clinic_v20.fragment.UserFragment;
import com.example.a0xbistrot.coding_clinic_v20.object.ViewItem;

import java.util.ArrayList;

public class BoardActvity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_actvity);
        setting();

    }

    public void setting() {
        givenName = getIntent().getStringExtra("givenName");
        mainName = (TextView) findViewById(R.id.textName);
        btNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);


        FragmentSetting();

        ToolbarSetting();

        if (givenName == null) {
            return;
        } else {
            mainName.setText(givenName);
        }



        btNavigation.setOnNavigationItemSelectedListener(navigationListener);

    }

    private void ToolbarSetting() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

    }

    private void FragmentSetting() {
        boardFragment = new BoardFragment();
        messageFragment = new MessageFragment();
        userFragment = new UserFragment();
        notificationFragment = new NotificationFragment();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
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

    public void setFrag(int n) {
        fgManager = getSupportFragmentManager();
        fgTransaction = fgManager.beginTransaction();

        switch (n) {
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

    private void RecyclerViewSetting(){
        recyclerView = findViewById(R.id.recyclerView_board);
        recyclerView.setHasFixedSize(true);
        recyclerManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerManager);

        ArrayList<ViewItem> viewItemArrayList = new ArrayList<>();

        //TODO Item 내용물 채울것.
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic1, "PASTANERD", "Day3. #pamplona #iruña #pilgrim #buencamino #인생여행 #주륵주륵"));
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic2, "PASTANERD", "Day3. #pamplona #iruña #pilgrim #buencamino #인생여행"));
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic3, "PASTANERD", "Day10. With another pilgrim~ #leon #león #buencamino #caminodesantiago #pilgrimage #pilgrim #caminofrances #travel #spain #travelphotography #스페인 #여행 #여행스타그램 #순례길 #인생여행 #우정여행 #부엔까미노 #까미노데산티아고\n"));
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic4, "PASTANERD", "Day12. Camino and dawn #astorga #caminodesantiago #buencamino #caminofrances #pilgrim #pilgrimage #peregrino #travel #spain #travelphotography #trip #순례길 #아스토르가 #부엔까미노 #까미노데산티아고 #스페인 #여행 #여행스타그램 #인생여행 #우정여행"));
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic5, "PASTANERD", "Day7. 황금빛 땅 Golden Land in Los Arcos. #losarcos #pilgrim #buencamino #caminodesantiago #travel #spain #travelphotography #rural #여행 #인생여행 #스페인 #산티아고 #순례길 #힐링"));
        viewItemArrayList.add(new ViewItem(R.drawable.content_pic6, "PASTANERD", "Day7. Touch the sky #luquin #pilgrim #buencamino #caminodesantiago #travel #spain #인생여행 #여행 #스페인 #순례길"));


        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(viewItemArrayList);

        recyclerView.setAdapter(recyclerAdapter);
    }


    String givenName;
    TextView mainName;

    BottomNavigationView btNavigation;

    FragmentManager fgManager;
    FragmentTransaction fgTransaction;
    BoardFragment boardFragment;
    MessageFragment messageFragment;
    UserFragment userFragment;
    NotificationFragment notificationFragment;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerManager;


}
