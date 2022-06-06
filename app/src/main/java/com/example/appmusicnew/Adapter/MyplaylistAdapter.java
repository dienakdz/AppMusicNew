package com.example.appmusicnew.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusicnew.Activity.PlaynhacActivity;
import com.example.appmusicnew.Activity.WelcomeActivity;
import com.example.appmusicnew.Model.Myplay;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;
import com.squareup.picasso.Picasso;
import  com.example.appmusicnew.Fragment.Fragment_MyPlayList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyplaylistAdapter extends  RecyclerView.Adapter<MyplaylistAdapter.ViewHolder>{
    Context context;
    ArrayList<Myplay> myplayArrayList;
    private  PreferenceHelper preferenceHelper;
    private  RecyclerView recyclerViewmybaihat;

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
        ImageView imgmplhinh,imgmpldelete;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtmplten = itemView.findViewById(R.id.textviewtenmyplaylist);
            txtmplcasi = itemView.findViewById(R.id.textviewtencasimyplaylist);
            imgmplhinh = itemView.findViewById(R.id.imageviewmyplaylist);
            imgmpldelete = itemView.findViewById(R.id.imageviewmyplaylistdelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("mybaihat", myplayArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgmpldelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    preferenceHelper = new PreferenceHelper(view.getContext());
                    System.out.println("recycle click: "+preferenceHelper.getName()+myplayArrayList.get(getPosition()).getIdBaiHat());
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback= dataservice.Deletempl(preferenceHelper.getName(),myplayArrayList.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            System.out.println("ketquarecycle: "+response.body());

                            if (ketqua.equals("deletesuccess")){
                                Toast.makeText(context, " Đã xoa", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(context, "Lỗi!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    Intent intent = new Intent(context, WelcomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

    }
}
