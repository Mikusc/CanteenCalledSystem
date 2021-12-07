package Food_manage;

import java.util.Scanner;

public class foodMain {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("------------------");
            System.out.println("欢迎来到餐品管理系统");
            System.out.println("1 显示所有餐品菜单");
            System.out.println("2 按编号搜索餐品信息");
            System.out.println("3 按名称搜索餐品信息");
            System.out.println("4 增添餐品信息");
            System.out.println("5 修改餐品信息");
            System.out.println("6 删除餐品信息");
            System.out.println("7 退出系统");
            System.out.println("------------------");
            System.out.println("请选择：");

            int choice = sc.nextInt();

            try {

                //退出系统
                if (choice == 7){
                    System.out.println("您已退出该系统");
                    return;
                }
                else foodManage.Manage(choice);

            }
            catch (Exception e) {System.out.println(e.getMessage());}

        }

    }

}
