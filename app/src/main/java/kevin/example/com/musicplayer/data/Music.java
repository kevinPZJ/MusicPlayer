package kevin.example.com.musicplayer.data;


/**
 * Created by kevin on 2016/10/12.
 */
public class Music {
    private String musicAcrist;
    private String musicName;
    private String musicPath;
    private String musicDuration;
    public Music(String musicAcrist,String musicName,String musicPath,String musicDuration){
        this.musicName=musicName;
        this.musicAcrist=musicAcrist;
        this.musicPath=musicPath;
        this.musicDuration= musicDuration;
    }

    public String getMusicAcrist() {
        return this.musicAcrist;
    }

    public String getMusicDuration() {
        return this.musicDuration;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicPath() {
        return this.musicPath;
    }






}
