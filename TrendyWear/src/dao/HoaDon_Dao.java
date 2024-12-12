package dao;

import database.ConnectDB;
import entity.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDon_Dao {

    private NhanVien_Dao nvd = new NhanVien_Dao();
    private KhachHang_Dao khd = new KhachHang_Dao();
    private ChiTietHoaDon_Dao cthd_d = new ChiTietHoaDon_Dao();

    public HoaDon_Dao() {

    }

    public ArrayList<HoaDon> layDSHD() {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from HoaDon ORDER BY ngayLap DESC";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                LocalDateTime ngayLap = rs.getTimestamp(2).toLocalDateTime();
                String thanhToan = rs.getString(3);
                String khuyenMai = rs.getString(6);
                HoaDon hd = new HoaDon(maHD, thanhToan, khuyenMai, ngayLap, nvd.timTheoMa(rs.getString(4)), khd.timTheoMaLayKH(rs.getString(5)));
                dsHD.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHD;
    }

    public boolean themHD(HoaDon hd) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO HoaDon VALUES (?,?,?,?,?,?)");
            ps.setString(1, hd.getMaHD());
            ps.setTimestamp(2, java.sql.Timestamp.valueOf(hd.getNgayLap()));
            ps.setString(3, hd.getThanhToan());
            ps.setString(4, hd.getNhanVien().getMaNV());
            ps.setString(5, hd.getKhachHang().getMaKH());
            ps.setString(6, hd.getKhuyenMai());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaHD(String maHD) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM HoaDon WHERE maHD=?");
            ps.setString(1, maHD);
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

    public HoaDon timHD(String maHD) {
        HoaDon hd = null;
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("SELECT * FROM HoaDon WHERE maHD=?");
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            if (rs.next()) {
                hd = new HoaDon(rs.getString(1), rs.getString(3), rs.getString(6), rs.getTimestamp(2).toLocalDateTime(), nvd.timTheoMa(rs.getString(4)), khd.timTheoMaLayKH(rs.getString(5)));
            }
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
        return hd;
    }

//    public List<HoaDon> timTheoThang(int month) {
//        List<HoaDon> list = new ArrayList<>();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement("SELECT * FROM HoaDon WHERE MONTH(ngayLap)=?");
//            ps.setInt(1, month);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new HoaDon(rs.getString(1), rs.getString(3), rs.getString(6), rs.getTimestamp(2).toLocalDateTime(), nvd.timTheoMa(rs.getString(4)), khd.timTheoMaLayKH(rs.getString(5))));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            ConnectDB.closeConnection(con);
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
//    public List<HoaDon> timTheoNam(int year) {
//        List<HoaDon> list = new ArrayList<>();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement("SELECT * FROM HoaDon WHERE YEAR(ngayLap)=?");
//            ps.setInt(1, year);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new HoaDon(rs.getString(1), rs.getString(3), rs.getString(6), rs.getTimestamp(2).toLocalDateTime(), nvd.timTheoMa(rs.getString(4)), khd.timTheoMaLayKH(rs.getString(5))));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            ConnectDB.closeConnection(con);
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
//    public List<HoaDon> timTheoThang_Nam(int month, int year) {
//        List<HoaDon> list = new ArrayList<>();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement("SELECT * FROM HoaDon WHERE YEAR(ngayLap)=? AND MONTH(ngayLap)=?");
//            ps.setInt(1, year);
//            ps.setInt(2, month);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new HoaDon(rs.getString(1), rs.getString(3), rs.getString(6), rs.getTimestamp(2).toLocalDateTime(), nvd.timTheoMa(rs.getString(4)), khd.timTheoMaLayKH(rs.getString(5))));
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            ConnectDB.closeConnection(con);
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
    public List<HoaDon> layDSHDTheoThangNam(int month, int year) {
        List<HoaDon> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.getConnection();
            StringBuilder query = new StringBuilder("SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ?");

            // Thêm điều kiện theo tháng nếu month != -1
            if (month != -1) {
                query.append(" AND MONTH(ngayLap) = ?");
            }

            query.append(" ORDER BY ngayLap DESC");

            ps = conn.prepareStatement(query.toString());
            ps.setInt(1, year);

            // Nếu có tham số tháng, set giá trị cho month
            if (month != -1) {
                ps.setInt(2, month);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hd = new HoaDon(
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(6),
                        rs.getTimestamp(2).toLocalDateTime(),
                        nvd.timTheoMa(rs.getString(4)),
                        khd.timTheoMaLayKH(rs.getString(5))
                );
                result.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn);
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public List<Integer> layDSNamHD() {
        List<Integer> namList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectDB.getConnection();
            String query = "SELECT DISTINCT YEAR(ngayLap) AS nam FROM HoaDon ORDER BY nam";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                namList.add(rs.getInt("nam"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(con);
        }

        return namList;
    }

    public boolean checkFK_HD_NV(String maNV) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getConnection(); // Phương thức kết nối CSDL
            String query = "SELECT * FROM HoaDon WHERE maNV=?";

            ps = con.prepareStatement(query);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(con);
        }

        return true;
    }

}
