package com.example.appmusicnew.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Baihat {

    @SerializedName("idBaiHat")
    @Expose
    private String idBaiHat;
    @SerializedName("tenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("hinhBaiHat")
    @Expose
    private String hinhBaiHat;
    @SerializedName("caSi")
    @Expose
    private String caSi;
    @SerializedName("linkBaiHat")
    @Expose
    private String linkBaiHat;
    @SerializedName("luotThich")
    @Expose
    private String luotThich;

    public String getIdBaiHat() {
    return idBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
    this.idBaiHat = idBaiHat;
    }

    public String getTenBaiHat() {
    return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
    this.tenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
    return hinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
    this.hinhBaiHat = hinhBaiHat;
    }

    public String getCaSi() {
    return caSi;
    }

    public void setCaSi(String caSi) {
    this.caSi = caSi;
    }

    public String getLinkBaiHat() {
    return linkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
    this.linkBaiHat = linkBaiHat;
    }

    public String getLuotThich() {
    return luotThich;
    }

    public void setLuotThich(String luotThich) {
this.luotThich = luotThich;
}

}