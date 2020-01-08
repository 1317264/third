package test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StuDao extends BaseDao {
    public List<Stu> search(String sql,Object...params){
        List<Stu> list =new ArrayList<Stu>();
        Connection conn=this.getConnetconn();
        PreparedStatement pst=null;

        ResultSet rs=null;
        try {
            pst=this.prepareStatement(conn, sql, params);
            rs=pst.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                stu.setNum(rs.getString(1));
                stu.setName(rs.getString(2));
                stu.setStu_class(rs.getString(3));
                System.out.println(stu.getNum()+" "+stu.getName()+" "+stu.getStu_class());
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(conn, pst, rs);
        }
        return list;
    }

    public int insert(String num,String name,String stu_class){
        Stu stu=new Stu();
        stu.setNum(num);
        stu.setName(name);
        stu.setStu_class(stu_class);
        String str="INSERT INTO  stu ( num,name,class) VALUE(?,?,?)";
        return executeUpdate(str, new Object[]{stu.getNum(),stu.getName(),stu.getStu_class()});
    }

    public  int  update(String num,String name,String stu_class)
    {
        Stu stu=new Stu();
        stu.setNum(num);
        stu.setName(name);
        stu.setStu_class(stu_class);
        String sql="UPDATE  stu SET `name`=?,`class`=?  WHERE num=?";
        return executeUpdate(sql, new Object[]{stu.getName(),stu.getStu_class(),stu.getNum()});
    }

    public  int  delete(String num)
    {
        Stu stu=new Stu();
        stu.setNum(num);
        String sql="DELETE FROM `stu` WHERE num=?";
        return executeUpdate(sql, new Object[]{stu.getNum()});
    }
}
