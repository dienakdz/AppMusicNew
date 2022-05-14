package com.example.appmusicnew.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {

@SerializedName("idQuangCao")
@Expose
private String idQuangCao;
@SerializedName("hinhQuangCao")
@Expose
private String hinhQuangCao;
@SerializedName("noiDung")
@Expose
private String noiDung;
@SerializedName("idBaiHat")
@Expose
private String idBaiHat;
@SerializedName("tenBaiHat")
@Expose
private String tenBaiHat;
@SerializedName("hinhBaiHat")
@Expose
private String hinhBaiHat;

public String getIdQuangCao() {
return idQuangCao;
}

public void setIdQuangCao(String idQuangCao) {
this.idQuangCao = idQuangCao;
}

public String getHinhQuangCao() {
return hinhQuangCao;
}

public void setHinhQuangCao(String hinhQuangCao) {
this.hinhQuangCao = hinhQuangCao;
}

public String getNoiDung() {
return noiDung;
}

public void setNoiDung(String noiDung) {
this.noiDung = noiDung;
}

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

}