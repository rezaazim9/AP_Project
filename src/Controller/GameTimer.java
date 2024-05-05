package Controller;

import Model.Circle;
import Model.Square;
import Model.Triangle;
import View.Menu;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

import static Controller.ImagePanel.*;
import static View.GameFrame.*;
import static java.awt.event.KeyEvent.*;

public class GameTimer implements ActionListener, MouseListener, KeyListener {
    private static final Set<Integer> pressedKeys = new HashSet<>();
    Integer info = 0;

    static Timer timer;
    int reSize = 1;

    public void gameTimer() {
        gameFrame.addMouseListener(this);
        gameFrame.addKeyListener(this);
        ball.setX(340);
        ball.setY(340);
        panel.setY(0);
        panel.setX(0);
        information.setLocation(270, 700 - information.getFont().getSize() - 15);
        triangles.add(new Triangle(450, 450, 30, Color.YELLOW, 0, 0, 15, 0, 5));
        squares.add(new Square(400, 400, 35, Color.GREEN, 0, 0, 10, 0, 5));
        timer = new Timer(15, this);
        timer.start();
    }

    int ballY = 0;
    int ballX = 0;
    double infoCounter = 0;
    boolean infoBoolean = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Triangle triangle : triangles) {
            for (Circle bullet : bullets) {
                if (bullet.getShape().getBounds2D().intersects(triangle.getShape().getBounds2D())) {
                    triangle.setHp(triangle.getHp() - 5);
                    bullets.remove(bullet);
                    break;
                }
            }
        } for (Square square:squares) {
            for (Circle bullet : bullets) {
                if (square.getShape().getBounds2D().intersects(bullet.getShape().getBounds2D())) {
                    square.setHp(square.getHp() - 5);
                    bullets.remove(bullet);
                    break;
                }
            }
        }
        gameFrame.setBounds(gameFrame.getX() + reSize, gameFrame.getY() + reSize, gameFrame.getWidth() - reSize * 2, gameFrame.getHeight() - reSize * 2);
        panel.setX(panel.getX2() - reSize);
        panel.setY(panel.getY2() - reSize);
        information.setLocation(information.getX() - reSize, information.getY() - 2 * reSize);
        movement();
        if (info == VK_Q) {
            infoBoolean = true;
        }
        if (info == VK_E) {
            gameFrame.dispose();
            ImagePanel.clearGameFrame();
            Menu.menuFrame.setVisible(true);
            timer.stop();
        }
        if (infoBoolean) {
            infoCounter += 15;
            information.setVisible(true);
        }
        if (infoCounter > 2000) {
            information.setVisible(false);
            infoCounter = 0;
            infoBoolean = false;
        }
        ball.setX(ball.getX() - reSize + ballX);
        ball.setY(ball.getY() - reSize - ballY);
        if ((ball.getY() < panel.getY() || ball.getY() + ball.getRadius() > panel.getY() + panel.getHeight())) {
            ball.setY(ball.getY() + reSize + ballY);
        }
        for (Circle bullet : bullets) {
            bullet.setShape(new Ellipse2D.Double(bullet.getX(), bullet.getY(), bullet.getRadius(), bullet.getRadius()));

            bullet.setX(bullet.getX() + bullet.getxSpeed());
            bullet.setY(bullet.getY() + bullet.getySpeed());

        }
        for (Triangle triangle : triangles) {
            int[] xVertices = {(int) (triangle.getX() - triangle.getSize() * Math.sqrt(3) / 2), (int) (triangle.getX() + triangle.getSize() * Math.sqrt(3) / 2), (int) triangle.getX()};
            int[] yVertices = {(int) triangle.getY() + triangle.getSize() / 2, (int) triangle.getY() + triangle.getSize() / 2, (int) triangle.getY() - triangle.getSize()};
            triangle.setShape(new Polygon(xVertices,yVertices,3));
            if (triangle.getHp() <= 0) {
                triangles.remove(triangle);
                break;
            }
        }
        for (Square square : squares) {
            square.setShape(new Rectangle((int)square.getX(), (int)square.getY(), square.getSize(), square.getSize()));
            if (square.getHp() <= 0) {
                squares.remove(square);
                break;
            }
        }
        if ((ball.getX() + ball.getRadius() > panel.getX() + panel.getWidth() || ball.getX() < panel.getX())) {
            ball.setX(ball.getX() + reSize - ballX);
        }

        if (gameFrame.getWidth() <= 600) {
            reSize = 0;
        }

        ball.setShape(new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius()));
        panel.validate();
        panel.repaint();
    }

    private void movement() {
        if (pressedKeys.contains(VK_W)) {
            ballY = 2;
        }
        if (pressedKeys.contains(VK_S)) {
            ballY = -2;
        }
        if (!(pressedKeys.contains(VK_S) || pressedKeys.contains(VK_W)) || (pressedKeys.contains(VK_S) && pressedKeys.contains(VK_W))) {
            ballY = 0;
        }
        if (pressedKeys.contains(VK_D)) {
            ballX = 2;
        }
        if (pressedKeys.contains(VK_A)) {
            ballX = -2;
        }
        if (!(pressedKeys.contains(VK_A) || pressedKeys.contains(VK_D)) || (pressedKeys.contains(VK_A) && pressedKeys.contains(VK_D))) {
            ballX = 0;
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

        Circle bullet = new Circle(ball.getX() + 8, ball.getY() + 8, 10, counter, Color.GREEN);
        bullet.setxSpeed(7 * (-ball.getX() - 8 + xMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
        bullet.setySpeed(7 * (-ball.getY() - 8 + yMouse) / Math.sqrt(Math.pow(ball.getX() - xMouse, 2) + Math.pow(ball.getY() - yMouse, 2)));
        bullets.add(bullet);
        counter++;

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
        info = e.getKeyCode();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
        info = 0;
    }
}
