package com.example.administrator.doan_application.baothuc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.doan_application.R;

public class HenBaoThucActivity extends AppCompatActivity {

    Button btn_tat_baothuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen_bao_thuc);

    }

    public void initial(){
        btn_tat_baothuc = (Button) findViewById(R.id.btn_tat_baothuc);

        // khi tat baothuc tro ve man hinh chinh
//        btn_tat_baothuc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("ActivityName", "BaoThuc");
//                setResult(Activity.RESULT_CANCELED, intent);
//
//                finish();
//            }
//        });
    }

}
