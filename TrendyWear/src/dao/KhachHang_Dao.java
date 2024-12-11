package dao;

import java.sql.Connection;
import database.ConnectDB;
import entity.KhachHang;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang_Dao {

    public KhachHang_Dao() {
    }

    public ArrayList<KhachHang> layDSKH() {

        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from KhachHang";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maKH = rs.getString(1);
                String hoTen = rs.getString(2);
                String diaChi = rs.getString(3);
                String sDT = rs.getString(4);
                int soDiem = rs.getInt(5);

                KhachHang kh = new KhachHang(maKH, hoTen, diaChi, sDT, soDiem);
                dsKH.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsKH;
    }

    public boolean themKH(KhachHang khachHang) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO KhachHang VALUES (?,?,?,?,?)");
            ps.setString(1, khachHang.getMaKH());
            ps.setString(2, khachHang.getTenKH());
            ps.setString(3, khachHang.getDiaChi());
            ps.setString(4, khachHang.getDienThoai());
            ps.setInt(5, khachHang.getSoDiem());
            n = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaKH(String maKH) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM KhachHang WHERE maKH=?");
            ps.setString(1, maKH);
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

    public boolean CapNhat(KhachHang kh) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE KhachHang SET tenKH=?,  diaChi=?, dienThoai=?, soDiem=? WHERE maKH=?");
            ps.setString(5, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getDiaChi());
            ps.setString(3, kh.getDienThoai());
            ps.setInt(4, kh.getSoDiem());
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

    public List<KhachHang> Tim(String chuoi, int c, String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<KhachHang> listKH = new ArrayList<>();

        try {
            con = ConnectDB.getConnection();
            if (c == 1) {
                ps = con.prepareStatement("SELECT * FROM KhachHang WHERE tenKH like ? and dienThoai like ?");
                ps.setString(1, "%" + chuoi + "%");
                ps.setString(2, "%" + sdt + "%");
                rs = ps.executeQuery();
            } else if (c == 0) {
                ps = con.prepareStatement("SELECT * FROM KhachHang WHERE tenKH like ?");
                ps.setString(1,"%"+chuoi+"%");
                rs = ps.executeQuery();
            } else if (c == 2) {
                ps = con.prepareStatement("SELECT * FROM KhachHang WHERE dienThoai like ?");
                ps.setString(1,"%"+sdt+"%");
                rs = ps.executeQuery();
            }
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)));
                listKH.add(kh);

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
        return listKH;
    }

    public Map<String,Integer> layDiem(String sdt) {
        Map<String,Integer> map = new HashMap<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Khởi tạo kết nối (thay đổi thông tin kết nối cho phù hợp)
            con = ConnectDB.getConnection();

            ps = con.prepareStatement("SELECT tenKH,soDiem FROM KhachHang WHERE dienThoai = ?");
            ps.setString(1,  sdt );

            rs = ps.executeQuery();
            if (rs.next()) {
                map.put(rs.getNString("tenKH"),rs.getInt("soDiem"));
            }else{
                 map.put("Không tồn tại",-1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi
        } finally {
            // Đảm bảo tài nguyên được đóng
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
                e.printStackTrace(); // In ra lỗi khi đóng tài nguyên
            }
        }
        return map;
    }

    public KhachHang timTheoMa(String ten, String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        KhachHang kh = null;

        try {
            // Khởi tạo kết nối (thay đổi thông tin kết nối cho phù hợp)
            con = ConnectDB.getConnection();

            ps = con.prepareStatement("SELECT * FROM KhachHang WHERE tenKH LIKE ? AND dienThoai LIKE ?");
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + sdt + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String hoTen = rs.getString(2);
                String diaChi = rs.getString(3);
                String sDT = rs.getString(4);
                int soDiem = rs.getInt(5);
                kh = new KhachHang(maKH, hoTen, diaChi, sDT, soDiem);

            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi
        } finally {
            // Đảm bảo tài nguyên được đóng
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
                e.printStackTrace(); // In ra lỗi khi đóng tài nguyên
            }
        }
        return kh;
    }

    public KhachHang timTheoMaLayKH(String maNV) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        KhachHang kh = null;

        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement("SELECT * FROM KhachHang WHERE maKH=?");
            ps.setString(1, maNV);
            rs = ps.executeQuery();

            while (rs.next()) {
                String hoTen = rs.getString(2);
                String diaChi = rs.getString(3);
                String sDT = rs.getString(4);
                int soDiem = rs.getInt(5);
                kh = new KhachHang(maNV, hoTen, diaChi, diaChi, soDiem);
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
        return kh;
    }

    public void doiThuong(String ten, String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Khởi tạo kết nối (thay đổi thông tin kết nối cho phù hợp)
            con = ConnectDB.getConnection();
            ps = con.prepareStatement("UPDATE KhachHang SET soDiem=soDiem-10 WHERE tenKH LIKE ? AND dienThoai LIKE ?");
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + sdt + "%");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi
        } finally {
            // Đảm bảo tài nguyên được đóng
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In ra lỗi khi đóng tài nguyên
            }
        }
    }

    public void tichDiem(String ten, String sdt) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // Khởi tạo kết nối (thay đổi thông tin kết nối cho phù hợp)
            con = ConnectDB.getConnection();
            ps = con.prepareStatement("UPDATE KhachHang SET soDiem=soDiem+1 WHERE tenKH LIKE ? AND dienThoai LIKE ?");
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + sdt + "%");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi
        } finally {
            // Đảm bảo tài nguyên được đóng
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // In ra lỗi khi đóng tài nguyên
            }
        }
    }
}
