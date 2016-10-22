package kevin.example.com.musicplayer.data;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/12.
 */
public class MusicList {

    private static ArrayList<Music> musicArray = new ArrayList<>();

    public static ArrayList<Music> getMusicList() {
        return musicArray;
    }


    private  MusicList(){};
}
