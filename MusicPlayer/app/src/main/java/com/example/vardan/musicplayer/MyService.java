package com.example.vardan.musicplayer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Objects;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private int position;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Model model = MusicProvider.getItemByPosition(position);
        mediaPlayer = MediaPlayer.create(this, model.getMusicLink());
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.getExtras() != null) {
            position = intent.getExtras().getInt("key");
        }
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            assert mediaPlayer != null;
            mediaPlayer.start();
        }
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
