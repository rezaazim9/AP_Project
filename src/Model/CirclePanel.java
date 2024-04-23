package Model;

import java.awt.*;
import javax.swing.*;

public class CirclePanel extends JPanel {
    private int x=0;
    private  int y=0;
    int d = 25;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(getX2()+getWidth()/2-d/2, getY2()+getWidth()/2 - d/2, d, d);
    }

    @Override
    public Dimension getPreferredSize() {
        setBackground(new Color(0,0,0,0));
        return new Dimension(700, 700);
    }
    public int getX2() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY2() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
