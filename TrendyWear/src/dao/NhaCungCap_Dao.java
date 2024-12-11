package dao;

import database.ConnectDB;
import entity.NhaCungCap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.List;
public class NhaCungCap_Dao {

    public NhaCungCap_Dao() {

    }

    public ArrayList<NhaCungCap> layDSNCC() {
           ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from NhaCungCap";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maNCC = rs.getString(1);
                String tenNCC = rs.getString(2);
                String diaChi = rs.getString(3);
                String sDT = rs.getString(4);
                String email = rs.getString(5);

                NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sDT, email);
                dsNCC.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsNCC;
    }
    public boolean themNCC(NhaCungCap ncc) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("insert INTO NhaCungCap VALUES (?,?,?,?,?)");
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getDienThoai());
            ps.setString(5, ncc.getEmail());
            n = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    public boolean xoaNCC(String maNCC) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("DELETE FROM NhaCungCap WHERE maNCC=?");
            ps.setString(1, maNCC);
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
    public boolean CapNhat(NhaCungCap ncc) {
        Connection con = ConnectDB.getConnection();
        PreparedStatement ps = null;
        int n = 0;
        try {
            ps = con.prepareStatement("UPDATE NhaCungCap SET tenNCC=?,  diaChi=?, dienThoai=?, email=? WHERE maNCC=?");
            ps.setString(5, ncc.getMaNCC());
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getDienThoai());
            ps.setString(4, ncc.getEmail());
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
    public List<NhaCungCap> Tim(String tenNCC) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NhaCungCap> list = new ArrayList<>();

        try {
            con = ConnectDB.getConnection();
            
                ps = con.prepareStatement("SELECT * FROM NhaCungCap WHERE tenNCC like ? ");
                ps.setString(1,"%"+tenNCC+"%");              
                rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(ncc);           
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
    public NhaCungCap timTheoMa(String ma){
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        NhaCungCap ncc= null;

        try {
            con = ConnectDB.getConnection();
            
                ps = con.prepareStatement("SELECT * FROM NhaCungCap WHERE maNCC = ? ");
                ps.setString(1,ma);              
                rs = ps.executeQuery();
            while(rs.next()) {
                ncc = new NhaCungCap(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));        
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
        return ncc;
        
    }
}
