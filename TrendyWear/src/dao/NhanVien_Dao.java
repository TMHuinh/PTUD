package dao;

import java.sql.Connection;
import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_Dao {

    public NhanVien_Dao() {

    }

    public ArrayList<NhanVien> layDSNV() {
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from NhanVien";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString(1);
                String hoTen = rs.getString(2);
                String sDT = rs.getString(3);
                String email = rs.getString(4);
                double luong = rs.getDouble(5);
                String diaChi = rs.getString(6);
                String chucVu = rs.getString(7);

                NhanVien nv = new NhanVien(maNV, hoTen, sDT, email, diaChi, chucVu, luong);
                dsNV.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNV;
    }

    public boolean themNV(NhanVien nv) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        TaiKhoan_Dao tk_d = new TaiKhoan_Dao();
        try {
            ps = con.prepareStatement("insert INTO NhanVien VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getDienThoai());
            ps.setString(4, nv.getEmail());
            ps.setDouble(5, nv.getLuong());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getChucVu());
            n = ps.executeUpdate();
            tk_d.themTK(new TaiKhoan(nv.getMaNV(), nv.getDienThoai(), nv.getChucVu(), nv));
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaNV(String maNV) {
        Connection con = ConnectDB.getConnection();
        TaiKhoan_Dao tk_d = new TaiKhoan_Dao();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM NhanVien WHERE maNV=?");
            ps.setString(1, maNV);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(con);
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean CapNhat(NhanVien nv) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE NhanVien SET tenNV=?,  dienThoai=?, Email=?, luong=?, diaChi=?, chucVu=? WHERE maNV=?");
            ps.setString(7, nv.getMaNV());
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getDienThoai());
            ps.setString(3, nv.getEmail());
            ps.setDouble(4, nv.getLuong());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getChucVu());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(con);
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public List<NhanVien> Tim(String tenNV, String sdt, String chucVu, int c) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NhanVien> list = new ArrayList<>();

        try {
            con = ConnectDB.getConnection();

            // Chọn câu truy vấn dựa vào giá trị của c
            if (c == 0) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE tenNV like ? and dienThoai like ? and chucVu like ?");
                ps.setString(1, "%" + tenNV + "%");
                ps.setString(2, "%" + sdt + "%");
                ps.setString(3, "%" + chucVu + "%");
            } else if (c == 1) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE tenNV like ? and dienThoai like ?");
                ps.setString(1, "%" + tenNV + "%");
                ps.setString(2, "%" + sdt + "%");
            } else if (c == 2) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE tenNV like ? and chucVu like ?");
                ps.setString(1, "%" + tenNV + "%");
                ps.setString(2, "%" + chucVu + "%");
            } else if (c == 3) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE dienThoai like ? and chucVu like ?");
                ps.setString(1, "%" + sdt + "%");
                ps.setString(2, "%" + chucVu + "%");
            } else if (c == 4) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE tenNV like ?");
                ps.setString(1, "%" + tenNV + "%");
            } else if (c == 5) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE dienThoai like ?");
                ps.setString(1, "%" + sdt + "%");
            } else if (c == 6) {
                ps = con.prepareStatement("SELECT * FROM NhanVien WHERE chucVu like ?");
                ps.setString(1, "%" + chucVu + "%");
            }

            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Xử lý kết quả trả về
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString(1), // MaNV
                        rs.getString(2), // TenNV
                        rs.getString(3), // DienThoai
                        rs.getString(4), // Email
                        rs.getString(6), // DiaChi
                        rs.getString(7), // ChucVu
                        rs.getDouble(5) // Luong
                );
                list.add(nv);
            }

        } catch (SQLException e) {
            // In ra lỗi nếu có vấn đề trong quá trình truy vấn
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public NhanVien timTheoMa(String ma) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        NhanVien nv = null;

        try {
            con = ConnectDB.getConnection();

            ps = con.prepareStatement("SELECT * FROM NhanVien WHERE maNV = ? ");
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien(
                        rs.getString(1), // MaNV
                        rs.getString(2), // TenNV
                        rs.getString(3), // DienThoai
                        rs.getString(4), // Email
                        rs.getString(6), // DiaChi
                        rs.getString(7), // ChucVu
                        rs.getDouble(5) // Luong
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nv;
    }
}
