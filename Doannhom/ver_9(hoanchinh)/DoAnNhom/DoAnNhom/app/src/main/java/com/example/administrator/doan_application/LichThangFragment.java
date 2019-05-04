package com.example.administrator.doan_application;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibotta.android.support.pickerdialogs.SupportedDatePickerDialog;

import org.w3c.dom.Text;

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

    LinearLayout layout_week_1;
    LinearLayout layout_week_2;
    LinearLayout layout_week_3;
    LinearLayout layout_week_4;
    LinearLayout layout_week_5;
    LinearLayout layout_week_6;
//
    LinearLayout[] lstLayoutWeeks;
    LinearLayout[] lstDays;

    float density;

    private SupportedDatePickerDialog.OnDateSetListener mDateSetListener;




    public LichThangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initial();

        density = getResources().getDisplayMetrics().density;

        Calendar calendar = Calendar.getInstance();

        Log.e("today: ", calendar.get(Calendar.DAY_OF_WEEK) + "");
        Log.e("today: ", calendar.get(Calendar.DAY_OF_MONTH) + "");
        Log.e("today: ", calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "");
        Log.e("first day: ", selectedDate.getActualMaximum(Calendar.DAY_OF_MONTH) + "");

        initialCalendar();
        setCalendarOfMonth();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lich_thang, container, false);
    }

    public void initial() {

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

                setCalendarOfMonth();
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
        //int ngayAm = Integer.valueOf(tvNgayAm.getText().toString());

        selectedDate.set(Calendar.DAY_OF_MONTH, ngayDuong);
        Log.e("selected year: ", selectedDate.get(Calendar.YEAR) + "");

        Intent intent = new Intent(this.getActivity(), ActivityLichThangAm.class);
        intent.putExtra(EXTRA_DATE, selectedDate);

        startActivity(intent);
    }

    public void initialCalendar()
    {
        layout_week_1 = (LinearLayout) getView().findViewById(R.id.layout_week_1);
        layout_week_2 = (LinearLayout) getView().findViewById(R.id.layout_week_2);
        layout_week_3 = (LinearLayout) getView().findViewById(R.id.layout_week_3);
        layout_week_4 = (LinearLayout) getView().findViewById(R.id.layout_week_4);
        layout_week_5 = (LinearLayout) getView().findViewById(R.id.layout_week_5);
        layout_week_6 = (LinearLayout) getView().findViewById(R.id.layout_week_6);

        lstLayoutWeeks = new LinearLayout[6];

        layout_week_1.removeAllViews();
        lstLayoutWeeks[0] = layout_week_1;
        layout_week_2.removeAllViews();
        lstLayoutWeeks[1] = layout_week_2;
        layout_week_3.removeAllViews();
        lstLayoutWeeks[2] = layout_week_3;
        layout_week_4.removeAllViews();
        lstLayoutWeeks[3] = layout_week_4;
        layout_week_5.removeAllViews();
        lstLayoutWeeks[4] = layout_week_5;
        layout_week_6.removeAllViews();
        lstLayoutWeeks[5] = layout_week_6;

        lstDays = new LinearLayout[42];

        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayoutParams.weight = 1;

        int daysArrayCount = 0;

        for (int weekNumber = 0; weekNumber < 6; ++weekNumber) {
            for (int dayInWeek = 0; dayInWeek < 7; ++dayInWeek) {
                final LinearLayout day = new LinearLayout(this.getContext());

                day.setLayoutParams(linearLayoutParams);
                day.setBackground(getResources().getDrawable(R.drawable.vienolich));

                int paddingDp = 5;

                int paddingPixel = (int)(paddingDp * density);
                day.setPadding(0, paddingPixel, 0, paddingPixel);
                day.setOrientation(LinearLayout.VERTICAL);

                TextView tvNgayDuong = new TextView(this.getContext());
                LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                tvNgayDuong.setLayoutParams(textViewLayoutParams);
                tvNgayDuong.setTextSize(26); // set font size 26dp
                tvNgayDuong.setGravity(Gravity.CENTER);
                tvNgayDuong.setTextColor( getResources().getColor(R.color.mauso_lich));
                tvNgayDuong.setTypeface(Typeface.DEFAULT_BOLD);
                tvNgayDuong.setText("16");

                TextView tvNgayAm = new TextView(this.getContext());
                tvNgayAm.setLayoutParams(textViewLayoutParams);
                tvNgayAm.setTextSize(16); // set font size 16dp
                tvNgayAm.setGravity(Gravity.CENTER);
                tvNgayAm.setTextColor( getResources().getColor(R.color.mauso_lich));
                tvNgayAm.setTypeface(Typeface.DEFAULT_BOLD);
                tvNgayAm.setText("12");

                if (dayInWeek == 6)
                {
                    tvNgayDuong.setTextColor(getResources().getColor(R.color.maudo_cn));
                    tvNgayAm.setTextColor(getResources().getColor(R.color.maudo_cn));
                }

                day.addView(tvNgayDuong);
                day.addView(tvNgayAm);

                // add sự kiện click vào và mở activity lịch âm
                day.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openActivity2((LinearLayout) v);
                    }
                });

                lstDays[daysArrayCount] = day;
                lstLayoutWeeks[weekNumber].addView(day);

                ++daysArrayCount;
            }
        }
    }

    public void setCalendarOfMonth() {

        int weekDayOfFirstDay = Utilities.getInstance().DayOfWeek(1, selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.YEAR)); // selectedDate.get(Calendar.DAY_OF_WEEK_IN_MONTH)
        int daysOfMonth = selectedDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayNumber = 1;

        if (weekDayOfFirstDay == 0)
        {
            weekDayOfFirstDay = 7;
        }

        // Previous month
        int previousMonth, previousYear;
        if (selectedDate.get(Calendar.MONTH) == 0)
        {
            previousMonth = 11;
            previousYear = selectedDate.get(Calendar.YEAR) - 1;
        }
        else
        {
            previousMonth = selectedDate.get(Calendar.MONTH) - 1;
            previousYear = selectedDate.get(Calendar.YEAR);
        }

        Calendar calendarPreviousMonth = Calendar.getInstance();
        calendarPreviousMonth.set(Calendar.MONTH, previousMonth);
        calendarPreviousMonth.set(Calendar.YEAR, previousYear);
        int daysOfPreviousMonth = calendarPreviousMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = weekDayOfFirstDay - 2; i >= 0; i--)
        {
            LinearLayout currentLinear = lstDays[i];

            TextView tvNgayDuong = (TextView) currentLinear.getChildAt(0);
            TextView tvNgayAm = (TextView) currentLinear.getChildAt(1);

            tvNgayDuong.setText(String.valueOf(daysOfPreviousMonth));
            Lunar lunar = DoiLichDuongSangAm.SolarToLunar(new Solar(daysOfPreviousMonth, calendarPreviousMonth.get(Calendar.MONTH) + 1, calendarPreviousMonth.get(Calendar.YEAR)));
            if (lunar.lunarDay == 1)
            {
                tvNgayAm.setText(lunar.lunarDay + "/" + lunar.lunarMonth);
            }
            else
            {
                tvNgayAm.setText(lunar.lunarDay + "");
            }

            daysOfPreviousMonth--;
        }

        // Current month
        for (int i = weekDayOfFirstDay - 1; i < weekDayOfFirstDay - 1 + daysOfMonth; i++)
        {
            LinearLayout currentLinear = lstDays[i];


            TextView tvNgayDuong = (TextView) currentLinear.getChildAt(0);
            TextView tvNgayAm = (TextView) currentLinear.getChildAt(1);

            tvNgayDuong.setText(String.valueOf(dayNumber));
            Lunar lunar = DoiLichDuongSangAm.SolarToLunar(new Solar(dayNumber, selectedDate.get(Calendar.MONTH) + 1, selectedDate.get(Calendar.YEAR)));
            if (lunar.lunarDay == 1)
            {
                tvNgayAm.setText(lunar.lunarDay + "/" + lunar.lunarMonth);
            }
            else
            {
                tvNgayAm.setText(lunar.lunarDay + "");
            }

            dayNumber++;
        }

        // Next month
        int nextMonth, nextYear;
        if (selectedDate.get(Calendar.MONTH) == 11)
        {
            nextMonth = 0;
            nextYear = selectedDate.get(Calendar.YEAR) + 1;
        }
        else
        {
            nextMonth = selectedDate.get(Calendar.MONTH) + 1;
            nextYear = selectedDate.get(Calendar.YEAR);
        }

        Calendar calendarNextMonth = Calendar.getInstance();
        calendarNextMonth.set(Calendar.MONTH, nextMonth);
        calendarNextMonth.set(Calendar.YEAR, nextYear);
        int daysOfNextMonth = 1;

        for (int i = weekDayOfFirstDay - 1 + daysOfMonth; i < 42; i++)
        {
            LinearLayout currentLinear = lstDays[i];

            TextView tvNgayDuong = (TextView) currentLinear.getChildAt(0);
            TextView tvNgayAm = (TextView) currentLinear.getChildAt(1);

            tvNgayDuong.setText(String.valueOf(daysOfNextMonth));
            Lunar lunar = DoiLichDuongSangAm.SolarToLunar(new Solar(daysOfNextMonth, calendarNextMonth.get(Calendar.MONTH) + 1, calendarNextMonth.get(Calendar.YEAR)));
            if (lunar.lunarDay == 1)
            {
                tvNgayAm.setText(lunar.lunarDay + "/" + lunar.lunarMonth);
            }
            else
            {
                tvNgayAm.setText(lunar.lunarDay + "");
            }

            daysOfNextMonth++;
        }

    }

    public void HienThiLichAm(int so){



    }
}
