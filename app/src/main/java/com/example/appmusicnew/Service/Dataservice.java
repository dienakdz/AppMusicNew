package com.example.appmusicnew.Service;

import com.example.appmusicnew.Model.Album;
import com.example.appmusicnew.Model.Baihat;
import com.example.appmusicnew.Model.ChuDeTheLoai;
import com.example.appmusicnew.Model.Playlist;
import com.example.appmusicnew.Model.Quangcao;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("quangcao.php")
    Call<List<Quangcao>> GetDataQuangcao();

    @GET("playlist.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("theloai.php")
    Call<ChuDeTheLoai> GetChuDeTheLoai();

    @GET("album.php")
    Call<List<Album>> GetAlbum();

    @GET("baihatyeuthich.php")
    Call<List<Baihat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoquangcao(@Field("idQuangCao") String idQuangCao);


}
