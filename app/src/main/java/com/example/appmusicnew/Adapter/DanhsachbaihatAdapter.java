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
import android.widget.Toast;

import com.example.appmusicnew.Activity.PlaynhacActivity;
import com.example.appmusicnew.Model.Baihat;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder>{

    Context context;
    ArrayList<Baihat> mangbaihat;
    private PreferenceHelper preferenceHelper;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsachbaihat,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DanhsachbaihatAdapter.ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txttencasi.setText((baihat.getCaSi()));
        holder.txttenbaihat.setText(baihat.getTenBaiHat());
        holder.txtindex.setText(position + 1 + "");

    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex, txttenbaihat, txttencasi;
        ImageView imgluotthich;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txttencasi = itemView.findViewById(R.id.textviewtencasi);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferenceHelper = new PreferenceHelper(view.getContext());
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    if (preferenceHelper.getIsLogin()){
                        Call<String> callback= dataservice.AddMyPlayList("1",  mangbaihat.get(getPosition()).getIdBaiHat(), preferenceHelper.getName());
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                String ketqua = response.body();
                                System.out.println("ketquabne: "+ ketqua);
                                if (ketqua.equals("successsuccessadd")){
                                    Toast.makeText(context, " Đã thích0", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(context, "Lỗi0!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }else {
                        Call<String> callback= dataservice.UpdateLuotthich("1",  mangbaihat.get(getPosition()).getIdBaiHat());
                        callback.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                String ketqua = response.body();
                                System.out.println("ketquabne: "+ ketqua);
                                if (ketqua.equals("success")){
                                    Toast.makeText(context, " Đã thích1", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(context, "Lỗi1!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("baihat", mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
