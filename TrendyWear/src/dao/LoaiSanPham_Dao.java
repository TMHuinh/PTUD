/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.ConnectDB;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import java.util.List;
/**
 *
 * @author duyzz
 */
public class LoaiSanPham_Dao {
    public LoaiSanPham_Dao(){
        
    }
    public List<entity.LoaiSanPham> layDSLSP() {

        List<LoaiSanPham> ds = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from LoaiSanPham";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(1),rs.getString(2),rs.getString(3));
                ds.add(lsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

    public boolean themLSP(LoaiSanPham lsp) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO LoaiSanPham VALUES (?,?,?)");
            ps.setString(1, lsp.getMaLoai());
            ps.setString(2, lsp.getTenLoai());
            ps.setString(3, lsp.getMoTa());
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaLSP(String maLSP) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM LoaiSanPham WHERE maLoai=?");
            ps.setString(1, maLSP);
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
    public boolean CapNhat(LoaiSanPham lsp) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE LoaiSanPham SET tenLoai=?,  moTa=? WHERE maLoai=?");
            ps.setString(3, lsp.getMaLoai());
            ps.setString(1, lsp.getTenLoai());
            ps.setString(2, lsp.getMoTa());          
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
     public LoaiSanPham timTheoMa(String ma){
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        LoaiSanPham lsp= null;

        try {
            con = ConnectDB.getConnection();
            
                ps = con.prepareStatement("SELECT * FROM LoaiSanPham WHERE maLoai = ? ");
                ps.setString(1,ma);              
                rs = ps.executeQuery();
            while(rs.next()) {
                lsp = new LoaiSanPham(rs.getString(1),rs.getString(2),rs.getString(3));
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
        return lsp;
        
    }
}
