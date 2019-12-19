package TEST7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI7 extends JFrame {
    JTextArea ta = new JTextArea();
    JPanel pl = new JPanel();

    public GUI7() {
        this.setLocation(300, 150);
        this.setSize(500, 300);

        this.add(ta, BorderLayout.CENTER);

        JButton bt1 = new JButton("OK");
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("OK");
            }
        });
        JButton bt2 = new JButton("Cancel");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("Cancel");
            }
        });
        JButton bt3 = new JButton("Exit");
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                return ;
            }
        });
        pl.setLayout(new FlowLayout());
        pl.add(bt1);
        pl.add(bt2);
        pl.add(bt3);
        this.add(pl, BorderLayout.SOUTH);

        this.setVisible(true);
        pl.setVisible(true);
    }
}
