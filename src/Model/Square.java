package Model;

import java.awt.*;

public class Square {
    private double x;
    private double y;
    private int size;
    private Color color;
    private double xSpeed;
    private double ySpeed;
    private int hp;
    private int thick;
    private double rotationSpeed;
    private Shape shape;
    public Square(double x, double y, int size, Color color, double xSpeed, double ySpeed, int hp,double rotationSpeed,int thick) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.hp = hp;
        this.rotationSpeed = rotationSpeed;
        this.thick = thick;
        this.shape=new Rectangle((int)getX(), (int)getY(), getSize(), getSize());
    }
    public void setShape(Shape shape){
        this.shape=shape;
    }
    public Shape getShape(){
        return shape;
    }
    public  int getThick(){
        return thick;
    }
    public void setThick(int thick) {
        this.thick = thick;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getSize() {
        return size;

    }

    public Color getColor() {
        return color;
    }
    public double getXSpeed() {
        return xSpeed;
    }
    public double getYSpeed() {
        return ySpeed;
    }
    public int getHp() {
        return hp;

    }
    public double getRotationSpeed() {
        return rotationSpeed;

    }
    public void setX(double x) {
        this.x = x;

    }
    public void setY(double y) {

        this.y = y;

    }
    public void setSize(int size) {
        this.size = size;

    }
    public void setColor(Color color) {
        this.color = color;

    }
    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;

    }
    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;

    }
    public void setHp(int hp) {
        this.hp = hp;

    }
    public void setRotationSpeed(double rotationSpeed) {
        this.rotationSpeed = rotationSpeed;


    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thick));
        g2d.drawRect((int)getX(), (int)getY(), size, size);
    }
}
