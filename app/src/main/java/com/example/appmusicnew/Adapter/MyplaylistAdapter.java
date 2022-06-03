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

import com.example.appmusicnew.Activity.PlaynhacActivity;
import com.example.appmusicnew.Model.Myplay;
import com.example.appmusicnew.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyplaylistAdapter extends  RecyclerView.Adapter<MyplaylistAdapter.ViewHolder>{
    Context context;
    ArrayList<Myplay> myplayArrayList;

    public MyplaylistAdapter(Context context, ArrayList<Myplay> myplayArrayList) {
        this.context = context;
        this.myplayArrayList = myplayArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_myplaylist,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyplaylistAdapter.ViewHolder holder, int position) {
        Myplay myplay = myplayArrayList.get(position);
        holder.txtmplten.setText(myplay.getTenBaiHat());
        holder.txtmplcasi.setText(myplay.getCaSi());
        Picasso.with(context).load(myplay.getHinhBaiHat()).into(holder.imgmplhinh);

    }

    @Override
    public int getItemCount() {
        return myplayArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtmplten,txtmplcasi;
        ImageView imgmplhinh,imgmplluotthich;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtmplten = itemView.findViewById(R.id.textviewtenmyplaylist);
            txtmplcasi = itemView.findViewById(R.id.textviewtencasimyplaylist);
            imgmplhinh = itemView.findViewById(R.id.imageviewmyplaylist);
            imgmplluotthich = itemView.findViewById(R.id.imageviewmyplaylistluotthich);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("mybaihat", myplayArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }

    }
}
