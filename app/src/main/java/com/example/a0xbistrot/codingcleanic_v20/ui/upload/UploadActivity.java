package com.example.a0xbistrot.codingcleanic_v20.ui.upload;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseActivity;
import com.example.a0xbistrot.codingcleanic_v20.util.FileUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

public class UploadActivity extends BaseActivity {

    //private final int CAMERA_ACCESS = 100;
    private final int GALLERY_ACCESS = 1;

    //private Uri photoUri;
    //private String currentPhotoPath;    //실제 사진 파일 경로
    //String mImageCaptureName;           //이미지 이름

    private ImageView upload_img_upload;
    private ImageView upload_img_icon;
    private TextView upload_text_guide;
    private FrameLayout upload_button_area;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        setToolbar(TOOLBAR_REQUEST);
        initialize();
        findView();
        setUploadAreaButton();
    }

    @Override
    protected void initToolBar(Toolbar toolbar) {
        super.initToolBar(toolbar);
    }

    private void findView(){
        upload_img_icon = findViewById(R.id.upload_upload_icon);
        upload_img_upload = findViewById(R.id.upload_upload_image);
        upload_text_guide = findViewById(R.id.upload_upload_text);
        upload_button_area = findViewById(R.id.upload_tab_area);
    }

    private void initialize(){
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case GALLERY_ACCESS:
                if(resultCode != Activity.RESULT_OK) break;
                Uri uri = data.getData();
                String path = FileUtil.getPath(context, uri);
                upload_img_upload.setImageBitmap(BitmapFactory.decodeFile(path));
                upload_img_upload.setVisibility(View.VISIBLE);
                upload_img_icon.setVisibility(View.GONE);
                upload_text_guide.setVisibility(View.GONE);
                break;
        }
    }

    private void setUploadAreaButton(){
        upload_button_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent file_intent = new Intent(Intent.ACTION_GET_CONTENT);
                file_intent.setType(FileUtil.MIME_IMAGE);
                startActivityForResult(file_intent, GALLERY_ACCESS);
            }
        });

        /*
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
        */
    }

    /*

    private void activeCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_ACCESS);
        //String cameraUrl = "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    }

    private void activeAlbum(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            Intent albumIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(albumIntent.resolveActivity(getPackageManager()) != null){
                File photoFile = null;

                try{
                    //photoFile = createImageFile();
                }catch (IOException){
                    Log.d(TAG, "activeAlbum() method");
                }

                if(photoFile != null){
                    photoUri = FileProvider.getUriForFile(this, getPackageName(), photoFile);
                    albumIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                    startActivityForResult(albumIntent, CAMERA_ACCESS);
                }
            }
        }
    }

    */


    private void setFeedData(){
        /*
        String content_txt = getString(R.string.app_name);
        User user = new UserLocalSource().getMaster();
        for (int i = 0 ; i < 6 ; i++){
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic1, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic2, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic3, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic4, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic5, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic6, content_txt));

            feedItemsList.add(new FeedItem("2017.12.24", R.drawable.content_pic1));
            feedItemsList.add(new FeedItem("2017.12.28", R.drawable.content_pic2));
            feedItemsList.add(new FeedItem("2018.01.04", R.drawable.content_pic3));
            feedItemsList.add(new FeedItem("2018.01.08", R.drawable.content_pic4));
            feedItemsList.add(new FeedItem("2018.01.15", R.drawable.content_pic5));
            feedItemsList.add(new FeedItem("2018.01.28", R.drawable.content_pic6));

        }
        */
        //feedAdapter.addAll(feedItemsList);

    }
}
