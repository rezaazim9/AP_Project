package View;

import Controller.*;
import Model.Circle;
import Model.Square;
import Model.Triangle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameFrame{
    public static JFrame gameFrame = new JFrame();
    public static ArrayList<Circle> bullets = new ArrayList<>();
    public static ArrayList<Square> squares = new ArrayList<>();
    public static ArrayList<Triangle> triangles = new ArrayList<>();

    public static ImagePanel panel;
   public static JLabel information=new JLabel();

    public void mainFrame() throws IOException {
        gameFrame.setSize(700, 700);
        panel = new ImagePanel("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\View\\g21qf4sq86s51.png",gameFrame.getWidth(),gameFrame.getHeight());
       panel.setLayout(null);
        gameFrame.setResizable(false);
        gameFrame.setUndecorated(true);
        gameFrame.setVisible(true);
        gameFrame.setLocation(400, 50);
        information();
        gameFrame.add(panel);
        gameFrame.setState(Frame.NORMAL);
        new Controller.GameTimer().gameTimer();
    }
    public static void information(){
        information.setForeground(Color.YELLOW);
        information.setText("yoooo");
        information.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        information.setBounds(310,700-information.getFont().getSize()-15,100,information.getFont().getSize());
        information.setVisible(false);
        panel.add(information);
    }

}
