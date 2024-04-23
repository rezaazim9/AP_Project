package Controller;

import View.GameFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Resize implements ActionListener {
    static Timer timer;

    public void resizeFrame() {
        timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
GameFrame.panel.setX(GameFrame.panel.getX2()-1);
GameFrame.panel.setY(GameFrame.panel.getY2()-1);
GameFrame.gameFrame.setBounds(GameFrame.gameFrame.getX()+1,GameFrame.gameFrame.getY()+1,GameFrame.gameFrame.getWidth()-2,GameFrame.gameFrame.getHeight()-2);
GameFrame.gameFrame.repaint();
        if (GameFrame.gameFrame.getWidth()<=200){
            timer.stop();
        }
    }
}
