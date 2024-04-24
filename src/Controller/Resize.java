package Controller;

import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import static Controller.ImagePanel.ball;
import static Controller.Shoot.bullets;
import static View.GameFrame.*;

public class Resize implements ActionListener, MouseListener {
    static Timer timer;
    int reSize = 1;

    public void resizeFrame() {
        gameFrame.addMouseListener(this);
        timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameFrame.gameFrame.setBounds(GameFrame.gameFrame.getX() + reSize, GameFrame.gameFrame.getY() + reSize, GameFrame.gameFrame.getWidth() - reSize * 2, GameFrame.gameFrame.getHeight() - reSize * 2);
        panel.setX(panel.getX2() - reSize);
        panel.setY(panel.getY2() - reSize);
        ball.setX(ball.getX() - reSize);
        ball.setY(ball.getY() - reSize);
        for (Shoot bullet : bullets) {
            ball.paint(panel.getGraphics());
            bullet.setX(bullet.getX() + (int) (bullet.getxSpeed()));
            bullet.setY(bullet.getY() + (int) bullet.getySpeed());
            bullet.paint(panel.getGraphics());
        }
        if (GameFrame.gameFrame.getWidth() <= 500) {
            reSize = 0;
        }
    }

    int xMouse;
    int yMouse;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        yMouse = e.getY();
        xMouse = e.getX();
        if (reSize == 0) {
            Shoot bullet = new Shoot(ImagePanel.ball.getX(), ImagePanel.ball.getY(), 10,0,0).bulletMaker();
            bullet.setxSpeed(10 * (-ball.getX() + xMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
            bullet.setySpeed(10 * (-ball.getY() + yMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
