package com.example.administrator.doan_application;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView txtGioPhutGiay;

    private Handler handler;
    private Runnable runnable;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txtGioPhutGiay = (TextView) getView().findViewById(R.id.txtGioPhutGiay);
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                showDongHo();
                handler.postDelayed(runnable, 300);
            }
        };

        handler.postDelayed(runnable, 300);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void showDongHo() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        //Log.e("time: ", mdformat.format(calendar.getTime()));
        txtGioPhutGiay.setText(mdformat.format(calendar.getTime()));
    }
}
