package Controller;

import Model.Circle;
import Model.Square;
import Model.Triangle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static View.GameFrame.*;

public class ImagePanel extends JPanel {
    private final int width;
    private final int height;
    public static Circle ball = new Circle(340, 340, 25, 0, Color.RED);
    public static boolean paint=false;


    public ImagePanel( int width, int height) {
        this.height = height;
        this.width = width;
        this.setBackground(Color.BLACK);
    }

    private int x;
    private int y;

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
    public void setX2(int x) {
        this.x = x;
    }
    public void setY2(int y) {
        this.y = y;
    }
    public static void clearGameFrame(){
        paint=false;
    }
    public static void paintGameFrame(){
        paint=true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (paint) {
            for (Circle bullet : bullets) {
                bullet.paint(g);
            }
            for (Square square : squares) {
                square.draw(g);
            }
            for (Triangle triangle : triangles) {
                triangle.draw(g);
            }
            ball.paint(g);
        }
    }
}