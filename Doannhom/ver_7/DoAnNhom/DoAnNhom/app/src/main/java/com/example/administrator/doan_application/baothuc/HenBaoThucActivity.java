package com.example.administrator.doan_application.baothuc;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.doan_application.R;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class HenBaoThucActivity extends AppCompatActivity {

    Button btn_tat_baothuc;
    TextView txt_hengio, txt_ghichu_hengio;

    String ghiChu, chuongBao;
    int timeHour, timeMinute;

    boolean isStopRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen_bao_thuc);

        initial();
    }

    public void initial(){

        chuongBao = getIntent().getStringExtra(TaoBaoThucActivity.EXTRA_CHUONGBAOTHUC);
        timeHour = getIntent().getIntExtra(TaoBaoThucActivity.EXTRA_GIOBAOTHUC, 0);
        timeMinute = getIntent().getIntExtra(TaoBaoThucActivity.EXTRA_PHUTBAOTHUC, 0);
        ghiChu = getIntent().getStringExtra(TaoBaoThucActivity.EXTRA_GHICHUBAOTHUC);

        btn_tat_baothuc = (Button) findViewById(R.id.btn_tat_baothuc);
        txt_hengio = (TextView) findViewById(R.id.txt_hengio);
        txt_ghichu_hengio = (TextView) findViewById(R.id.txt_ghichu_hengio);

        txt_hengio.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        txt_hengio.setText(timeHour + ":" + timeMinute);
        txt_ghichu_hengio.setText(ghiChu);

        startRingTone();

        btn_tat_baothuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRingTone();
                finish();
            }
        });
    }

    public void startRingTone()
    {
        final Ringtone ring = RingtoneManager.getRingtone(getApplicationContext(), Uri.parse(chuongBao));

        if (ring.isPlaying())
        {
            ring.stop();
        }

        Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                isStopRing = false;
                int count = 20;
                while(count > 0)
                {
                    if (isStopRing)
                    {
                        return;
                    }
                    Log.e("while: ", count + "");
                    ring.play();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count--;
                }

                ring.stop();
            }
        });
    }

    public void stopRingTone()
    {
        isStopRing = true;
    }

}

