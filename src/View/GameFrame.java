package View;

import Controller.*;
import Model.*;

import javax.sound.midi.ControllerEventListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;import javax.swing.GroupLayout.Group;


import java.io.IOException;


public class GameFrame {
    public  static JFrame gameFrame=new JFrame();
    public static ImagePanel panel;
   public static CirclePanel circle=new CirclePanel();
    public void mainFrame() throws IOException {
        gameFrame.setSize(700,700);
        panel= new ImagePanel("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\View\\g21qf4sq86s51.png", gameFrame.getWidth(), gameFrame.getHeight());
        gameFrame.setResizable(false);
        gameFrame.setUndecorated(true);
        gameFrame.setVisible(true);
        System.out.println();
        panel.add(circle);
        gameFrame.setLocation(400,50);
        gameFrame.add(panel);
        gameFrame.setState(Frame.NORMAL);
        new Controller.Resize().resizeFrame();
    }
}
