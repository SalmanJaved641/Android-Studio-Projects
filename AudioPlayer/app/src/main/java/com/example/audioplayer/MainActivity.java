package com.example.audioplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Button btnPlay,btnPause,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String audioPath = "android.resource://"+getPackageName()+"/raw/surat_at_tin";
        String onlineAudioPath = "http://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/theme_01.mp3";

        Uri audioUri = Uri.parse(audioPath);
        Uri onlineUri = Uri.parse(onlineAudioPath);



        try {
            mp.setDataSource(this,audioUri);
            mp.prepare();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mp.stop();   this will release the mp memory but we want
//                to rest audio on this btn so we dont use it
                mp.pause();
                mp.seekTo(0);
            }
        });


    }
}
/*
Commonly used Media Player Attributes:

    mp.getDuration()
    mp.getCurrentPosition()

    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
});*/
