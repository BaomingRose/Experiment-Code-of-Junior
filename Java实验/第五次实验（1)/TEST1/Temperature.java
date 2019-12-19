package TEST1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature extends JFrame {
    JButton btn1 = new JButton("摄氏");
    JButton btn2 = new JButton("华氏");
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();

    public Temperature() {
        //设置标题
        this.setTitle("Temperature");
        //不使用布局
        this.setLayout(null);
        this.setSize(500, 300);
        this.setLocation(300, 150);

        btn1.setBounds(300, 60, 100, 30);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conent = tf2.getText();
                //F= C* 9/5 + 32
                //C=(F-32)*5/9
                double F = Double.valueOf(conent);
                Double C = (F - 32) * 5 / 9;
                tf1.setText(String.valueOf(C));
            }
        });
        this.add(btn1);
        btn2.setBounds(300, 120, 100, 30);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conent = tf1.getText();
                double C = Double.valueOf(conent);
                tf1.setText(String.valueOf(C));
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String conent = tf1.getText();
                double C = Double.valueOf(conent);
                double F= C * 9 / 5 + 32;
                tf2.setText(String.valueOf(F));
            }
        });
        this.add(btn2);

        tf1.setBounds(30, 60, 250, 30);
        this.add(tf1);
        tf2.setBounds(30, 120, 250, 30);
        this.add(tf2);
        this.setVisible(true);
    }
}
