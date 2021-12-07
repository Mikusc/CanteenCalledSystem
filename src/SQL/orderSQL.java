package SQL;

import Food_manage.food;
import java.sql.*;

public class orderSQL {

    public void order(Integer id){
        Connection conn = null;
        PreparedStatement stmt = null;
        food food = foodSQL.idFind(id);
        try {
            conn = MySQL_connect.getConn();
            String sql = "insert into number(food_name) values(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, food.getName());
            stmt.executeLargeUpdate();
            String sql1 = "select * from number where number in(select max(number)from number);";
            stmt = conn.prepareStatement(sql1);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                System.out.println("你的取餐号是：" + result.getInt("number"));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        finally {MySQL_connect.closeConn(conn,stmt);}
    }

}
