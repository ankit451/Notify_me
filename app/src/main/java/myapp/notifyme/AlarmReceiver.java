package myapp.notifyme;

/**
 * Created by User on 3/5/2016.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.media.MediaPlayer;

public class AlarmReceiver extends BroadcastReceiver {




    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "Wake Up now! Its Class time", Toast.LENGTH_LONG).show();
        final MediaPlayer mediaPlayer = MediaPlayer.create(arg0, R.raw.test);
        mediaPlayer.start();

    }

}