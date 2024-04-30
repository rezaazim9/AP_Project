package View;

import Controller.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SettingsFrame implements ActionListener {
    public  JFrame settingsFrame=new JFrame();
        public  ImagePanel settingsPanel;
    public  JButton backButton=new JButton("Back");
    public void settingsFrame()  throws IOException  {
        settingsFrame.setSize(600, 400);
        settingsPanel = new ImagePanel("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\View\\g21qf4sq86s51.png",settingsFrame.getWidth(),settingsFrame.getHeight());;
       settingsFrame.setResizable(false);
       settingsFrame.setState(Frame.NORMAL);
       settingsPanel.clearGameFrame();
       backButton.addActionListener(this);
        backButton.setBounds(0,0,100,40);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        backButton.setBackground(Color.CYAN);
        backButton.setFocusable(false);
        settingsPanel.add(backButton);
        settingsFrame.add(settingsPanel);
        settingsPanel.setLayout(null);
        settingsFrame.setUndecorated(true);
        settingsFrame.setLocation(450, 150);
        settingsFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton) {
            settingsFrame.dispose();
            try {
                new Menu().menu();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
