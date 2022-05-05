package com.example.appmusicnew.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

@SerializedName("idPlayList")
@Expose
private String idPlayList;
@SerializedName("ten")
@Expose
private String ten;
@SerializedName("hinhNen")
@Expose
private String hinhNen;
@SerializedName("hinhIcon")
@Expose
private String hinhIcon;

public String getIdPlayList() {
return idPlayList;
}

public void setIdPlayList(String idPlayList) {
this.idPlayList = idPlayList;
}

public String getTen() {
return ten;
}

public void setTen(String ten) {
this.ten = ten;
}

public String getHinhNen() {
return hinhNen;
}

public void setHinhNen(String hinhNen) {
this.hinhNen = hinhNen;
}

public String getHinhIcon() {
return hinhIcon;
}

public void setHinhIcon(String hinhIcon) {
this.hinhIcon = hinhIcon;
}

}