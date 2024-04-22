package View;

import Controller.ImagePanel;
import Controller.MenuActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JPanel implements ActionListener {
    public JFrame menuFrame = new JFrame();
    JButton exit = new JButton();
    JButton tutorial = new JButton();
    JButton start = new JButton();
    JButton skillTree = new JButton();
    JButton settings = new JButton();

    public void menu() throws IOException {
        menuFrame.setSize(550, 550);
        ImagePanel imagePanel = new ImagePanel("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\View\\g21qf4sq86s51.png", menuFrame.getWidth(), menuFrame.getHeight());
        menuFrame.setLocation(500, 100);
        menuButtons();
        menuFrame.setUndecorated(true);
        menuFrame.setResizable(false);
        menuFrame.add(imagePanel);
        menuFrame.setVisible(true);
    }

    public void menuButtons() {
        exit.setBounds(0, 0, 80, 40);
        exit.addActionListener(this);
        exit.setBackground(Color.BLUE);
        exit.setText("Exit");
        exit.setFocusable(false);
        exit.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        settings.setBounds(60, 150, 180, 90);
        settings.addActionListener(this);
        settings.setBackground(Color.BLUE);
        settings.setText("Settings");
        settings.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        settings.setFocusable(false);
        skillTree.setBounds(300, 50, 180, 90);
        skillTree.addActionListener(this);
        skillTree.setBackground(Color.BLUE);
        skillTree.setText("Skill Tree");
        skillTree.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        skillTree.setFocusable(false);
        tutorial.setBounds(260, 300, 180, 90);
        tutorial.addActionListener(this);
        tutorial.setBackground(Color.BLUE);
        tutorial.setText("Tutorial");
        tutorial.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        tutorial.setFocusable(false);
        start.setBounds(80, 440, 180, 90);
        start.addActionListener(this);
        start.setBackground(Color.RED);
        start.setText("Start");
        start.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        start.setFocusable(false);
        menuFrame.add(exit);
        menuFrame.add(settings);
        menuFrame.add(start);
        menuFrame.add(skillTree);
        menuFrame.add(tutorial);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)) {
            MenuActions.exit();
        }
        if (e.getSource().equals(settings)) {
            MenuActions.settings();
        }
        if (e.getSource().equals(start)) {
            MenuActions.start();
        }
        if (e.getSource().equals(skillTree)) {
            MenuActions.skillTree();
        }
        if (e.getSource().equals(tutorial)) {
            MenuActions.tutorial();
        }
    }
}
