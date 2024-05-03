package Controller;

import View.*;
import View.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static View.Menu.menuFrame;

public  class MenuActions {
    public  void exit() {
        System.exit(0);
    }

    public  void settings() throws IOException {
        ImagePanel.clearGameFrame();
        menuFrame.setVisible(false);
        new SettingsFrame().settingsFrame();
    }

    public void start() throws IOException, AWTException {
        ImagePanel.paintGameFrame();
        menuFrame.setVisible(false);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_D);
        new GameFrame().mainFrame();
    }

    public void tutorial() {

    }

    public void skillTree() {

    }
}
