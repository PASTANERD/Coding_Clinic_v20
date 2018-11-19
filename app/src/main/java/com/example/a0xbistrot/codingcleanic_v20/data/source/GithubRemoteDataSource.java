package com.example.a0xbistrot.codingcleanic_v20.data.source;

import com.example.a0xbistrot.codingcleanic_v20.data.entity.GithubUser;
import com.example.a0xbistrot.codingcleanic_v20.network.RetrofitStore;
import com.example.a0xbistrot.codingcleanic_v20.network.api.GithubService;

import java.util.List;

import retrofit2.Callback;

public class GithubRemoteDataSource {

    private GithubService service = RetrofitStore.get().create(GithubService.class);
    // get() : Retrofit 객체 호출, create() : Retrofit 인터페이스 Parsing 방법

    public void get(Callback<List<GithubUser>> callback){ // Callback : 비동기 작업을 위한 객체
        service.listUsers().enqueue(callback); // enqueue() : 비동기로 정보를 받는 메소드
    }
}
