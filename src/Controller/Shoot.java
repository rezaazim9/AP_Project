package Controller;

import Model.Circle;

import java.awt.*;
import java.util.ArrayList;

public class Shoot extends Circle {
    public static ArrayList<Shoot> bullets = new ArrayList<>();

    public Shoot(int x, int y, int radius ,final double xSpeed,final double ySpeed) {
        super(x, y, radius);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public  Shoot bulletMaker() {
        Shoot bullet = new Shoot(ImagePanel.ball.getX(), ImagePanel.ball.getY(), 10,0,0);
        bullet.setX(ImagePanel.ball.getX()+8);
        bullet.setY(ImagePanel.ball.getY()+8);
        bullets.add(bullet);
        return bullet;
    }

    private int x;
    private int y;
    private double xSpeed;
    private double ySpeed;


    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(getX(), getY(), 10, 10);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
