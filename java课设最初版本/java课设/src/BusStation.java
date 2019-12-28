import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class BusStation extends JFrame implements ActionListener {
    JLabel la1;
    JLabel la2;
    JButton b1;
    JButton b2;
    JTextField t1;
    JTextField t2;
    JPanel jp1 = new JPanel();
    JTable table;
    JScrollPane panel;

    public BusStation() {
        this.setTitle("公交车站管理");
        this.setLocation(200, 100);
        this.setSize(1000, 600);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        la1 = new JLabel("公交车号");
        la2 = new JLabel("站点");
        b1 = new JButton("车号查询");
        b2 = new JButton("站点查询");
        la1.setSize(80, 30);
        la1.setLocation(10, 10);
        this.add(la1);
        t1 = new JTextField();
        t1.setSize(230, 30);
        t1.setLocation(100, 10);
        this.add(t1);
        b1.setSize(120, 30);
        b1.setLocation(350, 10);
        b1.addActionListener(this);
        this.add(b1);
        la2.setSize(50, 30);
        la2.setLocation(500, 10);
        this.add(la2);
        t2 = new JTextField();
        t2.setSize(230, 30);
        t2.setLocation(550, 10);
        this.add(t2);
        b2.setSize(120, 30);
        b2.setLocation(800, 10);
        b2.addActionListener(this);
        this.add(b2);

        jp1.setSize(1000, 50);
        jp1.setLocation(0, 60);
        JButton[] b = {new JButton("增加"), new JButton("删除"), new JButton("修改")};
        for (int i = 0; i < b.length; ++i) {
            jp1.add(b[i]);
            b[i].addActionListener(this);
        }
        jp1.setVisible(true);
        this.add(jp1);

        BusDAO dao = new BusDAO();
        ArrayList list = dao.findByBusStation("");

        /*
        Bus b1 = new Bus(336, "dsf", "dfs", "dfjk");
        Bus b2 = new Bus(719, "fs", "jfsd", "dkgjsdf");
        ArrayList<Bus> list = new ArrayList<Bus>();
        list.add(b1);
        list.add(b2);
        */

        initTable(list);

        this.setVisible(true);
    }

    //初始化表格的方法
    public void initTable(ArrayList<Bus> b){
        if((b != null) || (b.size() != 0)) {
            if (panel != null) {
                this.remove(panel);
            }
            String[] columnNames = { "公交车号", "始发站", "终点站", "途经" };
            String[][] values = new String[b.size()][5];
            for (int i = 0; i < b.size(); i++) {
                Bus bus = (Bus) b.get(i);
                values[i][0] = String.valueOf(bus.getBusNum());
                values[i][1] = bus.getStartStation();
                values[i][2] = bus.getEndStation();
                values[i][3] = bus.getPassStation();
            }
            table = new JTable(values, columnNames);
            panel = new JScrollPane(table);
            panel.setSize(1000, 440);
            panel.setLocation(0, 130);
            this.add(panel);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        if(bt.getText().equals("站点查询")) {
            BusDAO dao = new BusDAO();
            ArrayList list = dao.findByBusStation(t2.getText().trim());
            initTable(list);
        } else if(bt.getText().equals("车号查询")) {
            BusDAO dao = new BusDAO();
            ArrayList list = new ArrayList();
            Bus bus = dao.findBusNum(Integer.parseInt(t1.getText().trim()));
            if(bus != null) {
                list.add(bus);
            }
            initTable(list);
        } else if(bt.getText().equals("删除")) {
           if(table.getSelectedRow() == -1) {
               JOptionPane.showMessageDialog(this, "请选中要删除的车次");
           } else {
               BusDAO dao = new BusDAO();
               dao.delBus(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()));
               ArrayList list = dao.findByBusStation("");
               initTable(list);
           }
        } else if(bt.getText().equals("修改")) {
            if(table.getSelectedRow()==-1) {
                JOptionPane.showMessageDialog(this, "请选中要修改的学生");
            } else {
                int row = table.getSelectedRow();
                int bno = Integer.parseInt(table.getValueAt(row, 0).toString());
                String start = table.getValueAt(row, 1).toString();
                String end = table.getValueAt(row, 2).toString();
                String pass = table.getValueAt(row, 3).toString();
                Bus bus = new Bus(bno, start, end, pass);
                AddOrUpdateFrame newFrame = new AddOrUpdateFrame("修改", bus, this);
            }
        } else {
            AddOrUpdateFrame newFrame=new AddOrUpdateFrame("增加",null,this);
        }
    }
}



