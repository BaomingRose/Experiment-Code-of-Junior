package TEST2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LocationMouse extends JFrame implements MouseListener{
    public LocationMouse() {
        this.setTitle("MouseOfLocation");
        this.setSize(800, 500);
        this.setLocation(300, 150);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        this.setTitle("当前坐标：" + p.x + "," + p.y);
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
