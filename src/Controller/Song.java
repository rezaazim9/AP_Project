package Controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Song {
    public static Clip clip;

    public static void song() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("C:\\Users\\ostad\\IdeaProjects\\AP_phase1\\src\\mainSong.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        FloatControl gainControl = (FloatControl) Song.clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-8);
        clip.start();
    }
}
