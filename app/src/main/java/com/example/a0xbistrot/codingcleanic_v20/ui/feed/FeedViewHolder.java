package com.example.a0xbistrot.codingcleanic_v20.ui.feed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseViewHolder;

import androidx.annotation.NonNull;

public class FeedViewHolder extends BaseViewHolder<FeedItem>{

    private ImageView user_pic;
    private ImageView content_pic;
    private TextView user_id;
    private TextView feed_date;

    //private FeedItem feedItem;

    public FeedViewHolder(@NonNull ViewGroup parent) {
        super(getItemView(parent, R.layout.item_feed));
        findView(itemView);
    }

    private void findView(View view){
        user_pic = view.findViewById(R.id.feed_user_pic);
        content_pic = view.findViewById(R.id.feed_content_pic);
        user_id = view.findViewById(R.id.feed_user_id);
        feed_date = view.findViewById(R.id.feed_date);

    }


    @Override
    public void bind(final FeedItem item) {
        user_pic.setImageResource(item.getFeed_user_pic());
        user_id.setText(item.getFeed_user_id());
        content_pic.setImageResource(item.getFeed_content_pic());
        feed_date.setText(item.getFeed_date());
    }

}
/*
public class FeedViewHolder extends RecyclerView.ViewHolder{

    private ImageView user_pic;
    private ImageView content_pic;
    private TextView user_id;
    private TextView feed_date;

    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        findView(itemView);
    }


    private void findView(View view) {
        user_pic = view.findViewById(R.id.feed_user_pic);
        content_pic = view.findViewById(R.id.feed_content_pic);
        user_id = view.findViewById(R.id.feed_user_id);
        feed_date = view.findViewById(R.id.feed_date);
    }

    public void bind(FeedItem item){
        user_pic.setImageResource(item.getFeed_user_pic());
        user_id.setText(item.getFeed_user_id());
        content_pic.setImageResource(item.getFeed_content_pic());
        feed_date.setText(item.getFeed_date());
    }
}
*/

