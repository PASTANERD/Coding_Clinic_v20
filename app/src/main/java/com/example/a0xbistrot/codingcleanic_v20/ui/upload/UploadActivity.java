package com.example.a0xbistrot.codingcleanic_v20.ui.upload;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

public class UploadActivity extends BaseActivity {

    FrameLayout upload_button_area;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        findView();
        setUploadAreaButton();
    }

    @Override
    protected void initToolBar(Toolbar toolbar) {
        super.initToolBar(toolbar);
        toolbar.setTitle("Upload");
    }

    private void findView(){
        upload_button_area = findViewById(R.id.upload_tab_area);
    }

    private void setUploadAreaButton(){
        upload_button_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogInterface.OnClickListener cameraListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activeCamera();
                    }
                };

                DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activeAlbum();
                    }
                };

                DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                };

//                new AlertDialog.Builder(this).setTitle(R.string.upload_dialog)
  //                      .setPositiveButton(R.string.upload_dialog_camera, cameraListener)
    //                    .setNeutralButton(R.string.upload_dialog_album, albumListener)
                displayToast("upload system is constructing now...");
            }
        });
    }


    private void activeCamera(){

    }

    private void activeAlbum(){

    }


}
