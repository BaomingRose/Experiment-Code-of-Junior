package TEST3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Copy extends JFrame {
    JLabel lb = new JLabel();
    JTextField tf = new JTextField();
    JButton bt = new JButton("Copy");

    public Copy() {
        this.setTitle("拷贝到标签");
        this.setLayout(null);
        this.setSize(500, 300);
        this.setLocation(300, 150);

        lb.setSize(400, 40);
        lb.setLocation(30, 20);
        tf.setSize(400, 40);
        tf.setLocation(30, 70);
        bt.setSize(70, 30);
        bt.setLocation(210, 180);

        this.add(lb);
        this.add(tf);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tf.getText();
                lb.setText(s);
            }
        });
        this.add(bt);
        this.setVisible(true);
    }
}

public class Test {
    public static void main(String[] args) {
        Copy copy = new Copy();
    }
}
