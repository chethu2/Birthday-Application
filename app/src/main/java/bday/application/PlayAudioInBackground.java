package bday.application;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import anusha.girl.bday.anusha.R;

/**
 * Created by chea on 10-03-2018.
 */

public class PlayAudioInBackground extends Service {

    MediaPlayer audioPlayer;
    String LOGCAT = null;
    public void onCreate() {
        audioPlayer = MediaPlayer.create(this, R.raw.bdaysong); //select music file
        audioPlayer.setLooping(true); //set looping
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.print("started audio ");
        audioPlayer.start();
        return Service.START_NOT_STICKY;
    }

    public void onDestroy() {
        audioPlayer.stop();
        audioPlayer.release();
        stopSelf();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent objIndent) {
        return null;
    }
}

