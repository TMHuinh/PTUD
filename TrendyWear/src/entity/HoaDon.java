package entity;

import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class HoaDon {

    private String maHD, thanhToan, khuyenMai;
    private LocalDateTime ngayLap;
    private NhanVien nhanVien;
    private KhachHang khachHang;

    public HoaDon(String maHD, String thanhToan, String khuyenMai, LocalDateTime ngayLap, NhanVien nhanVien, KhachHang khachHang) {
        this.maHD = maHD;
        this.thanhToan = thanhToan;
        this.khuyenMai = khuyenMai;
        this.ngayLap = ngayLap;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public HoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaHD() {
        return maHD;
    }

    private void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHD);
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
        HoaDon other = (HoaDon) obj;
        return Objects.equals(maHD, other.maHD);
    }

    public double tinhTong(String maHD) {
        ChiTietHoaDon_Dao ctd = new ChiTietHoaDon_Dao();
        List<ChiTietHoaDon> lct = ctd.layDSCTHDTheoMaHD(maHD);
        double tong = 0;
        for (ChiTietHoaDon chiTietHoaDon : lct) {
            tong += chiTietHoaDon.thanhTien();
        }
        HoaDon_Dao hdd = new HoaDon_Dao();
        HoaDon hd = hdd.timHD(maHD);
        if(hd.getKhuyenMai().equals("5%")){
            tong*=0.95;
        }
        return tong;
    }
}
