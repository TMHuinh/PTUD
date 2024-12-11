package entity;

import java.util.Objects;

public class SanPham {

	private String maSP, tenSP, mauSac, kichCo,hinhAnh,thuongHieu;
	private double gia;
	private int soLuongTon;
	private NhaCungCap nhaCungCap;
	private LoaiSanPham loaiSanPham;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getKichCo() {
		return kichCo;
	}
	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham(String maSP, String tenSP, String mauSac, String kichCo, String hinhAnh, String thuongHieu,
			double gia, int soLuongTon, NhaCungCap nhaCungCap, LoaiSanPham loaiSanPham) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.mauSac = mauSac;
		this.kichCo = kichCo;
		this.hinhAnh = hinhAnh;
		this.thuongHieu = thuongHieu;
		this.gia = gia;
		this.soLuongTon = soLuongTon;
		this.nhaCungCap = nhaCungCap;
		this.loaiSanPham = loaiSanPham;
	}
	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}
	
	
}
