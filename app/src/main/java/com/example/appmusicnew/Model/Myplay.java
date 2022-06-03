package com.example.appmusicnew.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Myplay implements Serializable {

@SerializedName("idMyPlayList")
@Expose
private String idMyPlayList;
@SerializedName("idBaiHat")
@Expose
private String idBaiHat;
@SerializedName("userPlayList")
@Expose
private String userPlayList;
@SerializedName("tenBaiHat")
@Expose
private String tenBaiHat;
@SerializedName("hinhBaiHat")
@Expose
private String hinhBaiHat;
@SerializedName("caSi")
@Expose
private String caSi;

public String getIdMyPlayList() {
return idMyPlayList;
}

public void setIdMyPlayList(String idMyPlayList) {
this.idMyPlayList = idMyPlayList;
}

public String getIdBaiHat() {
return idBaiHat;
}

public void setIdBaiHat(String idBaiHat) {
this.idBaiHat = idBaiHat;
}

public String getUserPlayList() {
return userPlayList;
}

public void setUserPlayList(String userPlayList) {
this.userPlayList = userPlayList;
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

}