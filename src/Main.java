import Controller.Song;
import View.Menu;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        new Menu().menu();
        Song.song();
    }
}