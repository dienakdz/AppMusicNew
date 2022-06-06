package com.example.appmusicnew.Service;

import com.example.appmusicnew.Model.Album;
import com.example.appmusicnew.Model.Baihat;
import com.example.appmusicnew.Model.ChuDeTheLoai;
import com.example.appmusicnew.Model.Myplay;
import com.example.appmusicnew.Model.Playlist;
import com.example.appmusicnew.Model.Quangcao;
import com.example.appmusicnew.Model.TheLoai;


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

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaohattheoplaylist(@Field("idPlayList") String idPlayList);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaohattheotheloai(@Field("idTheLoai") String idTheLoai);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaohattheoalbum(@Field("idAlbum") String idAlbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> AddMyPlayList (@Field("luotThich") String luotThich, @Field("idBaiHat") String idBaiHat, @Field("userluotthich") String userluotthich);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLuotthich (@Field("luotThich") String luotThich, @Field("idBaiHat") String idBaiHat);


    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacPlaylist();

    @GET("danhsachcactheloai.php")
    Call<List<TheLoai>> GetDanhsachcacTheloai();

    @GET("danhsachcacalbum.php")
    Call<List<Album>> GetDanhsachcacAlbum();

    @FormUrlEncoded
    @POST("timkiembaihat.php")
    Call<List<Baihat>> GetTimkiembaihat(@Field("tukhoa") String tukhoa);

    @FormUrlEncoded
    @POST("login.php")
    Call<String> getUserLogin( @Field("taiKhoan") String taiKhoan, @Field("matKhau") String matKhau);

    @FormUrlEncoded
    @POST("dangki.php")
    Call<String> getUserRegi(
            @Field("name") String name,
            @Field("username") String uname,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("chinhsua.php")
    Call<String> getUserUpdate(
            @Field("name") String name,
            @Field("username") String uname,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("myplaylist.php")
    Call<List<Myplay>> GetDanhsachMypl(@Field("userpl") String userpl);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> Deletempl (@Field("userdelete") String userdelete, @Field("idBaiHatDelete") String idBaiHatDelete);

}
