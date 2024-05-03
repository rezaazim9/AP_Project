package View;

import Controller.ImagePanel;
import Controller.Song;
import com.sun.tools.javac.Main;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SettingsFrame implements ActionListener {
    public JFrame settingsFrame = new JFrame();
    public ImagePanel settingsPanel;
    public JButton backButton = new JButton("Back");
    public static JSlider songSlider = new JSlider();
    public JLabel songLabel = new JLabel("Song Volume");

    public void settingsFrame() throws IOException {
        settingsFrame.setSize(600, 400);
        settingsPanel = new ImagePanel( "C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\Model\\img0.jpg",settingsFrame.getWidth(), settingsFrame.getHeight());
        songLabel.setBounds(50,125,200,35);
        songLabel.setForeground(Color.YELLOW);
        songLabel.setFont(new Font("Times New Roman", Font.BOLD, 30 ));
        songLabel.setBackground(new Color(0,0,0,0));
        songSlider.setBounds(350, 125, 200, 30);
        songSlider.setBackground(Color.BLACK);
        songSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                FloatControl gainControl = (FloatControl) Song.clip.getControl(FloatControl.Type.MASTER_GAIN);
                float currentMusicVolume = 50;

                if (e.getSource() == songSlider) {
                    currentMusicVolume = songSlider.getValue() ;

                }
                gainControl.setValue(-8+ 14*(currentMusicVolume-50)/50);
            }
        });
        settingsFrame.setState(Frame.NORMAL);
        settingsPanel.clearGameFrame();
        backButton.addActionListener(this);
        backButton.setBounds(0, 0, 100, 40);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        backButton.setBackground(Color.CYAN);
        backButton.setFocusable(false);
        settingsPanel.add(backButton);
        settingsPanel.add(songLabel);
        settingsPanel.add(songSlider);
        settingsFrame.add(settingsPanel);
        settingsPanel.setLayout(null);
        settingsFrame.setUndecorated(true);
        settingsFrame.setBackground(Color.BLACK);

        settingsFrame.setLocation(450, 150);
        settingsFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            settingsFrame.dispose();
           Menu.menuFrame.setVisible(true);
        }
    }
}
