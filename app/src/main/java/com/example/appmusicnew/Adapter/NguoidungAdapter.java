package com.example.appmusicnew.Adapter;

import android.content.Context;

import com.example.appmusicnew.Model.Nguoidung;

import java.util.ArrayList;

public class NguoidungAdapter {
    Context context;
    ArrayList<Nguoidung> nguoidungArrayList;

    public NguoidungAdapter(Context context, ArrayList<Nguoidung> nguoidungArrayList) {
        this.context = context;
        this.nguoidungArrayList = nguoidungArrayList;
    }

}
