package Controller;

import Model.Circle;

import java.awt.*;
import java.util.ArrayList;


public class Shoot extends Circle {
    public static ArrayList<Shoot> bullets = new ArrayList<>();

    public Shoot(double x, double y, int radius ,int id,final double xSpeed,final double ySpeed) {
        super(x, y, radius,id);
        this.setX(x);
        this.setY(y);
        this.setRadius(radius);
        this.setId(id);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }



    private double x;
    private double  y;
    private double xSpeed;
    private double ySpeed;
    private Color color=Color.GREEN;

    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int) getX(),(int) getY(), 10, 10);
    }

    public double getX() {
        return x;
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

}
