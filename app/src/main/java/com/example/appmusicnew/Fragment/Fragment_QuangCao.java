package com.example.appmusicnew.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.appmusicnew.Adapter.QuangcaoAdapter;
import com.example.appmusicnew.Model.Quangcao;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_QuangCao extends Fragment{

    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    QuangcaoAdapter quangcaoAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;
    
    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quangcao,container, false);
        anhxa();
        GetData();
        return view;
    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indicatordefault);

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Quangcao>> callback =  dataservice.GetDataQuangcao();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> quangcao = (ArrayList<Quangcao>) response.body();


                quangcaoAdapter = new QuangcaoAdapter(getActivity(),quangcao);
                viewPager.setAdapter(quangcaoAdapter);
                circleIndicator.setViewPager(viewPager);
                System.out.println();
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if (currentItem >= viewPager.getAdapter().getCount()){
                            currentItem =0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);


                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }
}
