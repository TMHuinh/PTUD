package entity;

import java.util.Objects;

public class TaiKhoan {

	private String tenTK, matKhau, loaiTK;
	private NhanVien nhanVien;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String matKhau, String loaiTK, NhanVien nhanVien) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
        this.nhanVien = nhanVien;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
        
}
