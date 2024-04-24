package Controller;

import Model.Circle;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import static Controller.ImagePanel.ball;
import static View.GameFrame.*;


public class Resize implements ActionListener, MouseListener {
    static Timer timer;

    public void resizeFrame() {
        gameFrame.addMouseListener(this);
        timer = new Timer(15, this);
        timer.start();
    }

    int reSize = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        GameFrame.gameFrame.setBounds(GameFrame.gameFrame.getX() + reSize, GameFrame.gameFrame.getY() + reSize, GameFrame.gameFrame.getWidth() - reSize * 2, GameFrame.gameFrame.getHeight() - reSize * 2);
        panel.setX(panel.getX2() - reSize);
        panel.setY(panel.getY2() - reSize);
        ball.setX(ball.getX() - reSize);
        ball.setY(ball.getY() - reSize);
        ball.paint(panel.getGraphics());
        if (GameFrame.gameFrame.getWidth() <= 200) {
            reSize = 0;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {


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
