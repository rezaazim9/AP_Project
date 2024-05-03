package Controller;

import View.*;
import View.Menu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public  class MenuActions {
    public  void exit() {
        System.exit(0);
    }

    public  void settings() throws IOException {
        ImagePanel.clearGameFrame();
       Menu.menuFrame.dispose();
        new SettingsFrame().settingsFrame();
    }

    public void start() throws IOException, AWTException {
        ImagePanel.paintGameFrame();
         Menu.menuFrame.dispose();
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
