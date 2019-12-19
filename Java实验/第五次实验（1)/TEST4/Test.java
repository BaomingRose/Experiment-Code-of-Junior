package TEST4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setLocation(300, 150);

        JPanel pl1 = new JPanel();
        pl1.setLayout(new BorderLayout());
        JButton bt1 = new JButton("button1");
        bt1.addMouseListener(new MyMouseListener());
        pl1.add(bt1, BorderLayout.NORTH);
        JButton bt2 = new JButton(("button2"));
        bt2.addMouseListener(new MyMouseListener());
        pl1.add(bt2, BorderLayout.CENTER);
        JButton bt3 = new JButton("button3");
        bt3.addMouseListener(new MyMouseListener());
        pl1.add(bt3, BorderLayout.SOUTH);

        frame.add(pl1, BorderLayout.NORTH);

        JPanel pl2 = new JPanel();
        pl2.setLayout(new BorderLayout());
        JButton bt4 = new JButton("button4");
        bt4.addMouseListener(new MyMouseListener());
        pl2.add(bt4, BorderLayout.NORTH);
        JButton bt5 = new JButton(("button5"));
        bt5.addMouseListener(new MyMouseListener());
        pl2.add(bt5, BorderLayout.CENTER);
        JButton bt6 = new JButton("button6");
        bt6.addMouseListener(new MyMouseListener());
        pl2.add(bt6, BorderLayout.SOUTH);

        frame.add(pl2, BorderLayout.SOUTH);
        frame.setVisible(true);
        pl1.setVisible(true);
        pl2.setVisible(true);
    }
}

class MyMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == e.BUTTON1 && e.getClickCount() == 1) {
            System.out.println("按钮被单击");
        }
    }
}
