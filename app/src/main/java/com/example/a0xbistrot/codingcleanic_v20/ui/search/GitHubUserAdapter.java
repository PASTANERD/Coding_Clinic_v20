package com.example.a0xbistrot.codingcleanic_v20.ui.search;

import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseRecyclerViewAdapter;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseViewHolder;

public class GitHubUserAdapter extends BaseRecyclerViewAdapter {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected BaseViewHolder getViewHolder(int viewType, ViewGroup parent) {
        return new GithubUserViewHolder(parent);
    }
}
