package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.a0xbistrot.codingcleanic_v20.R;

public class BaseActivity extends AppCompatActivity { // abstract화 한 이유 : BaseActivity 자체가 객체로 사용되는 것을 막음

    protected final String TAG = getClass().getSimpleName(); // Logcat에 이름을 적용하는 간단한 방법
    // Log.d(TAG, "message to know you anything.");
    protected Context context;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        initView();
        findView();

    }

    private void initView(){
        context = this;
    }

    private void findView(){
        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null) initToolBar(toolbar);
    }

    protected void initToolBar(Toolbar toolbar){
        //Todo override
    }

    public void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
