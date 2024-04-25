package Model;

import java.awt.*;

public class Circle {
    private double x;
    private double y;
    private int radius;
    private Color color=Color.RED;
    private int id;

    public Circle(double x,double y, int radius,int id) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;

    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int )getX(),(int) getY(), getRadius(), getRadius());
    }

    public void setX(double x) {
        this.x = x;

    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void remove() {
        setColor(new Color(0,0,0,0));
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
