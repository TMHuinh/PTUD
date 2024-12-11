/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author duyzz
 */
public class TaiKhoan_Dao {

    public TaiKhoan_Dao() {
    }

    public ArrayList<TaiKhoan> layDSKH() {

        ArrayList<TaiKhoan> dsTK = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from TaiKhoan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tenDN = rs.getString(1);
                String matKhau = rs.getString(2);
                String loaiTK = rs.getString(3);
                String maNV = rs.getString(4);
                TaiKhoan tk = new TaiKhoan(tenDN, matKhau, loaiTK, new NhanVien(maNV));
                dsTK.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTK;
    }

    public boolean themTK(TaiKhoan tk) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO TaiKhoan VALUES (?,?,?,?)");
            ps.setString(1, tk.getTenTK());
            ps.setString(2, BCrypt.hashpw("trendywear", BCrypt.gensalt()));
            ps.setString(3, tk.getLoaiTK());
            ps.setString(4, tk.getNhanVien().getMaNV());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaTK(String tenDN) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM TaiKhoan WHERE tenTK=?");
            ps.setString(1, tenDN);
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

    public TaiKhoan dangNhap(String tenDN) {
        TaiKhoan tk = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        NhanVien_Dao nv_d = new NhanVien_Dao();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            ps = con.prepareStatement("Select * from TaiKhoan WHERE tenTK=?");
            ps.setString(1, tenDN);
            rs = ps.executeQuery();
            if (rs.next()) {
                tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), nv_d.timTheoMa(rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;
    }

    public boolean CapNhat(TaiKhoan tk) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE TaiKhoan SET  matKhau=?, loaiTK=?, maNV=? WHERE tenTK=?");
            ps.setString(4, tk.getTenTK());
            ps.setString(1, tk.getMatKhau());
            ps.setString(2, tk.getLoaiTK());
            ps.setString(3, tk.getNhanVien().getMaNV());
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

    public TaiKhoan timTheoMa(String ma) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TaiKhoan tk = null;
        NhanVien_Dao nv_d = new NhanVien_Dao();

        try {
            con = ConnectDB.getConnection();

            ps = con.prepareStatement("SELECT * FROM TaiKhoan WHERE tenTK = ? ");
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), nv_d.timTheoMa(rs.getString(4)));
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
        return tk;
    }
}
