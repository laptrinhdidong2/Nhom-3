package com.example.administrator.doan_application;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainMenu;
    private FrameLayout mMainLayout;

    private LichThangFragment lichThangFragment;
    private BaoThucFragment baoThucFragment;
    private BamGioFragment bamGioFragment;
    private DemNguocFragment demNguocFragment;
    private ChuyenDoiFragment chuyenDoiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayout = (FrameLayout)findViewById(R.id.fragment_container);
        mMainMenu = (BottomNavigationView)findViewById(R.id.bottom_menu);

        lichThangFragment = new LichThangFragment();

        baoThucFragment = new BaoThucFragment();
        bamGioFragment = new BamGioFragment();
        demNguocFragment = new DemNguocFragment();
        chuyenDoiFragment = new ChuyenDoiFragment();

        mMainMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Log.e("id: ", menuItem.getItemId() + "");

                switch (menuItem.getItemId()) {
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

                    case R.id.menu_bam_gio: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(bamGioFragment);
                        return true;
                    }

                    case R.id.menu_dem_nguoc: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(demNguocFragment);
                        return true;
                    }

                    case R.id.menu_chuyen_doi: {
                        mMainMenu.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(chuyenDoiFragment);
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
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        Log.e("tag: ", "Truoc commit");
        fragmentTransaction.commit();
        Log.e("tag: ", "Sau commit");
    }

    public void setSelectedItemMenu(int id) {
        Log.e("tag: ", "in setSelectedItem");
        mMainMenu.setSelectedItemId(id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e("tag: ", "ActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }
}
