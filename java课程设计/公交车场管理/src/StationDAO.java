import java.sql.*;
import java.util.ArrayList;

public class StationDAO {
    private Connection con;
    public StationDAO() {
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //配置连接字符串
            String conStr = "jdbc:sqlserver://localhost:1433; DatabaseName=Station";
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

    //根据车站编号来查询公交车
    public ArrayList<BusStation> findStationNum(String num) {
        ArrayList<BusStation> bst = new ArrayList<BusStation>();
        try {
            Statement st = con.createStatement();
            //PreparedStatement ps = con.prepareStatement("select * from Point where StNum = '%" + num + "%'");
            //ps.setString(1, num);
            String sqlStr = "select * from Point where StNum like '%" + num + "%'";
            ResultSet rs = st.executeQuery(sqlStr);
            while (rs.next()) {
                String no = rs.getString(1).trim();
                String name = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String passBus = rs.getString(4).trim();
                String isRun = rs.getString(5).trim();
                BusStation bus = new BusStation(no, name, location, passBus, isRun);
                bst.add(bus);
            }
            st.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        } catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bst;
    }

    //根据车牌名来查询站点
    public ArrayList<BusStation> findByStationName(String StationName) {
        ArrayList<BusStation> result = new ArrayList<BusStation>();
        try {
            Statement st = con.createStatement();
            String strSQL = "select * from Point where Name like '%"+ StationName +"%'";
            ResultSet rs = st.executeQuery(strSQL);
            while(rs.next()) {
                String bno = rs.getString(1).trim();
                String name = rs.getString(2).trim();
                String location = rs.getString(3).trim();
                String passingBusNo = rs.getString(4).trim();
                String isRun = rs.getString(5).trim();
                BusStation bus = new BusStation(bno, name, location, passingBusNo, isRun);
                result.add(bus);
                //System.out.println(bno + name + location + passingBusNo + isRun);
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

    //根据公交车号来查询站点
    public ArrayList<BusStation> findByBusNo(String no) {
        ArrayList<BusStation> result = new ArrayList<BusStation>();
        //System.out.println(no);
        try {
            Statement st = con.createStatement();
            String strSQL = "select * from Point where passingBusNo like '%"+ no +"%'";
            ResultSet rs = st.executeQuery(strSQL);
            while(rs.next()) {
                String bno = rs.getString(1).trim();
                String name = rs.getString(2).trim();
                String loc = rs.getString(3).trim();
                String pass = rs.getString(4).trim();
                String isRun = rs.getString(5).trim();
                BusStation bus = new BusStation(bno, name, loc, pass, isRun);
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

    public void addBusStation(BusStation bus) {
        try {
            PreparedStatement ps = con.prepareStatement("insert into Point values(?,?,?,?,?)");
            //创建SQL语句执行对象
            ps.setString(1, bus.getStNum());
            ps.setString(2, bus.getStName());
            ps.setString(3, bus.getLocation());
            ps.setString(4, bus.getPassingBusNo());
            ps.setString(5, bus.getIsRun());
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

    public void delBusStation(String bno) {
        try{
            PreparedStatement ps = con.prepareStatement("delete from Point where StNum=?");
            //创建SQL语句执行对象
            ps.setString(1, bno);
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

    public void updateBus(BusStation bus) {
        try {
            //System.out.println(bus);
            PreparedStatement ps = con.prepareStatement("update Point set Name=?,Location=?,passingBusNo=?,isRun=? where StNum=?");
            //创建SQL语句执行对象
            ps.setString(5, bus.getStNum());
            ps.setString(1, bus.getStName());
            ps.setString(2,bus.getLocation());
            ps.setString(3, bus.getPassingBusNo());
            ps.setString(4, bus.getIsRun());
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
