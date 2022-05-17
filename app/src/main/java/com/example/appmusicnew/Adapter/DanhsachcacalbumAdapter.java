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
import com.example.appmusicnew.Model.Album;
import com.example.appmusicnew.Model.TheLoai;
import com.example.appmusicnew.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DanhsachcacalbumAdapter extends  RecyclerView.Adapter<DanhsachcacalbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> mangalbum;

    public DanhsachcacalbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachcacalbum,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DanhsachcacalbumAdapter.ViewHolder holder, int position) {
        Album album = mangalbum.get(position);
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imghinhnenalbum);
        holder.txttenalbum.setText(album.getTenAlbum());

    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imghinhnenalbum;
        TextView txttenalbum;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imghinhnenalbum = itemView.findViewById(R.id.imageviewdanhsachcacalbum);
            txttenalbum = itemView.findViewById(R.id.textviewdanhsachcacalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album", mangalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
