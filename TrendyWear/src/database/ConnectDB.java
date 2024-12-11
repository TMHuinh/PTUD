package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {

    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public static Connection getConnection() {

        Connection con = null;
        String ulr = "jdbc:sqlserver://localhost:1433; databaseName=QLShopThoiTrang;user=sa;password=12345678;"
                + "encrypt=true;trustServerCertificate=true";
        try {
            con = DriverManager.getConnection(ulr);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        Connection con = getConnection();
//        if (con != null) {
//            System.out.println("Thanh cong");
//        } else {
//            System.out.println("Fail");
//        }
//    }
//    public static void main(String[] args) {
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLShopThoiTrang;encrypt=true;trustServerCertificate=true";
//        String user = "sa";
//        String password = "12345678";
//
//        try {
//            // Kết nối đến cơ sở dữ liệu
//            Connection conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Kết nối thành công!");
//
//            // Đóng kết nối
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
