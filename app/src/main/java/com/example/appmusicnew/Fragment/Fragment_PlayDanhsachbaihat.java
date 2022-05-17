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

import com.example.appmusicnew.Activity.PlaynhacActivity;
import com.example.appmusicnew.Adapter.PlaynhacAdapter;
import com.example.appmusicnew.R;

import org.jetbrains.annotations.NotNull;

public class Fragment_PlayDanhsachbaihat extends Fragment {
    View view;
    RecyclerView recyclerViewplaybaihat;
    PlaynhacAdapter playnhacAdapter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playdanhsachcacbaihat, container, false);
        recyclerViewplaybaihat = view.findViewById(R.id.recyclerviewplaybaihat);
        if (PlaynhacActivity.mangbaihat.size()>0){
            playnhacAdapter = new PlaynhacAdapter(getActivity(), PlaynhacActivity.mangbaihat);
            recyclerViewplaybaihat.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaybaihat.setAdapter(playnhacAdapter);

        }
        return view;
    }
}
