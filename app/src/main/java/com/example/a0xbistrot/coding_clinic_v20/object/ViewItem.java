package com.example.a0xbistrot.coding_clinic_v20.object;

import com.example.a0xbistrot.coding_clinic_v20.R;

public class ViewItem {

    public int drawable_user_pic;
    public int drawable_content_pic;
    public String user_name;
    public String content_string;

    public ViewItem(int drawable_user_pic, int drawable_content_pic, String user_name, String content_string) {
        this.drawable_user_pic = drawable_user_pic;
        this.drawable_content_pic = drawable_content_pic;
        this.user_name = user_name;
        this.content_string = content_string;
    }

    public ViewItem(int drawable_content_pic, String user_name, String content_string) {
        this.drawable_user_pic = R.drawable.ic_if_user;
        this.drawable_content_pic = drawable_content_pic;
        this.user_name = user_name;
        this.content_string = content_string;
    }
}
