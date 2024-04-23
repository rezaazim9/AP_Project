package Controller;

import View.*;
import View.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MenuActions {
    public  void exit() {
        System.exit(0);
    }

    public  void settings() {

    }

    public void start() throws IOException, AWTException {
        Menu.menuFrame.setVisible(false);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        new GameFrame().mainFrame();
    }

    public void tutorial() {

    }

    public void skillTree() {

    }
}
