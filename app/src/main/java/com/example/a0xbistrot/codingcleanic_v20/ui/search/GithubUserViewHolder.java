package com.example.a0xbistrot.codingcleanic_v20.ui.search;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.GithubUser;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseViewHolder;

import androidx.annotation.NonNull;

public class GithubUserViewHolder extends BaseViewHolder<GithubUser> implements View.OnClickListener {

    private ImageView Github_Avatar;
    private TextView Github_Name;

    private GithubUser User;

    public GithubUserViewHolder(@NonNull ViewGroup parent) {
        super(getItemView(parent, R.layout.item_github_user));
        findView(itemView);
    }

    private void findView(View view){
        Github_Avatar = view.findViewById(R.id.github_avartar);
        Github_Name = view.findViewById(R.id.github_name);
    }


    @Override
    public void bind(final GithubUser item) {
        User = item;
        Github_Name.setText(User.getName());
        Glide.with(context)
                .load(User.getAvatarUrl())
                .into(Github_Avatar);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(User.getUrl()));
        context.startActivity(intent);
    }
}
