package com.example.appmusicnew.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ChuDe {

@SerializedName("idChuDe")
@Expose
private String idChuDe;
@SerializedName("tenChuDe")
@Expose
private String tenChuDe;
@SerializedName("hinhChuDe")
@Expose
private String hinhChuDe;

public String getIdChuDe() {
return idChuDe;
}

public void setIdChuDe(String idChuDe) {
this.idChuDe = idChuDe;
}

public String getTenChuDe() {
return tenChuDe;
}

public void setTenChuDe(String tenChuDe) {
this.tenChuDe = tenChuDe;
}

public String getHinhChuDe() {
return hinhChuDe;
}

public void setHinhChuDe(String hinhChuDe) {
this.hinhChuDe = hinhChuDe;
}

}