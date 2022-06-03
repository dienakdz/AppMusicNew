package com.example.appmusicnew.Service;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private final String INTRO = "intro";
    private final String NAME = "name";
    private final  String Taikhoan = "taikhoan";
    private final String Matkhau = "matkhau";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context) {
        app_prefs = context.getSharedPreferences("shared",
                Context.MODE_PRIVATE);
        this.context = context;
    }

    public void putIsLogin(boolean loginorout,boolean taiKhoan,boolean matKhau) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginorout);
        edit.putBoolean(INTRO, taiKhoan);
        edit.putBoolean(INTRO, matKhau);
        edit.commit();

    }
    public boolean getIsLogin() {
        return app_prefs.getBoolean(INTRO, false);
    }

    public void putName(String loginorout) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginorout);
        edit.commit();
    }
    public String getName() {
        return app_prefs.getString(NAME, "");
    }

    public void putTaikhoan(String taiKhoan) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(Taikhoan, taiKhoan);
        edit.commit();
    }
    public String getTaikhoan() {
        return app_prefs.getString(Taikhoan, "");
    }

    public void putMatkhau(String matKhau) {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(Matkhau, matKhau);
        edit.commit();
    }
    public String getMatkhau() {
        return app_prefs.getString(Matkhau, "");
    }

}
