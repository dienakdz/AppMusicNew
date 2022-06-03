package com.example.appmusicnew.Activity;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.appmusicnew.Adapter.MainViewPagerAdapter;
import com.example.appmusicnew.Fragment.Fragment_Dangnhap;
import com.example.appmusicnew.Fragment.Fragment_TimKiem;
import com.example.appmusicnew.Fragment.Fragment_TrangChu;
import com.example.appmusicnew.R;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();

    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(), "Trang Chủ");
        mainViewPagerAdapter.addFragment(new Fragment_TimKiem(), "Tìm Kiếm");
        mainViewPagerAdapter.addFragment(new Fragment_Dangnhap(),"Người Dùng");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconuser);

    }

    private void anhxa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}