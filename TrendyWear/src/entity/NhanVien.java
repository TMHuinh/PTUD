package entity;

import java.util.Objects;

public class NhanVien {

    private String maNV, tenNV, dienThoai, email, diaChi, chucVu;
    private double luong;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public NhanVien(String maNV, String tenNV, String dienThoai, String email, String diaChi, String chucVu,
            double luong) {
        super();
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.dienThoai = dienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public NhanVien(String maNV) {
        super();
        this.maNV = maNV;
    }

    public NhanVien(String maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNV);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NhanVien other = (NhanVien) obj;
        return Objects.equals(maNV, other.maNV);
    }

    @Override
    public String toString() {
        return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", dienThoai=" + dienThoai + ", email=" + email
                + ", diaChi=" + diaChi + ", chucVu=" + chucVu + ", luong=" + luong + "]";
    }
    

}
