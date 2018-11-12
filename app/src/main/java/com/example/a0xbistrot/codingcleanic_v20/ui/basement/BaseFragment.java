package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {



    private final String TAG = getClass().getSimpleName();
    protected Context context;
    protected BaseActivity activity;
    private Toolbar toolBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        initialize();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        //initToolBar(toolBar);

    }

    private void initialize(){
        context = getContext();
        activity = (BaseActivity) getActivity();
        setHasOptionsMenu(true);


    }

    private void initView(View view){
        toolBar = view.findViewById(R.id.toolbar);
        if(toolBar != null) initToolBar(toolBar);
        activity.setSupportActionBar(toolBar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
    }

    protected void initToolBar(Toolbar toolBar){
        toolBar.setTitle(R.string.app_name);

        // override here
    }

    // TODO Toolbar menu build below here



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //MenuItem upload = menu.add("upload");
        //upload.setIcon(R.drawable.ic_file_upload_black_24dp);
        //inflater = activity.getMenuInflater();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_menu, menu);
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
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }
}
