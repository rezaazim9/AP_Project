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
    private final Image backgroundImage;
    private final String image;
    public static Circle ball = new Circle(340, 340, 25, 0, Color.RED);
    public static boolean paint=false;


    public ImagePanel(String fileName, int width, int height) throws IOException {
        image = fileName;
        backgroundImage = ImageIO.read(new File(fileName));
        this.height = height;
        this.width = width;
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

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public String getImage() {
        return image;
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
        bullets.clear();
        triangles.clear();
        squares.clear();
    }
    public static void paintGameFrame(){
        paint=true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, getX2(), getY2(), width, height, this);
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