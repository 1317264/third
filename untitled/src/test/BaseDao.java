package test;
import java.sql.*;
public class BaseDao {
    private String url="jdbc:mysql://localhost:3306/sms?serverTimezone=GMT%2B8&useSSL=false";
    private String user="root";
    private String pass="123";
    Connection conn=null;

    protected Connection getConnetconn() {
        conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    protected void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null)
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public int executeUpdate(String sql ,Object []ob) {
        conn = getConnetconn();
        PreparedStatement ps = null;
        try {
            ps = prepareStatement(conn, sql, ob);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            return 0;
        } finally {
            closeAll(conn, ps, null);
        }
    }

    protected PreparedStatement prepareStatement(Connection conn, String sql, Object[] ob) {

        PreparedStatement ps = null;
        try {
            int index = 1;
            ps = conn.prepareStatement(sql);
            if (ps != null && ob != null) {
                for (int i = 0; i < ob.length; i++) {
                    ps.setObject(index, ob[i]);
                    index++;
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return ps;
    }
}
