package TEST6;
/*可视化窗体最后调用*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Corlor extends JFrame {
    JPanel p1 = new JPanel();       //放置背景颜色
    JPanel pButton = new JPanel();  //放置按钮

    public Corlor() {
        this.setLayout(new BorderLayout());
        this.setSize(500, 300);
        this.setLocation(300, 150);

        p1.setBackground(Color.RED);

        JButton bt1 = new JButton("Red");
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setBackground(Color.RED);
            }
        });
        JButton bt2 = new JButton("Green");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setBackground(Color.GREEN);
            }
        });
        JButton bt3 = new JButton("Blue");
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setBackground(Color.BLUE);
            }
        });
        JButton bt4 = new JButton("Gray");
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setBackground(Color.GRAY);
            }
        });
        pButton.setLayout(new FlowLayout());
        pButton.add(bt1);
        pButton.add(bt2);
        pButton.add(bt3);
        pButton.add(bt4);

        this.add(p1, BorderLayout.CENTER);
        this.add(pButton, BorderLayout.SOUTH);
        this.setVisible(true);
        p1.setVisible(true);
        pButton.setVisible(true);
    }
}
