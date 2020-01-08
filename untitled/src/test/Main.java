package test;
import java.sql.ResultSet;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StuDao stu=new StuDao();
        String num,name,stu_class;
        int temp;
        while (true){
            System.out.println("请输入：1、添加学生 2、删除学生 3、信息修改 4、信息查询 输入其他退出");
            String type=scan.nextLine();
            switch (type){
                case"1":
                    System.out.println("请输入学号");
                    num=scan.nextLine();
                    System.out.println("请输入名字");
                    name=scan.nextLine();
                    System.out.println("请输入班级");
                    stu_class=scan.nextLine();
                    temp=stu.insert(num,name,stu_class);
                    if(temp==1)System.out.println("添加成功");
                    else System.out.println("添加失败");
                    break;
                case "2":
                    System.out.println("请输入要删除学生的学号");
                    num=scan.nextLine();
                    temp=stu.delete(num);
                    if(temp==1) System.out.println("删除成功");
                    else System.out.println("删除失败");
                    break;
                case "3":
                    System.out.println("请输入要修改信息学生的学号");
                    num=scan.nextLine();
                    System.out.println("请输入修改后的名字");
                    name=scan.nextLine();
                    System.out.println("请输入修改后的班级");
                    stu_class=scan.nextLine();
                    temp=stu.update(num,name,stu_class);
                    if(temp==1) System.out.println("修改成功");
                    else System.out.println("修改失败");
                    break;
                case "4":
                    stu.search("select  num,name,class from  stu order by num");
                    break;
                default:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
            }
        }
    }
}
