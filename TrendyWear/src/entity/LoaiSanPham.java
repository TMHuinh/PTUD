package entity;

import java.util.Objects;

public class LoaiSanPham {

	private String maLoai, tenLoai,moTa;

    public LoaiSanPham(String maLoai, String tenLoai, String moTa) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.moTa = moTa;
    }

    public LoaiSanPham(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
        
	
}
