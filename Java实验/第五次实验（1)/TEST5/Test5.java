package TEST5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 {
    public static void main(String[] args) {
        Graph graph = new Graph();
    }
}

class Graph extends JFrame {
    public Graph() {
        this.setSize(300, 300);
        this.setLocation(300, 150);
        this.setLayout(new FlowLayout());

        for (int i = 1; i <= 6; i++) {
            JButton bt = new JButton("button" + i);
            this.add(bt);
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Window window = (Window)e.getComponent();
                window.dispose();
                return ;
            }
        });
        this.setVisible(true);
    }
}
