import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrUpdateFrame extends JFrame implements ActionListener {
    JLabel numLa, startLa, endLa, passLa;
    JTextField numTxt, startTxt, endTxt;
    JTextArea passTxt;
    JButton bt;
    BusStation main;//定义主窗口

    public AddOrUpdateFrame(String type, Bus bus, BusStation main) {
        this.setSize(300,400);
        this.setLocation(300, 150);
        this.setLayout(null);
        numLa=new JLabel("公交车号");
        numLa.setSize(60, 30);
        numLa.setLocation(30, 30);
        this.add(numLa);
        numTxt=new JTextField();
        numTxt.setSize(120, 30);
        numTxt.setLocation(100, 30);
        this.add(numTxt);
        startLa = new JLabel("始发站");
        startLa.setSize(60, 30);
        startLa.setLocation(30, 80);
        this.add(startLa);
        startTxt = new JTextField();
        startTxt.setSize(120, 30);
        startTxt.setLocation(100, 80);
        this.add(startTxt);
        endLa = new JLabel("终点站");
        endLa.setSize(60, 30);
        endLa.setLocation(30, 130);
        this.add(endLa);
        endTxt = new JTextField();
        endTxt.setSize(120, 30);
        endTxt.setLocation(100, 130);
        this.add(endTxt);
        /*
        sexCom=new JComboBox();
        sexCom.setSize(120, 30);
        sexCom.setLocation(100, 130);
        sexCom.addItem("男");
        sexCom.addItem("女");
        this.add(sexCom);
        */
        passLa=new JLabel("途经");
        passLa.setSize(60, 30);
        passLa.setLocation(30, 180);
        this.add(passLa);
        passTxt = new JTextArea(3, 1);
        passTxt.setLocation(20, 210);
        passTxt.setSize(250, 100);
        //ageTxt.setSize(120, 30);
        this.add(passTxt);

        if(type.equals("增加")) {
            this.setTitle("增加");
            bt = new JButton("增加");
            bt.setSize(60, 30);
            bt.setLocation(100,320);
        } else {
            this.setTitle("修改");
            bt = new JButton("修改");
            bt.setSize(60, 30);
            bt.setLocation(100,320);
            if(bus != null) {
                numTxt.setText(String.valueOf(bus.getBusNum()));
                numTxt.setEditable(false);
                startTxt.setText(bus.getStartStation());
                endTxt.setText(bus.getEndStation());
                passTxt.setText(bus.getPassStation());
            }
        }
        this.add(bt);
        bt.addActionListener(this);
        this.setVisible(true);
        this.main = main;
    }

    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        BusDAO dao = new BusDAO();
        int bno = Integer.parseInt(numTxt.getText().trim());
        String start = startTxt.getText().trim();
        String end = endTxt.getText().trim();
        String pass = passTxt.getText().trim();
        Bus bus = new Bus(bno, start, end, pass);
        if(bt.getText().equals("修改")) {
            dao.updateBus(bus);
        }
        else {
            dao.addBus(bus);
        }
        ArrayList list=dao.findByBusStation("");
        main.initTable(list);
        this.dispose();
    }
}
