package Order;

import Food_manage.*;
import java.util.Objects;
import java.util.Scanner;
import SQL.*;

public class orderMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        foodManage.list();

        foodSQL SQL = new foodSQL();
        orderSQL SQL1 = new orderSQL();

        System.out.println("请输入编号点餐：");
        Integer id = Integer.valueOf(sc.next());

        if(!SQL.judgeId(id))
            System.out.println("该餐品不存在！");
        else{
            food food = foodSQL.idFind(id);
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
            while (true) {
                System.out.println("确认要点这个吗？[y/n]");
                String yn = sc.next();
                if (Objects.equals(yn, "y")) {
                    SQL1.order(id);
                    break;
                }
                if (Objects.equals(yn, "n")) {
                    System.out.println("ok");
                    break;
                }
                else System.out.println("输入字符无效，请输入[y/n]");
            }

        }

    }
}
