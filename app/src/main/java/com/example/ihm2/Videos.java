package com.example.ihm2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Videos extends AppCompatActivity {

    private VideoView pymes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        pymes = (VideoView) findViewById(R.id.videopymes);

        String pymespath = "android.resource://"+getPackageName() + "/" + R.raw.videopymes;
        Uri uri = Uri.parse(pymespath);
        pymes.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        pymes.setMediaController(mediaController);
        mediaController.setAnchorView(pymes);
        pymes.start();
    }
}
