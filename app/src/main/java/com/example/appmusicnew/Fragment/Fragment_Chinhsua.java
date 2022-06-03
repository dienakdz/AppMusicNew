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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Fragment_Chinhsua extends Fragment {
    View view;
    TextView etchinhsuaten;
    EditText  etchinhsuataikhoan, etchinhsuamatkhau;
    Button btnchinhsua;
    private PreferenceHelper preferenceHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chinhsua,container,false);
        preferenceHelper = new PreferenceHelper(getContext());
        anhxa();
        init();
        return view;
    }

    private void init() {

        etchinhsuaten.setText(preferenceHelper.getName());
        etchinhsuataikhoan.setText(preferenceHelper.getTaikhoan());
        etchinhsuamatkhau.setText(preferenceHelper.getMatkhau());
        btnchinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updaterMe();

            }
        });
    }
    private void updaterMe() {

        final String name = preferenceHelper.getName();
        final String username = etchinhsuataikhoan.getText().toString();
        final String password = etchinhsuamatkhau.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.base_url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        Dataservice dataservice = retrofit.create(Dataservice.class);
        Call<String> callback = dataservice.getUserUpdate(name,username,password);

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

            Toast.makeText(getContext(), "Update Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getContext(), WelcomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {

            Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
        etchinhsuaten = view.findViewById(R.id.edittextchinhsuaten);
        etchinhsuataikhoan = view.findViewById(R.id.edittextchinhsuataikhoan);
        etchinhsuamatkhau = view.findViewById(R.id.edittextchinhsuamatkhau);
        btnchinhsua = view.findViewById(R.id.btnchinhsua);

    }
}
