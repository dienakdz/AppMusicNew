package com.example.appmusicnew.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.APIService;
import com.example.appmusicnew.Service.Dataservice;
import com.example.appmusicnew.Service.PreferenceHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class DangkiActivity extends AppCompatActivity {
    EditText etdkten, etdktaikhoan,etdkmatkhau;
    Button btndk;
    TextView tvdangnhap;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        anhxa();
        preferenceHelper = new PreferenceHelper(this);
        tvdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerMe();
            }
        });

    }
    private void registerMe() {

        final String name = etdkten.getText().toString();
        final String username = etdktaikhoan.getText().toString();
        final String password = etdkmatkhau.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Dataservice dataservice = retrofit.create(Dataservice.class);
        Call<String> callback = dataservice.getUserRegi(name,username,password);

        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void parseRegData(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")){

            saveInfo(response);

            Toast.makeText(DangkiActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DangkiActivity.this,WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            this.finish();
        }else {

            Toast.makeText(DangkiActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInfo(String response){

        preferenceHelper.putIsLogin(true,true,true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    preferenceHelper.putName(dataobj.getString("tenNguoiDung"));
                    preferenceHelper.putTaikhoan(dataobj.getString("taiKhoan"));
                    preferenceHelper.putMatkhau(dataobj.getString("matKhau"));

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void anhxa() {
        etdkten = findViewById(R.id.edittextdangkiten);
        etdktaikhoan = findViewById(R.id.edittextdangkitaikhoan);
        etdkmatkhau = findViewById(R.id.edittextdangkimatkhau);
        tvdangnhap = findViewById(R.id.textviewdangnhap);
        btndk = findViewById(R.id.btndangki);
    }
}