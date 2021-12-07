package Food_manage;

import SQL.foodSQL;
import java.util.*;

public class foodManage {

    static Scanner sc = new Scanner(System.in);

    public static void Manage(int choice) throws Exception{
        switch (choice) {
            case 1 -> list();
            case 2 -> idFind();
            case 3 -> nameFind();
            case 4 -> add();
            case 5 -> change();
            case 6 -> delete();
            default -> throw new Exception("没有该功能，请重新选择");
        }
    }

    //显示所有餐品菜单
    public static void list(){
        foodSQL SQL = new foodSQL();
        List<food> list = SQL.getAll();
        System.out.println("餐品信息如下");
        for(food food : list){
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
        }
    }

    //按编号搜索餐品信息
    public static void idFind() {
        foodSQL SQL = new foodSQL();
        System.out.println("请输入餐品id：");
        Integer idFind = Integer.valueOf(sc.next());
        if(!SQL.judgeId(idFind))
            System.out.println("该餐品不存在！");
        else{
            food food = foodSQL.idFind(idFind);
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
        }
    }

    //按名称搜索餐品信息
    public static void nameFind(){
        foodSQL SQL = new foodSQL();
        System.out.println("请输入餐品名：");
        String nameFind = sc.next();
        if(!SQL.judgeName(nameFind))
            System.out.println("该餐品不存在！");
        else{
            food food = foodSQL.nameFind(nameFind);
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
        }
    }

    //增添餐品信息
    public static void add(){
        foodSQL SQL = new foodSQL();
        System.out.println("请输入要添加的餐品id：");
        Integer addID = Integer.valueOf(sc.next());
        if(SQL.judgeId(addID))
            System.out.println("该餐品已存在！");
        else {
            System.out.println("输入餐品名：");
            String name = sc.next();
            SQL.add(new food(addID, name));
            System.out.println("查询到如下信息：");
            list();
        }
    }

    //修改餐品信息
    public static void change(){
        foodSQL SQL = new foodSQL();
        System.out.println("请输入要修改的的餐品的编号：");
        Integer changeID = Integer.valueOf(sc.next());
        if (!SQL.judgeId(changeID))
            System.out.println("该餐品不存在！");
        else {
            food food = foodSQL.idFind(changeID);
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
            System.out.println("请输入修改后的餐品名：");
            String name = sc.next();
            SQL.changeName(changeID,name);
        }
        food foodAfter = foodSQL.idFind(changeID);
        System.out.println("编号：" + foodAfter.getId() + ",餐品名：" + foodAfter.getName());
    }

    //删除餐品信息
    public static void delete(){
        foodSQL SQL = new foodSQL();
        System.out.println("请输入要删除的的餐品的编号：");
        Integer deleteID = Integer.valueOf(sc.next());
        if (!SQL.judgeId(deleteID))
            System.out.println("该餐品不存在！");
        else {
            food food = foodSQL.idFind(deleteID);
            System.out.println("编号：" + food.getId() + ",餐品名：" + food.getName());
            while (true) {
                System.out.println("确认要删除吗？[y/n]");
                String yn = sc.next();
                if (Objects.equals(yn, "y")) {
                    SQL.delete(deleteID);
                    list();
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
