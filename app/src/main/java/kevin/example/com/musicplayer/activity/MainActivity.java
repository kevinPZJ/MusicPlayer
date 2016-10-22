package kevin.example.com.musicplayer.activity;

import android.database.Cursor;
import android.media.session.MediaController;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import kevin.example.com.musicplayer.R;
import kevin.example.com.musicplayer.data.Music;
import kevin.example.com.musicplayer.data.MusicList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mainListview;
    private ImageButton previos;
    private ImageButton play;
    private ImageButton stop;
    private ImageButton next;
    //获取歌曲信息
    private ArrayList<Music> musicArrayList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initview();
        initmusicArrayList();
        initLIstview();
    }

    private void initLIstview() {

        List<Map<String,String>> list_map=new ArrayList<Map<String,String>>();
        HashMap<String,String> map;
        SimpleAdapter simpleAdapter;
        for (Music music:musicArrayList) {
            map = new HashMap<String, String>();
            map.put("musicName", music.getMusicName());
            map.put("musicAritist", music.getMusicAcrist());

            list_map.add(map);
        }
        String [] formn=new String[]{"musicName","musicArtist"};
        int[] to ={R.id.listview_tittle_item,R.id.list_tittle_artist};

        simpleAdapter=new SimpleAdapter(this,list_map,R.layout.listview,formn,to);
        mainListview.setAdapter(simpleAdapter);


    }

    private void initmusicArrayList() {
        musicArrayList=MusicList.getMusicList();

        if (musicArrayList.isEmpty()){
            Cursor mMucicCursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,
            null,MediaStore.Audio.AudioColumns.TITLE);
            int indexTitle= mMucicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
            int indexArist=  mMucicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
            int indexPath=  mMucicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
            int indexTotalTime=  mMucicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
            for(mMucicCursor.moveToFirst();!mMucicCursor.isAfterLast();mMucicCursor.moveToNext())
            {
                String strTitle=mMucicCursor.getString(indexTitle);
                String strArist=mMucicCursor.getString(indexArist);
                String strTotalTime=mMucicCursor.getString(indexTotalTime);
                String strAPath=mMucicCursor.getString(indexPath);
                if(strArist.equals("<unknown>"))
                    strArist="无艺术家";
                Music music =new Music(strTitle,strArist,strAPath,strTotalTime);
                musicArrayList.add(music);
            }


        }
        
    }

    private void initview() {
        mainListview = (ListView) findViewById(R.id.mainListview);
        previos = (ImageButton) findViewById(R.id.previos);
        play = (ImageButton) findViewById(R.id.play);
        stop = (ImageButton) findViewById(R.id.stop);
        next = (ImageButton) findViewById(R.id.next);

        previos.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        next.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){






        }

    }
}
