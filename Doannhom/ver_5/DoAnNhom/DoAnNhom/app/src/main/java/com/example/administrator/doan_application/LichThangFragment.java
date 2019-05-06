package com.example.administrator.doan_application;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibotta.android.support.pickerdialogs.SupportedDatePickerDialog;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class LichThangFragment extends Fragment {

    public static final String EXTRA_DATE = "com.example.application.example.EXTRA_DATE";
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";

    private  static final String TAG = "LichThangFragment";

    private Calendar selectedDate;

    private TextView mDisplayDate;

    LinearLayout linearLayout;

//    LinearLayout layout_week_1;
//
//    LinearLayout layout_week_2;
//
//    LinearLayout layout_week_3;
//
//    LinearLayout layout_week_4;
//
//    LinearLayout layout_week_5;
//
//    LinearLayout layout_week_6;
//
//    LinearLayout[] lstLayoutWeeks;
//    LinearLayout[] lstDays;

    private SupportedDatePickerDialog.OnDateSetListener mDateSetListener;




    public LichThangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initial();

//        layout_week_1 = (LinearLayout) getView().findViewById(R.id.layout_week_1);
//        layout_week_2 = (LinearLayout) getView().findViewById(R.id.layout_week_2);
//        layout_week_3 = (LinearLayout) getView().findViewById(R.id.layout_week_3);
//        layout_week_4 = (LinearLayout) getView().findViewById(R.id.layout_week_4);
//        layout_week_5 = (LinearLayout) getView().findViewById(R.id.layout_week_5);
//        layout_week_6 = (LinearLayout) getView().findViewById(R.id.layout_week_6);
//
//        lstLayoutWeeks = new LinearLayout[6];
//        lstLayoutWeeks[0] = layout_week_1;
//        lstLayoutWeeks[1] = layout_week_2;
//        lstLayoutWeeks[2] = layout_week_3;
//        lstLayoutWeeks[3] = layout_week_4;
//        lstLayoutWeeks[4] = layout_week_5;
//        lstLayoutWeeks[5] = layout_week_6;
//
//        lstDays = new LinearLayout[42];

//        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT);
//        linearLayoutParams.weight = 1;
//
//        int daysArrayCount = 0;
//
//        for (int weekNumber = 0; weekNumber < 6; ++weekNumber) {
//            for (int dayInWeek = 0; dayInWeek < 7; ++dayInWeek) {
//                final LinearLayout day = new LinearLayout(this.getContext());
//
//                day.setLayoutParams(linearLayoutParams);
//                day.setBackground(getResources().getDrawable(R.drawable.vienolich));
//
//                int paddingDp = 5;
//                float density = getResources().getDisplayMetrics().density;
//                int paddingPixel = (int)(paddingDp * density);
//                day.setPadding(0, paddingPixel, 0, paddingPixel);
//                day.setOrientation(LinearLayout.VERTICAL);
//
//                lstDays[daysArrayCount] = day;
//                lstLayoutWeeks[weekNumber].addView(day);
//
//                ++daysArrayCount;
//            }
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lich_thang, container, false);
    }

    public void initial() {

        linearLayout = (LinearLayout) getView().findViewById(R.id.othu2);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity2((LinearLayout) v);
            }
        });

        mDisplayDate = (TextView) getView().findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                new SupportedDatePickerDialog(LichThangFragment.this.getActivity(), R.style.SpinnerDatePickerDialogTheme, mDateSetListener, year, month, day).show();
            }
        });

        mDateSetListener = new SupportedDatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                setDisplayDate(month + 1, year);

                selectedDate.set(Calendar.MONTH, month);
                selectedDate.set(Calendar.YEAR, year);
            }
        };

        selectedDate = Calendar.getInstance();
        setDisplayDate(selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.YEAR));
    }

    public void setDisplayDate(int month, int year) {
        String date = "Tháng" + " " + month + " " + "-" + " " + year;
        mDisplayDate.setText(date);
    }

    public void openActivity2(LinearLayout view){

        TextView tvNgayDuong = (TextView) view.getChildAt(0);
        TextView tvNgayAm = (TextView) view.getChildAt(1);

        int ngayDuong = Integer.valueOf(tvNgayDuong.getText().toString());
        int ngayAm = Integer.valueOf(tvNgayAm.getText().toString());

        selectedDate.set(Calendar.DAY_OF_MONTH, ngayDuong);
        Log.e("selected year: ", selectedDate.get(Calendar.YEAR) + "");
//        TextView textView1 = (TextView) getView().findViewById(R.id.textView1);
//        String text = textView1.getText().toString();
//
//        TextView textView2 = (TextView) getView().findViewById(R.id.textView2);
//        String text2 = textView2.getText().toString();

        Intent intent = new Intent(this.getActivity(), ActivityLichThangAm.class);
        intent.putExtra(EXTRA_DATE, selectedDate);

        startActivity(intent);
    }

    public void HienThiLichAm(int so){


    }
}
