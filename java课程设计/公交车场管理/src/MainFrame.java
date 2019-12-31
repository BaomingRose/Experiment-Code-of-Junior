import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MainFrame extends JFrame implements ActionListener{
    JLabel la1;     //车站编号
    JLabel la2;     //站点名
    JLabel la3;     //公交车号
    JButton b1;
    JButton b2;
    JButton b3;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JPanel jp1 = new JPanel();
    JTable table;
    JScrollPane panel;
    JMenuBar menuBar;

    public MainFrame() {
        this.setTitle("公交车站管理");
        this.setLocation(0, 20);
        this.setSize(1370, 700);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menu = new JMenu("选项");
        menuBar.add(menu);
        //创建菜单项
        JMenuItem item1 = new JMenuItem("增加");

        JMenuItem item2 = new JMenuItem("删除");
        JMenuItem item3 = new JMenuItem("修改");
        JMenuItem item4 = new JMenuItem("关闭");

        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menu.addSeparator();
        menu.add(item3);
        menu.addSeparator();
        menu.add(item4);

        la1 = new JLabel("车站编号");
        la2 = new JLabel("站点名");
        la3 = new JLabel("公交车号");
        b1 = new JButton("编号查询");
        b2 = new JButton("站点查询");
        b3 = new JButton("公交查询");
        la1.setLocation(10, 50);
        la1.setSize(70, 30);
        la1.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(la1);
        t1 = new JTextField();
        t1.setLocation(90, 50);
        t1.setSize(230, 30);
        this.add(t1);
        b1.setLocation(330, 50);
        b1.setSize(120, 30);
        b1.addActionListener(this);
        this.add(b1);
        la2.setSize(70, 30);
        la2.setLocation(460, 50);
        la2.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(la2);
        t2 = new JTextField();
        t2.setLocation(540, 50);
        t2.setSize(230, 30);

        this.add(t2);
        b2.setLocation(780, 50);
        b2.setSize(120, 30);
        b2.addActionListener(this);
        this.add(b2);
        la3 = new JLabel("公交车号");
        la3.setLocation(910, 50);
        la3.setSize(70, 30);
        la3.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(la3);
        t3 = new JTextField();
        t3.setLocation(990, 50);
        t3.setSize(230, 30);
        this.add(t3);
        b3 = new JButton("公交查询");
        b3.setLocation(1230, 50);
        b3.setSize(120, 30);
        b3.addActionListener(this);
        this.add(b3);

        jp1.setSize(1370, 50);
        jp1.setLocation(0, 100);
        JButton[] b = {new JButton("增加"), new JButton("删除"), new JButton("修改")};
        for (int i = 0; i < b.length; ++i) {
            jp1.add(b[i]);
            b[i].addActionListener(this);
        }
        jp1.setVisible(true);
        this.add(jp1);

        StationDAO dao = new StationDAO();
        ArrayList list = dao.findByStationName("");
        initTable(list);

        this.setVisible(true);
    }

    //初始化表格的方法
    public void initTable(ArrayList<BusStation> b){
        Collections.sort(b);
        if((b != null) || (b.size() != 0)) {
            if (panel != null) {
                this.remove(panel);
            }
            String[] columnNames = { "车站编号", "站点名", "所在位置", "经过公交", "状态"};
            String[][] values = new String[b.size()][5];
            for (int i = 0; i < b.size(); i++) {
                BusStation bus = (BusStation) b.get(i);
                values[i][0] = bus.getStNum();
                values[i][1] = bus.getStName();
                values[i][2] = bus.getLocation();
                values[i][3] = bus.getPassingBusNo();
                values[i][4] = bus.getIsRun();
            }
            table = new JTable(values, columnNames);
            panel = new JScrollPane(table);
            panel.setSize(1360, 490);
            panel.setLocation(0, 130);
            this.add(panel);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        if(bt.getText().equals("编号查询")) {
            StationDAO dao = new StationDAO();
            ArrayList list = dao.findStationNum(t1.getText().trim());
            initTable(list);
        } else if(bt.getText().equals("站点查询")) {
            StationDAO dao = new StationDAO();
            ArrayList list = dao.findByStationName(t2.getText().trim());
            initTable(list);
        } else if (bt.getText().equals("公交查询")) {
            StationDAO dao = new StationDAO();
            ArrayList list = dao.findByBusNo(t3.getText().trim());
            initTable(list);
        } else if(bt.getText().equals("删除")) {
            if(table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "请选中要删除的车次");
            } else {
                StationDAO dao = new StationDAO();
                dao.delBusStation(table.getValueAt(table.getSelectedRow(),0).toString());
                ArrayList list = dao.findStationNum("");
                initTable(list);
            }
        } else if(bt.getText().equals("修改")) {
            if(table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的站点");
            } else {
                int row = table.getSelectedRow();
                String bno = table.getValueAt(row, 0).toString().trim();
                String start = table.getValueAt(row, 1).toString().trim();
                String end = table.getValueAt(row, 2).toString().trim();
                String pass = table.getValueAt(row, 3).toString().trim();
                String isRun = table.getValueAt(row, 4).toString().trim();
                //System.out.println(bno + start + end + pass + isRun);
                BusStation bus = new BusStation(bno, start, end, pass, isRun);
                AddOrUpdateFrame newFrame = new AddOrUpdateFrame("修改", bus, this);
            }
        } else {
            AddOrUpdateFrame newFrame=new AddOrUpdateFrame("增加",null,this);
        }
    }

}
