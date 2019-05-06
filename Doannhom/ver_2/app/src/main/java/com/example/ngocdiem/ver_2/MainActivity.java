package com.example.ngocdiem.ver_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // tao thong tin bao thuc

    }
    /* cac xu ly cho giao dien man hinh 1*/
    /* phan dau chua tieu de va cac tuy chon*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* tao bien MenuInflater*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        return true;
    }


}
