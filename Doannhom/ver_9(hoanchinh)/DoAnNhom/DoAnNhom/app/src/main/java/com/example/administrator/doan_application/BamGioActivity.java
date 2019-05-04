package com.example.administrator.doan_application;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BamGioActivity extends AppCompatActivity {

    Button btnStop,btnStart, btnPause ,btnDelete;
    TextView txtTimer;
    long lStartTime, lPauseTime, lSystemTime = 0L;
    Handler handler = new Handler();
    boolean isRun;
    ListView listView;
    ArrayList<String> arrayCourse;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            lSystemTime = SystemClock.uptimeMillis() - lStartTime;
            long lUpdateTime = lPauseTime + lSystemTime;
            long secs = (long)(lUpdateTime/1000);
            long mins= secs/60;
            secs = secs %60;
            long milliseconds = (long)(lUpdateTime%1000);
            txtTimer.setText(""+mins+":" + String.format("%02d",secs) + ":" + String.format("%03d",milliseconds));
            handler.postDelayed(this,0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bam_gio);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        btnPause = (Button)findViewById(R.id.btnPause);
        txtTimer = (TextView)findViewById(R.id.txtTimer);
        listView = (ListView)findViewById(R.id.lvTime);
        arrayCourse = new ArrayList<String>();

        final ArrayAdapter adapter  = new ArrayAdapter(BamGioActivity.this,android.R.layout.simple_list_item_1,arrayCourse);
        listView.setAdapter(adapter);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = txtTimer.getText().toString();
                Toast.makeText(BamGioActivity.this,time,Toast.LENGTH_LONG).show();
                arrayCourse.add(time);
                adapter.notifyDataSetChanged();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isRun)
                    return;
                isRun = false;
                lPauseTime = 0;
                handler.removeCallbacks(runnable);
                txtTimer.setText("00:00:00");
                arrayCourse.clear();;
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        clickStart();
    }

    public void clickStart(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRun)
                    return;
                isRun = true;
                lStartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
            }
        });
    }
}
