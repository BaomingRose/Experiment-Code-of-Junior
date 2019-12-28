import java.sql.*;
import java.util.*;

public class BusDAO {
    private Connection con;
    public BusDAO() {
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //配置连接字符串
            String conStr = "jdbc:sqlserver://localhost:1433; DatabaseName=BusStation";
            //配置用户名
            String user = "sa";
            //配置用户的访问密码
            String password = "1";
            //创建数据库连接对象
            con = DriverManager.getConnection(conStr,user,password);
        } catch (ClassNotFoundException e) {//捕捉处理驱动类未找到异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //根据公交车号来查询公交车
    public Bus findBusNum(int bno) {
        Bus bus = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from Bus where busNum = ?");
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int no = rs.getInt(1);
                String start = rs.getString(2);
                String end = rs.getString(3);
                String pass = rs.getString(4);
                bus = new Bus(no, start, end, pass);
            }
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bus;
    }

    //根据姓名来查询车站
    public ArrayList<Bus> findByBusStation(String StationName) {
        ArrayList<Bus> result=new ArrayList<Bus>();
        try {
            Statement st = con.createStatement();
            String strSQL = "select * from Bus where passStation like '%"+ StationName +"%' or startStation like '%" +StationName + "%' or endStation like '%" + StationName + "%" + "%'";
            ResultSet rs=st.executeQuery(strSQL);
            while(rs.next()) {
                int bno = rs.getInt(1);
                String start = rs.getString(2);
                String end = rs.getString(3);
                String pass = rs.getString(4);
                Bus bus = new Bus(bno, start, end, pass);
                result.add(bus);
            }
            st.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public void addBus(Bus bus) {
        try {
            PreparedStatement ps=con.prepareStatement("insert into Bus values(?,?,?,?)");
            //创建SQL语句执行对象
            ps.setInt(1, bus.getBusNum());
            ps.setString(2,bus.getStartStation());
            ps.setString(3, bus.getEndStation());
            ps.setString(4, bus.getPassStation());
            ps.execute();
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delBus(int bno) {
        try{
            PreparedStatement ps = con.prepareStatement("delete from Bus where busNum=?");
            //创建SQL语句执行对象
            ps.setInt(1, bno);
            ps.execute();
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateBus(Bus bus) {
        try {
            PreparedStatement ps=con.prepareStatement("update Bus set startStation=?,endStation=?,passStation=? where busNum=?");
            //创建SQL语句执行对象
            ps.setInt(1, bus.getBusNum());
            ps.setString(2,bus.getStartStation());
            ps.setString(3, bus.getEndStation());
            ps.setString(4, bus.getPassStation());
            ps.execute();
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
