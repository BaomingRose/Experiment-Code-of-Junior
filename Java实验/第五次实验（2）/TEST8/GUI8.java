package TEST8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI8 extends JFrame {
    JPanel pl = new JPanel();
    JTextArea ta = new JTextArea(3, 10);

    public GUI8() {
        this.setLayout(new BorderLayout());
        this.setSize(500, 250);
        this.setLocation(300, 150);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        JLabel lb1 = new JLabel("姓名：");
        JLabel lb2 = new JLabel("性别：");
        JLabel lb3 = new JLabel("年龄：");
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();

        pl.setLayout(null);
        lb1.setLocation(40, 5);
        lb1.setSize(50, 20);
        lb2.setLocation(40, 35);
        lb2.setSize(50, 20);
        lb3.setLocation(40, 65);
        lb3.setSize(50, 20);
        tf1.setLocation(100, 5);
        tf1.setSize(300, 20);
        tf2.setLocation(100, 35);
        tf2.setSize(300, 20);
        tf3.setLocation(100, 65);
        tf3.setSize(300, 20);
        pl.add(lb1);
        pl.add(lb2);
        pl.add(lb3);
        pl.add(tf1);
        pl.add(tf2);
        pl.add(tf3);

        JButton bt1 = new JButton("OK");
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = tf1.getText() + "\n" + tf2.getText() + "\n" + tf3.getText();
                ta.setText(res);
            }
        });
        JButton bt2 = new JButton("Clear");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(null);
                tf2.setText(null);
                tf3.setText(null);
                ta.setText(null);
            }
        });
        bt1.setSize(80, 20);
        bt1.setLocation(160, 100);
        bt2.setSize(80, 20);
        bt2.setLocation(270, 100);
        pl.add(bt1);
        pl.add(bt2);

        ta.setEditable(false);
        JScrollPane sp = new JScrollPane(ta);

        this.add(sp, BorderLayout.SOUTH);
        this.add(pl, BorderLayout.CENTER);
        this.setVisible(true);
        pl.setVisible(true);
        sp.setVisible(true);
    }

}
