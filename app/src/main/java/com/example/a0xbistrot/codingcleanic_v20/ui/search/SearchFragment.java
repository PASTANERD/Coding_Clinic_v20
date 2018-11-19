package com.example.a0xbistrot.codingcleanic_v20.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.GithubUser;
import com.example.a0xbistrot.codingcleanic_v20.data.source.GithubRemoteDataSource;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseFragment;
import com.example.a0xbistrot.codingcleanic_v20.ui.effect.LoadingBar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends BaseFragment {

    RecyclerView GithubRecycler;
    LoadingBar loadingBar;


    private GitHubUserAdapter gitHubUserAdapter;
    private GithubRemoteDataSource githubRemoteDataSource = new GithubRemoteDataSource();

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_search, container, false);
        findView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRecyclerView();
        loadItems();

    }

    private void findView(View view){
        GithubRecycler = view.findViewById(R.id.search_recycler_view);
        loadingBar = view.findViewById(R.id.search_loading);
    }

    private void setRecyclerView(){
        gitHubUserAdapter = new GitHubUserAdapter();
        GithubRecycler.setLayoutManager(new LinearLayoutManager(context));
        GithubRecycler.setAdapter(gitHubUserAdapter);
    }

    private void loadItems() {
        loadingBar.show();
        githubRemoteDataSource.get(new Callback<List<GithubUser>>() {

            @Override
            public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response) {
                loadingBar.hide();
                gitHubUserAdapter.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubUser>> call, Throwable t) {
                loadingBar.hide();
                t.printStackTrace();
            }
        });
    }
}
