package com.example.appmusicnew.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusicnew.Activity.DanhsachbaihatActivity;
import com.example.appmusicnew.Activity.DanhsachcactheloaiActivity;
import com.example.appmusicnew.Model.TheLoai;
import com.example.appmusicnew.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DanhsachcactheloaiAdapter  extends  RecyclerView.Adapter<DanhsachcactheloaiAdapter.ViewHolder>{

    Context context;
    ArrayList<TheLoai> mangtheloai;

    public DanhsachcactheloaiAdapter(Context context, ArrayList<TheLoai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachcactheloai,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DanhsachcactheloaiAdapter.ViewHolder holder, int position) {
        TheLoai theLoai = mangtheloai.get(position);
        Picasso.with(context).load(theLoai.getHinhTheLoai()).into(holder.imghinhnentheloai);
        holder.txttentheloai.setText(theLoai.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnentheloai;
        TextView txttentheloai;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imghinhnentheloai = itemView.findViewById(R.id.imageviewdanhsachcactheloai);
            txttentheloai = itemView.findViewById(R.id.textviewdanhsachcactheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("idtheloai", mangtheloai.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
