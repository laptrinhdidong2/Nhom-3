package com.example.ngocdiem.animationapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;



public class NavigationDrawer_Theme extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displaySelectedScreen(int itemId) {
        Fragment fragment = null;
        switch (itemId) {
            case R.id.nav_bounce:
                fragment = new bouncefragment();
                break;
            case R.id.nav_Blink:
                fragment = new blinkfragment();
                break;
            case R.id.nav_zoomin:
                fragment = new zoominfragment();
                break;
            case R.id.nav_zoomout:
                fragment = new zoomoutfragment();
                break;
            case R.id.nav_rotate:
                fragment = new rotatefragment();
                break;
            case R.id.nav_move:
                fragment = new movefragment();
                break;
            case R.id.nav_slideup:
                fragment = new slideupfragment();
                break;
            case R.id.nav_slidedown:
                fragment = new slidedownfragment();
                break;
            case R.id.nav_sequentialanimation:
                fragment = new sequentialanimationfragment();
                break;
            case R.id.nav_togetheranimation:
                fragment = new togetheranimationfragment();
                break;
            case R.id.nav_flip:
                fragment = new flipfragment();
                break;
            case R.id.nav_fade:
                fragment = new fadefragment();
                break;
            case R.id.nav_drawable:
                fragment = new drawableanimationfragment();
                break;
            case R.id.nav_swap:
                fragment = new swapanimationfragment();
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
            displaySelectedScreen(item.getItemId());
            return true;
    }
}

