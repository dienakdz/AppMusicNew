package com.example.appmusicnew.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusicnew.Model.Quangcao;
import com.example.appmusicnew.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class QuangcaoAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListQuangcao;


    public QuangcaoAdapter(Context context, ArrayList<Quangcao> arrayListQuangcao) {
        this.context = context;
        this.arrayListQuangcao = arrayListQuangcao;
    }

    @Override
    public int getCount() {

        return arrayListQuangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull Object object) {
        return view == object;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Object instantiateItem(@NonNull @org.jetbrains.annotations.NotNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dongquangcao, null);
        ImageView imgbackgroundquangcao = view.findViewById(R.id.imageviewbackgroundquangcao);
        ImageView imgbaihatquangcao = view.findViewById(R.id.imageviewquangcao);
        TextView txttitlebaihatquangcao = view.findViewById(R.id.textviewtitlequangcaobaihat);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);



        Picasso.with(context).load(arrayListQuangcao.get(position).getHinhQuangCao()).into(imgbackgroundquangcao);
        Picasso.with(context).load(arrayListQuangcao.get(position).getHinhBaiHat()).into(imgbaihatquangcao);
        txttitlebaihatquangcao.setText(arrayListQuangcao.get(position).getTenBaiHat());
        txtnoidung.setText(arrayListQuangcao.get(position).getNoiDung());



        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((View) object);
    }
}
