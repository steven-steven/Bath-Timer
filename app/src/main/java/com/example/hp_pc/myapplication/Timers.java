package com.example.hp_pc.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.tag;
import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Timers extends AppCompatActivity {

    public int counter = 0;

    private CountDownTimer cdTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers);

        final TextView label = (TextView)findViewById(R.id.time);



        //Beep
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.beep02);


        Intent mIntent = getIntent();
        final int mReminderTime = mIntent.getIntExtra("theReminderTime", 5);
        int mTotalTime = mIntent.getIntExtra("theTotalTime", 5)*60000;


        label.setText(String.valueOf(mReminderTime));

        /*Timer*/
        cdTimer = new CountDownTimer(mTotalTime, 1000){
            public void onTick(long millisUntilFinished){
                label.setText(String.valueOf(millisUntilFinished / 1000));
                counter++;
                if(counter == mReminderTime*60){
                    mediaPlayer.start();
                    Toast.makeText(Timers.this, "ALERT", Toast.LENGTH_SHORT).show();
                    counter = 0;
                }
            }
            public void onFinish(){

            }
        }.start();



/*

        Button continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


            }
        });
        Button pauseButton = (Button) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


            }
        });
*/
        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                cdTimer.cancel();

                Toast.makeText(Timers.this, "BATH TIMER ENDED", Toast.LENGTH_SHORT).show();
                Intent TimerActivity = new Intent(Timers.this, MainActivity.class);
                startActivity(TimerActivity);
            }
        });


    }
}
