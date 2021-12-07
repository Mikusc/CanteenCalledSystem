package SQL;

import java.sql.*;

public class MySQL_connect {

    private static final String url = "jdbc:mysql://localhost:3306/CanteenCalledSystem?serverTimezone=UTC&characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "Xkw134625134625";
    private static Connection con = null;

    public static Connection getConn() {
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获取连接
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConn(Connection conn, Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConn(Connection conn, Statement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(getConn());
    }

}

