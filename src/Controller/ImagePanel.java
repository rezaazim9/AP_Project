package Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel
{
    private final int width;
    private final int height;
    private final Image backgroundImage;
    public ImagePanel(String fileName,int width,int height) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
        this.height=height;
        this.width=width;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0,width,height, this);
    }
}