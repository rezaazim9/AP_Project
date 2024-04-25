package Controller;

import View.GameFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

import static Controller.ImagePanel.ball;
import static Controller.Shoot.bullets;
import static View.GameFrame.*;
import static java.awt.event.KeyEvent.*;

public class Resize implements ActionListener, MouseListener, KeyListener {
    private static final Set<Integer> pressedKeys = new HashSet<>();

    static Timer timer;
    int reSize = 1;

    public void resizeFrame() {
        gameFrame.addMouseListener(this);
        gameFrame.addKeyListener(this);
        timer = new Timer(15, this);
        timer.start();
    }

    int ballY = 0;
    int ballX = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        GameFrame.gameFrame.setBounds(GameFrame.gameFrame.getX() + reSize, GameFrame.gameFrame.getY() + reSize, GameFrame.gameFrame.getWidth() - reSize * 2, GameFrame.gameFrame.getHeight() - reSize * 2);
        panel.setX(panel.getX2() - reSize);
        panel.setY(panel.getY2() - reSize);
        if (pressedKeys.contains(VK_W)) {
            ballY = 1;
        } else if (pressedKeys.contains(VK_S)) {
            ballY = -1;
        } else {
            ballY = 0;
        }
        if (pressedKeys.contains(VK_D)) {
            ballX = 1;
        } else if (pressedKeys.contains(VK_A)) {
            ballX = -1;
        } else {
            ballX = 0;
        }
        ball.setX(ball.getX() - reSize + ballX);
        ball.setY(ball.getY() - reSize - ballY);
        for (Shoot bullet : bullets) {
            bullet.remove();
            bullet.setX(bullet.getX() + (bullet.getxSpeed()));
            bullet.setY(bullet.getY() + bullet.getySpeed());
            bullet.setColor(Color.GREEN);
            bullet.paint(panel.getGraphics());
        }
        ball.paint(panel.getGraphics());
        if (GameFrame.gameFrame.getWidth() <= 500) {
            reSize = 0;
        }
    }

    int xMouse;
    int yMouse;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public static int counter = 1;

    @Override
    public void mousePressed(MouseEvent e) {
        yMouse = e.getY();
        xMouse = e.getX();
        if (reSize == 0) {
            Shoot bullet = new Shoot(ball.getX() + 8, ball.getY() + 8, 10, counter, 0, 0);
            bullet.setxSpeed(8 * (-ball.getX() + xMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
            bullet.setySpeed(8 * (-ball.getY() + yMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
            bullets.add(bullet);
            counter++;
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

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());

    }
}
