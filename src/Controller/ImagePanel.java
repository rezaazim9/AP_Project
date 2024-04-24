package Controller;

import Model.Circle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private final int width;
    private final int height;
    private final Image backgroundImage;
    private final String image;
    public static Circle ball = new Circle(340, 340, 25);


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

    public String getImage() {
        return image;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, getX2(), getY2(), width, height, this);
        ball.paint(g);
    }

}