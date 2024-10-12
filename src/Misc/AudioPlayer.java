package src.Misc;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class AudioPlayer{

    private final String path;
    private Clip clip;
    private AudioInputStream stream;

    public AudioPlayer(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.path = path;
        File audioFile = new File(this.path).getAbsoluteFile();
        this.stream = AudioSystem.getAudioInputStream(audioFile);
        this.clip = AudioSystem.getClip();
        this.clip.open(this.stream);
        this.clip.start();
    }

    public void stop(){
        this.clip.stop();
    }

    public void loop(){
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


}
