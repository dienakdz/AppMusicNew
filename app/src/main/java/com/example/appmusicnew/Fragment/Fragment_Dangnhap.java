package com.example.appmusicnew.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusicnew.Activity.DangkiActivity;

import com.example.appmusicnew.Activity.WelcomeActivity;

import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Fragment_Dangnhap extends Fragment {
    View viewdn;
    EditText ettaikhoan,etmatkhau;
    TextView tvdangki;
    Button btndn;
    private PreferenceHelper preferenceHelperdn;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        viewdn = inflater.inflate(R.layout.fragment_dangnhap, container, false);
        preferenceHelperdn = new PreferenceHelper(viewdn.getContext());
        if (preferenceHelperdn.getIsLogin()){
            Intent intent = new Intent(getActivity(),WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            anhxa();
            tvdangki.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), DangkiActivity.class);
                    startActivity(intent);
                }
            });
            btndn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginUser();

                }
            });

        }

        return viewdn;
    }

    private void loginUser() {
        final String taikhoan = ettaikhoan.getText().toString().trim();
        final String matkhau = etmatkhau.getText().toString().trim();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        Dataservice dataservice = retrofit.create(Dataservice.class);
        Call<String> callback = dataservice.getUserLogin(taikhoan, matkhau);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                response.body().toString();
                String nguoidung = response.body();

                    if (nguoidung != null) {
                        Log.d("onSuccess", nguoidung);

                        String jsonresponse = response.body().toString();
                        parseLoginData(jsonresponse);
                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseLoginData(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {

                saveInfo(response);

                Toast.makeText(viewdn.getContext(), "Login Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),WelcomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
//                Fragment_Dangnhap.this.finish();
            }else{
                Toast.makeText(viewdn.getContext(), "Invalid username or password!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void saveInfo(String response) {
        preferenceHelperdn.putIsLogin(true,true,true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelperdn.putName(dataobj.getString("tenNguoiDung"));
                    preferenceHelperdn.putTaikhoan(dataobj.getString("taiKhoan"));
                    preferenceHelperdn.putMatkhau(dataobj.getString("matKhau"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void anhxa() {
        ettaikhoan = viewdn.findViewById(R.id.edittexttaikhoan);
        etmatkhau = viewdn.findViewById(R.id.edittextpassword);
        tvdangki = viewdn.findViewById(R.id.textviewdangki);
        btndn = viewdn.findViewById(R.id.btndangnhap);


    }
}
