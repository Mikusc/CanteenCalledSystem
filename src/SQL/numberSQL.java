package SQL;

import Window.number;
import java.sql.*;

public class numberSQL {
    public boolean judge(Integer number){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select count(*) as count from number where number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, number);
            rs = stmt.executeQuery();
            while(rs.next()){
                count = rs.getInt("count");
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally{MySQL_connect.closeConn(conn, stmt, rs);}
        return count != 0;
    }

    public static number numberFind(Integer findNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        number number = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select * from number where number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, findNumber);
            ResultSet result = stmt.executeQuery();
            number = new number();
            while (result.next()) {
                number.setNumber(result.getInt("number"));
                number.setFood_name(result.getString("food_name"));
                number.setStatus(result.getString("status"));
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn, stmt);}
        return number;
    }

    public void changeStatus(Integer number) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "update number set status = 'Please pick up' where number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,number);
            stmt.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
        System.out.println("状态修改成功！");
    }

    public void delete(Integer Number) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "delete from number where number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Number);
            stmt.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
        System.out.println("餐品信息删除成功！");
    }
}
