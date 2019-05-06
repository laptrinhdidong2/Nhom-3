package com.example.administrator.doan_application.baothuc;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.doan_application.R;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ChuongBaoThucActivity extends AppCompatActivity {

    private static final String TAG = "ChuongBaoThucActivity";
    Button btnTaochuong;

    // listview
    private ListView mListView_cb;

    // array list
    ArrayList<ChuongBao> arr_chuongBaos;

    // adapter
    ChuongBaoAdapter adapterChuongBao;
    ChuongBao selectedChuongBao;
    Ringtone ring;
    boolean isStopRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong_bao_thuc);

        isStopRing = false;

        arr_chuongBaos = getRingtones();

        mListView_cb = (ListView) findViewById(R.id.lv_ring);
        adapterChuongBao = new ChuongBaoAdapter(this, R.layout.chuong_baothuc_item, arr_chuongBaos);
        mListView_cb.setAdapter(adapterChuongBao);

        // xu ly passing listview item được chọn từ chuông báo thức sang activity taobaothuc
//        Bundle bundle = getIntent().getExtras();
//        arr_chuongBaos = (ArrayList<ChuongBao>) bundle.getSerializable("ChuongBao");

        inital();
    }
    public void inital(){

        // xử lý button tạo chuông -> hiện lại trang TaoBaoThuc activity

        btnTaochuong = (Button) findViewById(R.id.btnTaochuong);

        btnTaochuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedChuongBao != null)
                {
                    Intent intent = new Intent();
                    intent.putExtra(TaoBaoThucActivity.EXTRA_SELECTED_CHUONGBAO, selectedChuongBao);
                    setResult(Activity.RESULT_OK, intent);
                    if (ring.isPlaying())
                    {
                        ring.stop();
                    }
                    finish();
                }
                else
                {
                    // hiện lỗi

                    return;

                }

            }
        });

        mListView_cb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isStopRing = true;

                for (int i = 0; i < arr_chuongBaos.size(); i++) {
                    arr_chuongBaos.get(i).setCkecked(false);
                }

                arr_chuongBaos.get(position).setCkecked(true);
                selectedChuongBao = arr_chuongBaos.get(position);
                adapterChuongBao.notifyDataSetChanged();

                ring = RingtoneManager.getRingtone(getApplicationContext(), Uri.parse(arr_chuongBaos.get(position).getsDuongDan()));

                if (ring.isPlaying())
                {
                    ring.stop();
                }

                Handler handler = new Handler();

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        isStopRing = false;
                        int count = 3;
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

                        if (isStopRing)
                        {
                            return;
                        }
                        ring.stop();
                    }
                });


            }
        });
    }

    // xử lý nhạc chuông báo thức
    public ArrayList<ChuongBao> getRingtones() {
        RingtoneManager manager = new RingtoneManager(this);
        manager.setType(RingtoneManager.TYPE_ALARM);
        Cursor cursor = manager.getCursor();

        ArrayList<ChuongBao> list = new ArrayList();

        while (cursor.moveToNext()) {
            String ringtoneTitle = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX);
            String ringtoneUri = cursor.getString(RingtoneManager.URI_COLUMN_INDEX) + "/" + cursor.getString(RingtoneManager.ID_COLUMN_INDEX);

            list.add(new ChuongBao(ringtoneTitle, ringtoneUri, false));
        }

        return list;
    }
}
