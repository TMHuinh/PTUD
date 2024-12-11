/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.SanPham;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author duyzz
 */
public class SanPham_Dao {

    private NhaCungCap_Dao ncc_d = new NhaCungCap_Dao();
    private LoaiSanPham_Dao lsp_d = new LoaiSanPham_Dao();

    public SanPham_Dao() {
    }

    public ArrayList<SanPham> layDSSP() {

        ArrayList<SanPham> ds = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from SanPham";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ds.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

    public boolean themSP(SanPham sp) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO SanPham VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getMauSac());
            ps.setString(4, sp.getKichCo());
            ps.setString(5, sp.getHinhAnh());
            ps.setDouble(6, sp.getGia());
            ps.setString(7, sp.getThuongHieu());
            ps.setInt(8, sp.getSoLuongTon());
            ps.setString(9, sp.getNhaCungCap().getMaNCC());
            ps.setString(10, sp.getLoaiSanPham().getMaLoai());
            n = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaSP(String maSP) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM SanPham WHERE maSP=?");
            ps.setString(1, maSP);
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

    public boolean CapNhat(SanPham sp) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE SanPham SET tenSP=?,  mauSac=?, kichCo=?, hinhAnh=?, gia=?, thuongHieu=?, soLuongTon=?, maNCC=?, maLoai=? WHERE maSP=?");
            ps.setString(10, sp.getMaSP());
            ps.setString(1, sp.getTenSP());
            ps.setString(2, sp.getMauSac());
            ps.setString(3, sp.getKichCo());
            ps.setString(4, sp.getHinhAnh());
            ps.setDouble(5, sp.getGia());
            ps.setString(6, sp.getThuongHieu());
            ps.setInt(7, sp.getSoLuongTon());
            ps.setString(8, sp.getNhaCungCap().getMaNCC());
            ps.setString(9, sp.getLoaiSanPham().getMaLoai());
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

    public String getURL(String ma) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        String url = "";
        try {
            ps = con.prepareStatement("SELECT hinhAnh FROM SanPham WHERE maSP=?");
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                url = rs.getString(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return url;
    }

    public boolean banHang(String ma, int soLuong) {
        int n = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectDB.getConnection();
            if (con != null) {
                    ps = con.prepareStatement("UPDATE SanPham SET soLuongTon = soLuongTon - ? WHERE maSP = ?");
                    ps.setInt(1, soLuong);
                    ps.setString(2, ma);
                    n = ps.executeUpdate();
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
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

        return n > 0;
    }

    public SanPham timTheoMa(String maSP) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SanPham sp = null;

        try {
            // Khởi tạo kết nối (thay đổi thông tin kết nối cho phù hợp)
            con = ConnectDB.getConnection();

            ps = con.prepareStatement("SELECT * FROM SanPham WHERE maSP=?");
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            if (rs.next()) {
                sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10)));
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
        return sp;
    }
    public boolean tonKho(String maSP,int soLuong){
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int slt=0;
        try {
            ps = con.prepareStatement("SELECT soLuongTon FROM SanPham WHERE maSP=?");
            ps.setString(1, maSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               slt=rs.getInt(1);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return slt>=soLuong;
    }
    public List<entity.SanPham> timSP(String tenSP,String loaiSP,String nhaCC,int o) throws SQLException{
        List<SanPham> list = new ArrayList<>();
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        ResultSet rs=null;
        if(o==0){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE tenSP LIKE ?");
           ps.setString(1, "%"+tenSP+"%");
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==1){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE tenSP LIKE ? AND maLoai = ?");
           ps.setString(1, "%"+tenSP+"%");
           ps.setString(2, loaiSP);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==2){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE tenSP LIKE ? AND maNCC = ?");
           ps.setString(1,"%"+tenSP+"%");
           ps.setString(2, nhaCC);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==3){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE maLoai=?");
           ps.setString(1, loaiSP);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==4){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE maLoai=? AND maNCC = ? ");
           ps.setString(1, loaiSP);
           ps.setString(2,nhaCC);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==5){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE maNCC = ? ");
           ps.setString(1,nhaCC);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }else if(o==6){
           ps = con.prepareStatement("SELECT * FROM SanPham WHERE tenSP LIKE ? AND maLoai=? AND maNCC=? ");
           ps.setString(1,"%"+tenSP+"%");
           ps.setString(2, loaiSP);
           ps.setString(3, nhaCC);
           rs=ps.executeQuery();
           while(rs.next()){
               list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getDouble(6), rs.getInt(8), ncc_d.timTheoMa(rs.getString(9)), lsp_d.timTheoMa(rs.getString(10))));
           }
        }
        return list;
    }
    public boolean nhapHang(String maSP,int soLuong){
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n=0;
        try {
            ps = con.prepareStatement("UPDATE SanPham SET soLuongTon=soLuongTon+? WHERE maSP=?");
            ps.setString(2, maSP);
            ps.setInt(1,soLuong);
            n=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n>0;
    }
    
}
