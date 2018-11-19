package com.example.a0xbistrot.codingcleanic_v20.network.api;

import com.example.a0xbistrot.codingcleanic_v20.data.entity.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubService {

    @GET("users")
    Call<List<GithubUser>> listUsers();

}
