package project;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
 /**
 * this class is deal with music
 */
public class Music {
    AudioClip clip = null;
 
    private String filePath = "";
    
    public AudioClip getAudioClip() {
        return this.clip;
    }
 
    public void setAudioClip(AudioClip clip) {
        this.clip = clip;
    }
 
    public String getFilePath() {
    	return this.filePath;
    }
    
    public void setFilePath(int music_no) {
    	this.filePath = "resrc/mid/bgm"+music_no+".mid";
    }
    
    public void play() {
        if (getAudioClip() != null) {
            getAudioClip().play();
        }
    }
 
    public void loop() {
        if (getAudioClip() != null) {
            getAudioClip().loop();
        }
    }
 
    public void stop() {
        if (getAudioClip() != null) {
            getAudioClip().stop();
        }
    }
    @SuppressWarnings("deprecation")
	public void playMusic() {
        try {
            setAudioClip(Applet
                    .newAudioClip((new java.io.File(filePath)).toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        play();

        loop();

    }
}
