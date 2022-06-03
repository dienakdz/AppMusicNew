package com.example.appmusicnew.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Nguoidung {

    @SerializedName("idNguoiDung")
    @Expose
    private String idNguoiDung;
    @SerializedName("tenNguoiDung")
    @Expose
    private String tenNguoiDung;
    @SerializedName("taiKhoan")
    @Expose
    private String taiKhoan;
    @SerializedName("matKhau")
    @Expose
    private String matKhau;
    @SerializedName("userPlayList")
    @Expose
    private String userPlayList;

    public String getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(String idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getUserPlayList() {
        return userPlayList;
    }

    public void setUserPlayList(String userPlayList) {
        this.userPlayList = userPlayList;
    }

}