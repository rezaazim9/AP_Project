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
    public static int time = 0;
    public static int wave=0;
    public static int xp=0;
    public static int hp=0;
    public static ImagePanel panel;


    public static JLabel information=new JLabel();
static int c=0;
    public void mainFrame() throws IOException {
        gameFrame.setSize(700, 700);
        panel = new ImagePanel("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\Model\\4Ti0+G.png",700,700);
        panel.revalidate();
        panel.setLayout(null);
       panel.paintGameFrame();
       information();
        gameFrame.setResizable(false);
        gameFrame.add(panel);
        gameFrame.setBackground(Color.BLACK);
        gameFrame.setUndecorated(true);
        gameFrame.setLocation(400, 50);
        gameFrame.setState(Frame.NORMAL);
        gameFrame.setVisible(true);
        triangles.add(new Triangle(450, 450, 25, Color.YELLOW, 0, 0, 0, 0, 5));
        new Controller.GameTimer().gameTimer();
    }
    public static void information(){
        information.setForeground(Color.YELLOW);
        information.setText("Wave:"+wave+" Time:"+time+" XP:"+xp+" HP:"+hp);
        information.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        information.setBounds(270,700-information.getFont().getSize()-15,180,information.getFont().getSize());
        information.setVisible(false);
        panel.add(information);
    }

}
