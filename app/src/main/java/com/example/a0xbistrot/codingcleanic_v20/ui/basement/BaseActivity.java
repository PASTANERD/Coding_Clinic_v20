package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.upload.UploadActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class BaseActivity extends AppCompatActivity { // abstract화 한 이유 : BaseActivity 자체가 객체로 사용되는 것을 막음

    protected final String TAG = getClass().getSimpleName(); // Logcat에 이름을 적용하는 간단한 방법
    // Log.d(TAG, "message to know you anything.");

    protected boolean TOOLBAR_REQUEST = true;
    protected boolean TOOLBAR_NOT_REQUEST = false;
    protected Context context;
    Toolbar toolBar;
    protected RxPermissions rxPermissions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        initialize();
        findView();


    }

    private void initialize(){
        context = this;
        rxPermissions = new RxPermissions(this);

    }

    private void findView(){

    }

    protected void setToolbar(boolean flag){
        if(flag) {
            initToolBar(toolBar);
        }
    }

    protected void initToolBar(Toolbar toolbar){
        //Todo override

        toolbar = findViewById(R.id.toolbar);
        if(toolbar == null) initToolBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent uploadActivity = new Intent(context, UploadActivity.class);

        switch (item.getItemId()){
            case R.id.toolbar_upload:
                displayToast("upload selected");
                startActivity(uploadActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
