package com.example.appmusicnew.Service;

import com.example.appmusicnew.Model.Playlist;
import com.example.appmusicnew.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {

    @GET("quangcao.php")
    Call<List<Quangcao>> GetDataQuangcao();

    @GET("playlist.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();


}
