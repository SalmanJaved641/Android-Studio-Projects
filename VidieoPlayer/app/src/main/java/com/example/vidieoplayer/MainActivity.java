package com.example.vidieoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView1 = findViewById(R.id.video1);
        VideoView videoView2 = findViewById(R.id.video2);

        String vPath = "android.resource://"+getPackageName()+"/raw/video";

        Uri vUri = Uri.parse(vPath);
        videoView1.setVideoURI(vUri);
        videoView1.start();

        MediaController mediaController1=new MediaController(this);
        videoView1.setMediaController(mediaController1);
        mediaController1.setAnchorView(videoView1);

        String onlinePath = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        Uri onlineUri = Uri.parse(onlinePath);

        videoView2.setVideoURI(onlineUri);
        videoView2.start();

        MediaController mediaController2=new MediaController(this);
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);

    }
}