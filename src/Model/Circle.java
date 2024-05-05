package Model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle {
    private double x;
    private double y;
    private int radius;
    private Color color;
    private double xSpeed;
    private double ySpeed;
    private int id;
    private Shape shape;

    public Circle(double x,double y, int radius,int id,Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.id = id;
        this.radius = radius;
        shape=new Ellipse2D.Double(getX(),getY(),getRadius(),getRadius());
    }
    public void setShape(Shape shape){
        this.shape=shape;
    }
    public Shape getShape(){
        return shape;
    }

    public double getX() {
        return x;

    }

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int) getX(),(int) getY(), getRadius(), getRadius());
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
    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
