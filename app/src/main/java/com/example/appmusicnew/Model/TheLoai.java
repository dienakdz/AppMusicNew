package com.example.appmusicnew.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TheLoai {

@SerializedName("idTheLoai")
@Expose
private String idTheLoai;
@SerializedName("idChuDe")
@Expose
private String idChuDe;
@SerializedName("tenTheLoai")
@Expose
private String tenTheLoai;
@SerializedName("hinhTheLoai")
@Expose
private String hinhTheLoai;

public String getIdTheLoai() {
return idTheLoai;
}

public void setIdTheLoai(String idTheLoai) {
this.idTheLoai = idTheLoai;
}

public String getIdChuDe() {
return idChuDe;
}

public void setIdChuDe(String idChuDe) {
this.idChuDe = idChuDe;
}

public String getTenTheLoai() {
return tenTheLoai;
}

public void setTenTheLoai(String tenTheLoai) {
this.tenTheLoai = tenTheLoai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

}