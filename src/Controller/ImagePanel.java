package Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private final int width;
    private final int height;
    private final Image backgroundImage;

    public ImagePanel(String fileName, int width, int height) throws IOException {
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

    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, getX2(), getY2(), width, height, this);
    }
}