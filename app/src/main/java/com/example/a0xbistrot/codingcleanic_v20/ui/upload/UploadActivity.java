package com.example.a0xbistrot.codingcleanic_v20.ui.upload;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.Feed;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.User;
import com.example.a0xbistrot.codingcleanic_v20.data.source.FeedLocalSource;
import com.example.a0xbistrot.codingcleanic_v20.data.source.UserLocalSource;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseActivity;
import com.example.a0xbistrot.codingcleanic_v20.util.FileUtil;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class UploadActivity extends BaseActivity {

    //private final int CAMERA_ACCESS = 100;
    private final int GALLERY_ACCESS = 1;

    //private Uri photoUri;
    //private String currentPhotoPath;    //실제 사진 파일 경로
    //String mImageCaptureName;           //이미지 이름

    private ImageView upload_img_upload;
    private ImageView upload_img_icon;
    private TextView upload_text_guide;
    private TextInputEditText inputText;
    private FrameLayout upload_button_area;

    private UserLocalSource userLocalSource = new UserLocalSource();
    private FeedLocalSource feedLocalSource = new FeedLocalSource();

    private String imagePath;
    private AlertDialog dialog;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        setToolbar(TOOLBAR_REQUEST);
        findView();
        setUploadAreaButton();
    }

    @Override
    protected void initToolBar(Toolbar toolbar) {
        /*
        super.initToolBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(context, R.drawable.ic_arrow_back_white_24dp));
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.toolbar_upload:
                        //upload();
                        break;
                }
                return true;
            }
        });
        */
    }

    private void findView(){
        upload_img_icon = findViewById(R.id.upload_upload_icon);
        upload_img_upload = findViewById(R.id.upload_upload_image);
        upload_text_guide = findViewById(R.id.upload_upload_text);
        upload_button_area = findViewById(R.id.upload_tab_area);
    }

    private void initializeDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        //LayoutInflater inflater = this.getLayoutInflater();
        final View viewInflater = LayoutInflater.from(context).inflate(R.layout.view_dialog_feedtext, null);
        dialogBuilder.setTitle("Test Title");
        dialogBuilder.setMessage("Test Message")
                .setView(viewInflater)
                .setCancelable(false)
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //inputText = inflater.inflate(R.layout.view_dialog_feedtext, null).findViewById(R.id.upload_dialog_inputtext);
                        //inputText = dialog.findViewById(R.id.upload_dialog_inputtext);
                        inputText = viewInflater.findViewById(R.id.upload_dialog_inputtext);
                        upload();
                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        //inputText = findViewById(R.id.upload_dialog_inputtext);
        dialog = dialogBuilder.create();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case GALLERY_ACCESS:
                if(resultCode != Activity.RESULT_OK) break;
                Uri uri = data.getData();
                imagePath = FileUtil.getPath(context, uri);
                upload_img_upload.setImageBitmap(BitmapFactory.decodeFile(imagePath));
                upload_img_upload.setVisibility(View.VISIBLE);
                upload_img_icon.setVisibility(View.GONE);
                upload_text_guide.setVisibility(View.GONE);
                dialog.show();
                break;
        }
    }

    private void setUploadAreaButton(){
        upload_button_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeDialog();
                Intent file_intent = new Intent(Intent.ACTION_GET_CONTENT);
                file_intent.setType(FileUtil.MIME_IMAGE);
                startActivityForResult(file_intent, GALLERY_ACCESS);
            }
        });

    }

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
    private void upload() {
        User user = userLocalSource.getMaster();
        String text = inputText.getText().toString();

        if (!validate(user, text, imagePath)) return;

        Feed feed = new Feed(user.getId(), inputText.getText().toString(), imagePath);
        feedLocalSource.insert(feed);
        finish();
    }

    private boolean validate(User user, String text, String imagePath) {
        if (user == null) {
            displayToast(getResources().getString(R.string.upload_exception_null_user));
            //Toast.makeText(context, R.string.upload_empty_user, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(text)) {
            displayToast(getResources().getString(R.string.upload_exception_null_text));
            //Toast.makeText(context, R.string.upload_empty_text, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (imagePath == null) {
            displayToast(getResources().getString(R.string.upload_exception_null_image_path));
            //Toast.makeText(context, R.string.upload_empty_image, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
