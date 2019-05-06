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

    private SupportedDatePickerDialog.OnDateSetListener mDateSetListener;




    public LichThangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initial();

        Log.e("01/01/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 1, 2019, 7.0) + "");
        Log.e("25/02/2019: ", Utilities.getInstance().convertSolar2Lunar(25, 2, 2019, 7.0) + "");
        Log.e("10/03/2019: ", Utilities.getInstance().convertSolar2Lunar(10, 3, 2020, 7.0) + "");

        Log.e("15/05/2019: ", Utilities.getInstance().convertSolar2Lunar(15, 5, 2020, 7.0) + "");
        Log.e("16/05/2019: ", Utilities.getInstance().convertSolar2Lunar(16, 5, 2020, 7.0) + "");
        Log.e("17/05/2019: ", Utilities.getInstance().convertSolar2Lunar(17, 5, 2020, 7.0) + "");
        Log.e("18/05/2019: ", Utilities.getInstance().convertSolar2Lunar(18, 5, 2020, 7.0) + "");
        Log.e("19/05/2019: ", Utilities.getInstance().convertSolar2Lunar(19, 5, 2020, 7.0) + "");
        Log.e("20/05/2019: ", Utilities.getInstance().convertSolar2Lunar(20, 5, 2020, 7.0) + "");
        Log.e("21/05/2019: ", Utilities.getInstance().convertSolar2Lunar(21, 5, 2020, 7.0) + "");
        Log.e("22/05/2019: ", Utilities.getInstance().convertSolar2Lunar(22, 5, 2020, 7.0) + "");
        Log.e("23/05/2019: ", Utilities.getInstance().convertSolar2Lunar(23, 5, 2020, 7.0) + "");
        Log.e("1/06/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 6, 2020, 7.0) + "");
        Log.e("1/07/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 7, 2020, 7.0) + "");
        Log.e("1/08/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 8, 2020, 7.0) + "");
        Log.e("1/09/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 9, 2020, 7.0) + "");
        Log.e("1/10/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 10, 2020, 7.0) + "");
        Log.e("02/12/2019: ", Utilities.getInstance().convertSolar2Lunar(2, 12, 2020, 7.0) + "");
        Log.e("01/11/2019: ", Utilities.getInstance().convertSolar2Lunar(1, 11, 2020, 7.0) + "");

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
                month = month + 1; // vi thang bat dau tu 0

                setDisplayDate(month, year);
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
