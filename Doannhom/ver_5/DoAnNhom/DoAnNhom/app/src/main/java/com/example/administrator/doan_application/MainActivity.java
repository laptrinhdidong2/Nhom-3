package com.example.administrator.doan_application;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainMenu;
    private FrameLayout mMainLayout;

    private HomeFragment homeFragment;
    private LichThangFragment lichThangFragment;
    private BaoThucFragment baoThucFragment;
    private ChucNangMoRongFragment chucNangMoRongFragment;
    private ChuyenDoiFragment chuyenDoiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayout = (FrameLayout)findViewById(R.id.fragment_container);
        mMainMenu = (BottomNavigationView)findViewById(R.id.bottom_menu);

        homeFragment = new HomeFragment();
        lichThangFragment = new LichThangFragment();
        baoThucFragment = new BaoThucFragment();
        chucNangMoRongFragment = new ChucNangMoRongFragment();
        chuyenDoiFragment = new ChuyenDoiFragment();

        mMainMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Log.e("id: ", menuItem.getItemId() + "");

                switch (menuItem.getItemId()) {

                    case R.id.menu_home:{
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        Log.e("click", R.id.menu_home + "");
                        setFragment(homeFragment);
                        return true;
                    }

                    case R.id.menu_lich_thang: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        Log.e("click: ", R.id.menu_lich_thang + "");
                        setFragment(lichThangFragment);
                        return true;
                    }

                    case R.id.menu_bao_thuc: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(baoThucFragment);
                        return true;
                    }

                    case R.id.menu_chuyen_doi: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(chuyenDoiFragment);
                        return true;
                    }

                    case R.id.menu_mo_rong: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(chucNangMoRongFragment);
                        return true;
                    }

                    default: {
                        setFragment(lichThangFragment);
                        Log.e("log: ", "vao default");
                        return true;
                    }
                }
            }
        });

        mMainMenu.setSelectedItemId(R.id.menu_home);
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
