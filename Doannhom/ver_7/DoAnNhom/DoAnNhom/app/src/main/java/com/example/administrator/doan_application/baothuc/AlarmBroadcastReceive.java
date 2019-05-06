package com.example.administrator.doan_application.baothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AlarmBroadcastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String chuoiString = intent.getExtras().getString("extra");
        Log.e("Bạn truyền key", chuoiString);

        Intent myIntent = new Intent(context, HenBaoThucActivity.class);
        myIntent.putExtra("extra", chuoiString);

        context.startService(myIntent);
    }
}