package com.example.appmusicnew.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusicnew.Adapter.MainViewPagerAdapter;
import com.example.appmusicnew.Fragment.Fragment_Chinhsua;
import com.example.appmusicnew.Fragment.Fragment_MyPlayList;
import com.example.appmusicnew.R;
import com.example.appmusicnew.Service.PreferenceHelper;

public class WelcomeActivity extends AppCompatActivity {

    private TextView tvname, tvtaikhoan;
    private Button btnlogout,btnedit, btnhome;
    private PreferenceHelper preferenceHelper;
    private ViewPager welviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        anhxa();



        preferenceHelper = new PreferenceHelper(this);

        tvname.setText("Chào: "+preferenceHelper.getName());
        tvtaikhoan.setText("Tài Khoản: " + preferenceHelper.getTaikhoan());


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceHelper.putIsLogin(false,false,false);
                System.out.println("logout click : "+ preferenceHelper.getIsLogin());
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Đăng xuất thành công!", Toast.LENGTH_SHORT).show();
                WelcomeActivity.this.finish();
            }
        });
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("home click : "+ preferenceHelper.getIsLogin());
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_MyPlayList(), "MyPlaylist");
        welviewPager.setAdapter(mainViewPagerAdapter);
    }

    private void anhxa() {
        tvname = (TextView) findViewById(R.id.textviewtennguoidung);
        tvtaikhoan = findViewById(R.id.textviewtknguoidung);
        btnlogout = (Button) findViewById(R.id.btndx);
        btnedit = (Button) findViewById(R.id.btnedit);
        btnhome = findViewById(R.id.btnhome);

        welviewPager = findViewById(R.id.welViewPager);
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Chinhsua(), "Chỉnh sửa");
        welviewPager.setAdapter(mainViewPagerAdapter);
    }
}
