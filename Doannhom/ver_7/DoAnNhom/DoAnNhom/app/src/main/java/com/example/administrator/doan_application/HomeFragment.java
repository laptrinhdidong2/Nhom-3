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

    private TextView txtGioPhutGiay, text_ngay_main, tvThangNamDuongLich, text_thu_main, text_lbngayam, text_lbthangam, text_ngaycongiap, text_thangcongiap, text_namcongiap;

    private Handler handler;
    private Runnable runnable;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        text_ngay_main = (TextView) getView().findViewById(R.id.text_ngay_main);
        text_ngay_main.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        txtGioPhutGiay = (TextView) getView().findViewById(R.id.txtGioPhutGiay);
        tvThangNamDuongLich = (TextView)getView().findViewById(R.id.tvThangNamDuongLich);
        text_thu_main = (TextView) getView().findViewById(R.id.text_thu_main);
        text_lbngayam = (TextView)getView().findViewById(R.id.text_lbngayam);
        text_lbthangam = (TextView)getView().findViewById(R.id.text_lbthangam);

        text_ngaycongiap = (TextView)getView().findViewById(R.id.text_ngaycongiap);
        text_thangcongiap = (TextView)getView().findViewById(R.id.text_thangcongiap);
        text_namcongiap = (TextView)getView().findViewById(R.id.text_namcongiap);

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH), month = calendar.get(Calendar.MONTH) + 1, year = calendar.get(Calendar.YEAR);

        String date = "Tháng" + " " + month + " " + "-" + " " + year;
        tvThangNamDuongLich.setText(date);

        String strThu = "";

        switch (calendar.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.MONDAY:
                strThu = "Thứ 2";
                break;
            case Calendar.TUESDAY:
                strThu = "Thứ 3";
                break;
            case Calendar.WEDNESDAY:
                strThu = "Thứ 4";
                break;
            case Calendar.THURSDAY:
                strThu = "Thứ 5";
                break;
            case Calendar.FRIDAY:
                strThu = "Thứ 6";
                break;
            case Calendar.SATURDAY:
                strThu = "Thứ 7";
                break;
            case Calendar.SUNDAY:
                strThu = "Chủ Nhật";
                break;
        }
        text_thu_main.setText(strThu);
        text_ngay_main.setText(day + "");

        Lunar lunar = DoiLichDuongSangAm.SolarToLunar(new Solar(day, month, year));

        text_lbthangam.setText("Tháng " + lunar.lunarMonth + "");
        text_lbngayam.setText(lunar.lunarDay + "");

        text_ngaycongiap.setText("Ng. " + Utilities.getInstance().getNgayAmLich(day, month, year));
        text_thangcongiap.setText("Th. " + Utilities.getInstance().getThangAmLich(lunar.lunarMonth, lunar.lunarYear));
        text_namcongiap.setText("Năm " + Utilities.getInstance().getNamAmLich(year));

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
