/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyzz
 */
public class ChiTietHoaDon_Dao {

    public ChiTietHoaDon_Dao() {

    }

    public ArrayList<ChiTietHoaDon> layDSCTHD() {

        ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from ChiTietHoaDon";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                HoaDon hd = new HoaDon(maHD);
                String maSP = rs.getString(2);
                SanPham sp = new SanPham(maSP);
                int soLuong = rs.getInt(3);

                ChiTietHoaDon cthd = new ChiTietHoaDon(soLuong, hd, sp);
                dsCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsCTHD;
    }

    public ArrayList<ChiTietHoaDon> layDSCTHDTheoMaHD(String maHD) {
        ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement("SELECT * FROM ChiTietHoaDon WHERE maHD = ?");
            ps.setString(1, maHD);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maSP = rs.getString(2);
                SanPham sp = sp_d.timTheoMa(maSP);
                int soLuong = rs.getInt(3);
                ChiTietHoaDon cthd = new ChiTietHoaDon(soLuong, new HoaDon(maHD), sp);
                dsCTHD.add(cthd);
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

        return dsCTHD;
    }

    public List<ChiTietHoaDon> TimtheomaHD(String maHD) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ChiTietHoaDon> list = new ArrayList<>();      
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement("SELECT * FROM ChiTietHoaDon WHERE maHD=?");
            ps.setString(1, maHD);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maSP = rs.getString(2);
                SanPham sp = sp_d.timTheoMa(maSP);
                HoaDon hd = new HoaDon(maHD);
                int soluong = rs.getInt(3);
                list.add(new ChiTietHoaDon(soluong, hd, sp));
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
        return list;
    }
    private SanPham_Dao sp_d = new SanPham_Dao();

    public boolean themHD(entity.ChiTietHoaDon cthd) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO ChiTietHoaDon VALUES (?,?,?)");
            ps.setString(1, cthd.getHoaDon().getMaHD());
            ps.setString(2, cthd.getSanPham().getMaSP());
            ps.setInt(3, cthd.getSoLuong());
            sp_d.banHang(cthd.getSanPham().getMaSP(), cthd.getSoLuong());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    public boolean xoaHD(String maHD){
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM ChiTietHoaDon WHERE maHD=?");
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
   
}
