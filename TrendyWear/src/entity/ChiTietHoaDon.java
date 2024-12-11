package entity;

public class ChiTietHoaDon {

	private int soLuong;	
	private HoaDon hoaDon;
	private SanPham sanPham;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}	
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}	
	public ChiTietHoaDon() {
		super();
	}

    public ChiTietHoaDon(int soLuong, HoaDon hoaDon, SanPham sanPham) {
        this.soLuong = soLuong;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
    }
     public double thanhTien(){
         return soLuong*sanPham.getGia();
     }
	
	
}
