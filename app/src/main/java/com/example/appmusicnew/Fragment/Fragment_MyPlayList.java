package com.example.appmusicnew.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.appmusicnew.Adapter.MyplaylistAdapter;
import com.example.appmusicnew.Model.Myplay;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_MyPlayList extends Fragment {
    View view;
    RecyclerView recyclerViewmybaihat;
    MyplaylistAdapter myplaylistAdapter;
    private PreferenceHelper preferenceHelper;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myplaylist,container,false);
        preferenceHelper = new PreferenceHelper(view.getContext());
        recyclerViewmybaihat = view.findViewById(R.id.recyclerviewmyplaylist);

        GetData();
        return  view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Myplay>> callback = dataservice.GetDanhsachMypl(preferenceHelper.getName());
        callback.enqueue(new Callback<List<Myplay>>() {
            @Override
            public void onResponse(Call<List<Myplay>> call, Response<List<Myplay>> response) {
                ArrayList<Myplay> myplayArrayList = (ArrayList<Myplay>) response.body();
                myplaylistAdapter = new MyplaylistAdapter(getActivity(), myplayArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewmybaihat.setLayoutManager(linearLayoutManager);
                recyclerViewmybaihat.setAdapter(myplaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Myplay>> call, Throwable t) {

            }
        });
    }
}
