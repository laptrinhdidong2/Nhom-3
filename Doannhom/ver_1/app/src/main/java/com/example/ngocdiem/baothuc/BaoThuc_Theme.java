package com.example.ngocdiem.baothuc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class BaoThuc_Theme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baothuc_layout);

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
