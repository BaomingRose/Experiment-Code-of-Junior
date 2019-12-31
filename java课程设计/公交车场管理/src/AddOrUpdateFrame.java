import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrUpdateFrame extends JFrame implements ActionListener {
    JLabel numLa, nameLa, locationLa, passLa, runLa;
    JTextField numTxt, nameTxt, locationTxt, passTxt;
    //JTextArea passTxt;
    JComboBox runCom;
    JButton bt;
    MainFrame main;//定义主窗口

    public AddOrUpdateFrame(String type, BusStation bus, MainFrame main) {
        this.setSize(300,400);
        this.setLocation(300, 150);
        this.setLayout(null);
        numLa=new JLabel("车站编号");
        numLa.setSize(60, 30);
        numLa.setLocation(30, 30);
        this.add(numLa);
        numTxt=new JTextField();
        numTxt.setSize(120, 30);
        numTxt.setLocation(100, 30);
        this.add(numTxt);
        nameLa = new JLabel("车牌名");
        nameLa.setSize(60, 30);
        nameLa.setLocation(30, 80);
        this.add(nameLa);
        nameTxt = new JTextField();
        nameTxt.setSize(120, 30);
        nameTxt.setLocation(100, 80);
        this.add(nameTxt);
        locationLa = new JLabel("所在位置");
        locationLa.setSize(60, 30);
        locationLa.setLocation(30, 130);
        this.add(locationLa);
        locationTxt = new JTextField();
        locationTxt.setSize(120, 30);
        locationTxt.setLocation(100, 130);
        this.add(locationTxt);

        passLa=new JLabel("经过公交");
        passLa.setSize(60, 30);
        passLa.setLocation(30, 180);
        this.add(passLa);
        passTxt = new JTextField();
        passTxt.setLocation(100, 180);
        passTxt.setSize(120, 30);
        //ageTxt.setSize(120, 30);
        this.add(passTxt);
        runLa = new JLabel("状态");
        runLa.setSize(60, 30);
        runLa.setLocation(30, 230);
        this.add(runLa);

        runCom=new JComboBox();
        runCom.setSize(120, 30);
        runCom.setLocation(100, 230);
        runCom.addItem("运行");
        runCom.addItem("停运");
        runCom.addItem("维修");
        this.add(runCom);

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
                numTxt.setText(bus.getStNum());
                numTxt.setEditable(false);
                nameTxt.setText(bus.getStName());
                locationTxt.setText(bus.getLocation());
                passTxt.setText(bus.getPassingBusNo());
                runCom.setSelectedItem(bus.getIsRun());
            }
        }
        this.add(bt);
        bt.addActionListener(this);
        this.setVisible(true);
        this.main = main;
    }

    public void actionPerformed(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        StationDAO dao = new StationDAO();
        String bno = numTxt.getText().trim();
        String start = nameTxt.getText().trim();
        String end = locationTxt.getText().trim();
        String pass = passTxt.getText().trim();
        String run = runCom.getSelectedItem().toString().trim();
        BusStation bus = new BusStation(bno, start, end, pass, run);
        if(bt.getText().equals("修改")) {
            dao.updateBus(bus);
        } else {
            dao.addBusStation(bus);
        }
        ArrayList list = dao.findByStationName("");
        main.initTable(list);
        this.dispose();
    }
}
