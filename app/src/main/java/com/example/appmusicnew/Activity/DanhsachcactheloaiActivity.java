package com.example.appmusicnew.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.appmusicnew.Adapter.DanhsachcacplaylistAdapter;
import com.example.appmusicnew.Adapter.DanhsachcactheloaiAdapter;
import com.example.appmusicnew.Model.Playlist;
import com.example.appmusicnew.Model.TheLoai;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcactheloaiActivity extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcactheloai;
    DanhsachcactheloaiAdapter danhsachcactheloaiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcactheloai);
        anhxa();
        init();
        GetData();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> callback = dataservice.GetDanhsachcacTheloai();
        callback.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai= (ArrayList<TheLoai>) response.body();
                danhsachcactheloaiAdapter = new DanhsachcactheloaiAdapter(DanhsachcactheloaiActivity.this, mangtheloai);
                recyclerViewdanhsachcactheloai.setLayoutManager(new GridLayoutManager(DanhsachcactheloaiActivity.this,2));
                recyclerViewdanhsachcactheloai.setAdapter(danhsachcactheloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thể Loại");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void anhxa() {
        toolbar= findViewById(R.id.toolbardanhsachcactheloai);
        recyclerViewdanhsachcactheloai = findViewById(R.id.recycviewdanhsachcactheloai);

    }
}