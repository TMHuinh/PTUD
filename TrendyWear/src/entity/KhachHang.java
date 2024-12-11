package entity;

import java.util.Objects;

public class KhachHang {

	private String maKH, tenKH, diaChi, dienThoai;
	private int soDiem;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public int getSoDiem() {
		return soDiem;
	}
	public void setSoDiem(int soDiem) {
		this.soDiem = soDiem;
	}
	public KhachHang(String maKH, String tenKH, String diaChi, String dienThoai, int soDiem) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.soDiem = soDiem;
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

    public KhachHang(String maKH, String tenKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
    }
        
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	
	
	
}
