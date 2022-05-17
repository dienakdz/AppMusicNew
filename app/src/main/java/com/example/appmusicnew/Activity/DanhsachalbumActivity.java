package com.example.appmusicnew.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.appmusicnew.Adapter.DanhsachcacalbumAdapter;
import com.example.appmusicnew.Adapter.DanhsachcactheloaiAdapter;
import com.example.appmusicnew.Model.Album;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachalbumActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcacalbum;
    DanhsachcacalbumAdapter danhsachcacalbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachalbum);
        anhxa();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetDanhsachcacAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                danhsachcacalbumAdapter = new DanhsachcacalbumAdapter(DanhsachalbumActivity.this, mangalbum);
                recyclerViewdanhsachcacalbum.setLayoutManager(new GridLayoutManager(DanhsachalbumActivity.this, 2));
                recyclerViewdanhsachcacalbum.setAdapter(danhsachcacalbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Album");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbardanhsachcacalbum);
        recyclerViewdanhsachcacalbum = findViewById(R.id.recycviewdanhsachcacalbum);

    }
}