package SQL;

import Food_manage.food;
import java.sql.*;
import  java.util.*;

public class foodSQL {

    //添加餐品信息
    public void add(food food){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "insert into food(id,name) values(?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,food.getId());
            stmt.setString(2,food.getName());
            stmt.executeLargeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
        System.out.println("添加成功！");
    }

    //按编号搜索餐品信息
    public static food idFind(Integer findId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        food food = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select * from food where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, findId);
            ResultSet result = stmt.executeQuery();
            food = new food();
            while (result.next()) {
                food.setId(result.getInt("id"));
                food.setName(result.getString("name"));
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn, stmt);}
        return food;
    }

    //按餐品名搜索餐品信息
    public static food nameFind(String findName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        food food = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select * from food where name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, findName);
            ResultSet result = stmt.executeQuery();
            food = new food();
            while (result.next()) {
                food.setId(result.getInt("id"));
                food.setName(result.getString("name"));
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn, stmt);}
        return food;
    }

    //用编号判断表中是否存在该餐品
    public boolean judgeId(Integer foodId){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select count(*) as count from food where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, foodId);
            rs = stmt.executeQuery();
            while(rs.next()){
                count = rs.getInt("count");
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally{MySQL_connect.closeConn(conn, stmt, rs);}
        return count != 0;
    }

    //用餐品名判断表中是否存在该餐品
    public boolean judgeName(String foodName){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = MySQL_connect.getConn();
            String sql = "select count(*) as count from food where name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, foodName);
            rs = stmt.executeQuery();
            while(rs.next()){
                count = rs.getInt("count");
            }
        }
        catch (SQLException e) {e.printStackTrace();}
        finally{MySQL_connect.closeConn(conn, stmt, rs);}
        return count != 0;
    }

    //遍历餐品信息
    public List<food> getAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<food> foodList = new ArrayList<>();
        try {
            conn = MySQL_connect.getConn();
            String sql = "select * from food";
            stmt = conn.createStatement();
            rs= stmt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                food food = new food(id,name);
                foodList.add(food);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt,rs);}
        return foodList;
    }

    //更改餐品信息
    public void changeName(Integer changeID, String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "update food set name = ? where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setInt(2,changeID);
            stmt.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
        System.out.println("餐品名修改成功！");
    }

    //删除餐品信息
    public void delete(Integer deleteID) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = MySQL_connect.getConn();
            String sql = "delete from food where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,deleteID);
            stmt.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
        System.out.println("餐品信息删除成功！");
    }

}



