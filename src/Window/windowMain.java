package Window;

import java.util.Objects;
import java.util.Scanner;
import SQL.numberSQL;

public class windowMain {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        numberSQL SQL = new numberSQL();
        while (true) {
            System.out.println("这里是食堂窗口内管理系统");
            System.out.println("请输入您要变更的订单号码(如要退出请输入0)：");
            Integer Number = Integer.valueOf(sc.next());
            if (!SQL.judge(Number))
                return;
            else {
                number number = numberSQL.numberFind(Number);
                System.out.println("号码：" + number.getNumber() + ",餐品名：" + number.getFood_name() + ",状态：" + number.getStatus());
                System.out.println("选择您的操作:");
                System.out.println("1.设置状态为待取餐");
                System.out.println("2.同学已取餐");
                System.out.println("请输入：");
                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1 -> change(Number);
                        case 2 -> delete(Number);
                        default -> throw new Exception("没有该功能，请重新选择");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void change(Integer Number){
        numberSQL SQL= new numberSQL();
        SQL.changeStatus(Number);
        number numberAfter = numberSQL.numberFind(Number);
        System.out.println("号码：" + numberAfter.getNumber() + ",餐品名：" + numberAfter.getFood_name() + ",状态：" + numberAfter.getStatus());
    }

    public static void delete(Integer Number){
        numberSQL SQL= new numberSQL();
        while (true) {
            System.out.println("确认要删除吗？[y/n]");
            String yn = sc.next();
            if (Objects.equals(yn, "y")) {
                SQL.delete(Number);
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
