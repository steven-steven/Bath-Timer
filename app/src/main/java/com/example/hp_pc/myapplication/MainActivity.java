package com.example.hp_pc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Timer;

import static android.R.attr.x;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextPageButton = (Button)findViewById(R.id.start);
        nextPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText mReminderTime = (EditText)findViewById(R.id.reminderTime);
                EditText mTotalTime = (EditText)findViewById(R.id.totalTime);


                Intent TimerActivity = new Intent(MainActivity.this, Timers.class);
                TimerActivity.putExtra("theReminderTime", Integer.parseInt(mReminderTime.getText().toString()));
                TimerActivity.putExtra("theTotalTime", Integer.parseInt(mTotalTime.getText().toString()));

                startActivity(TimerActivity);
            }
        });






    }
/*
    protected void page2(View view){
        Intent i = new Intent(this, TimerActivity.class);
        startActivity(i);
    }*/

/*
    public ArrayList<String> getPlayList() {

        ArrayList<String> arrayList=new ArrayList<String>();

        String[] proj = {"*"};
        Uri tempPlaylistURI = MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI;

        // In the next line 'this' points to current Activity.
        // If you want to use the same code in other java file then activity,
        // then use an instance of any activity in place of 'this'.

        Cursor playListCursor= MainActivity.this.managedQuery(tempPlaylistURI, proj, null,null,null);

        if(playListCursor == null){
            System.out.println("Not having any Playlist on phone --------------");
            return arrayList;//don't have list on phone
        }

        System.gc();

        String playListName = null;

        System.out.println(">>>>>>>  CREATING AND DISPLAYING LIST OF ALL CREATED PLAYLIST  <<<<<<");

        for(int i = 0; i <playListCursor.getCount() ; i++)
        {
            playListCursor.moveToPosition(i);
            playListName = playListCursor.getString(playListCursor.getColumnIndex("name"));
            System.out.println("> " + i + "  : " + playListName );
            arrayList.add(playListName);
        }

        if(playListCursor != null)
            playListCursor.close();

        return arrayList;



    }

    public void PlaySongsFromAPlaylist(int playListID){

        String[] ARG_STRING = {MediaStore.Audio.Media._ID,MediaStore.Audio.Media.DATA,MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Video.Media.SIZE,android.provider.MediaStore.MediaColumns.DATA};
        Uri membersUri = MediaStore.Audio.Playlists.Members.getContentUri("external", playListID);
        Cursor songsWithingAPlayList = this.managedQuery(membersUri, ARG_STRING, null, null, null);
        int theSongIDIwantToPlay = 0; // PLAYING FROM THE FIRST SONG
        if(songsWithingAPlayList != null)
        {
            songsWithingAPlayList.moveToPosition(theSongIDIwantToPlay);
            String DataStream = songsWithingAPlayList.getString(4);
            PlayMusic(DataStream);
            songsWithingAPlayList.close();
        }
    }

    public static void PlayMusic(String DataStream){
        MediaPlayer mpObject = new MediaPlayer();
        if(DataStream == null)
            return;
        try {
            mpObject.setDataSource(DataStream);
            mpObject.prepare();
            mpObject.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
