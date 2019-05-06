package com.example.administrator.doan_application;

import android.util.Log;

import java.util.ArrayList;

public class Utilities {

    private Utilities() {}

    private static Utilities instance;

    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }

        return instance;
    }

    public static final float PI = 3.14f;

    public String getNamAmLich(int nam){
        String can = " ";
        String chi = " ";
        switch (nam % 10){
            case 0:
                can = "Canh";
                break;
            case 1:
                can = "Tân";
                break;
            case 2:
                can = "Nhâm";
                break;
            case 3:
                can = "Qúy";
                break;
            case 4:
                can = "Giáp";
                break;
            case 5:
                can = "Ất";
                break;
            case 6:
                can = "Binh";
                break;
            case 7:
                can = "Đinh";
                break;
            case 8:
                can = "Mậu";
                break;
            case 9:
                can = "Kỷ";
                break;
        }

        switch (nam % 12){
            case 0:
                chi = "Thân";
                break;
            case 1:
                chi = "Dậu";
                break;
            case 2:
                chi = "Tuất";
                break;
            case 3:
                chi = "Hợi";
                break;
            case 4:
                chi = "Tý";
                break;
            case 5:
                chi = "Sửu";
                break;
            case 6:
                chi = "Dần";
                break;
            case 7:
                chi = "Mẹo";
                break;
            case 8:
                chi = "Thìn";
                break;
            case 9:
                chi = "Tị";
                break;
            case 10:
                chi = "Ngọ";
                break;
            case 11:
                chi = "Mùi";
                break;
        }
        return  can + " " + chi;
    }

    public String getThangAmLich(int thang, int nam){

        String can = " ";
        String chi = " ";

        int can_thang = nam*12+thang+3;

        switch (can_thang % 10)
        {
            case 0:
                can = "Giáp";
                break;
            case 1:
                can = "Ất";
                break;
            case 2:
                can = "Binh";
                break;
            case 3:
                can = "Đinh";
                break;
            case 4:
                can = "Mậu";
                break;
            case 5:
                can = "Kỷ";
                break;
            case 6:
                can = "Canh";
                break;
            case 7:
                can = "Tân";
                break;
            case 8:
                can = "Nhâm";
                break;
            case 9:
                can = "Qúy";
                break;

        }

        switch (thang %12){
            case 11:
                chi = "Tý";
                break;
            case 0:
                chi = "Sửu";
                break;
            case 1:
                chi = "Dần";
                break;
            case 2:
                chi = "Mẹo";
                break;
            case 3:
                chi = "Thìn";
                break;
            case 4:
                chi = "Tỵ";
                break;
            case 5:
                chi = "Ngọ";
                break;
            case 6:
                chi = "Mùi";
                break;
            case 7:
                chi = "Thân";
                break;
            case 8:
                chi = "Dậu";
                break;
            case 9:
                chi = "Tuất";
                break;
            case 10:
                chi = "Hợi";
                break;

        }

        return can + " " + chi;
    }

    public String getNgayAmLich(int ngay, int thang, int nam){
        String can = " ";
        String chi = " ";
        int a, y, m, julius;

        a = (14 - thang) / 12; // 0  1
        y = nam + 4800 - a; // -2781   // 6799
        m = thang + 12 * a - 3; // 0 // 10
        julius = ngay + (153*m+2)/5 + 365*y + y/4 - y/100 + y/400 - 32045; // Đây là công thức áp dụng cho lịch Gregory
        Log.e("j: ", julius +"");

        switch ((julius + 9) % 10){
            case 0:
                can = "Giáp";
                break;
            case 1:
                can = "Ất";
                break;
            case 2:
                can = "Binh";
                break;
            case 3:
                can = "Đinh";
                break;
            case 4:
                can = "Mậu";
                break;
            case 5:
                can = "Kỵ";
                break;
            case 6:
                can = "Canh";
                break;
            case 7:
                can = "Tân";
                break;
            case 8:
                can = "Nhâm";
                break;
            case 9:
                can = "Qúy";
                break;

        }

        switch ((julius + 1) % 12){
            case 0:
                chi = "Tý";
                break;
            case 1:
                chi = "Sửu";
                break;
            case 2:
                chi = "Dần";
                break;
            case 3:
                chi = "Mẹo";
                break;
            case 4:
                chi = "Thìn";
                break;
            case 5:
                chi = "Tỵ";
                break;
            case 6:
                chi = "Ngọ";
                break;
            case 7:
                chi = "Mùi";
                break;
            case 8:
                chi = "Thân";
                break;
            case 9:
                chi = "Dậu";
                break;
            case 10:
                chi = "Tuất";
                break;
            case 11:
                chi = "Hợi";
                break;

        }

        return can + " " + chi;
    }

    // INT(x) là hàm trả về số nguyên không vượt quá x. VD: INT(3.8) = 3, INT(-3.2) = -4


    // Tinh ngay Soc
    public double getNewMoonday(double k,double timeZone){

        double T, T2, T3, dr, Jd1, M, Mpr, F, C1, deltat, JdNew;

        T = k/1236.85;
        T2 = T * T;
        T3 = T2 * T;
        dr = PI/180;

        Jd1 = 2415020.75933 + 29.53058868*k + 0.0001178*T2 - 0.000000155*T3;

        Jd1 = Jd1 + 0.00033*Math.sin((166.56 + 132.87*T - 0.009173*T2)*dr);

        M = 359.2242 + 29.10535608*k - 0.0000333*T2 - 0.00000347*T3;

        Mpr = 306.0253 + 385.81691806*k + 0.0107306*T2 + 0.00001236*T3;

        F = 21.2964 + 390.67050646*k - 0.0016528*T2 - 0.00000239*T3;

        C1=(0.1734 - 0.000393*T)*Math.sin(M*dr) + 0.0021*Math.sin(2*dr*M);

        C1 = C1 - 0.4068*Math.sin(Mpr*dr) + 0.0161*Math.sin(dr*2*Mpr);

        C1 = C1 - 0.0004*Math.sin(dr*3*Mpr);

        C1 = C1 + 0.0104*Math.sin(dr*2*F) - 0.0051*Math.sin(dr*(M+Mpr));

        C1 = C1 - 0.0074*Math.sin(dr*(M-Mpr)) + 0.0004*Math.sin(dr*(2*F+M));

        C1 = C1 - 0.0004*Math.sin(dr*(2*F-M)) - 0.0006*Math.sin(dr*(2*F+Mpr));

        C1 = C1 + 0.0010*Math.sin(dr*(2*F-Mpr)) + 0.0005*Math.sin(dr*(2*Mpr+M));

        if (T < -11) {
            deltat= 0.001 + 0.000839*T + 0.0002261*T2 - 0.00000845*T3 - 0.000000081*T*T3;
        } else {
            deltat= -0.000278 + 0.000265*T + 0.000262*T2;
        };
        JdNew = Jd1 + C1 - deltat;

        return Math.floor(JdNew + 0.5 + timeZone/24); //Math.floor

    }


     //Tinh toa do mat troi
    public double getSunLongitude(double jdn, double timeZone){
        double T, T2, dr, M, L0, DL, L;

        T = (int) ((jdn - 2451545.5 - timeZone/24) / 36525);
        T2 = T * T;
        dr = PI/180;
        M = 357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2;
        L0 = 280.46645 + 36000.76983 * T + 0.0003032 * T2;
        DL = (1.914600 - 0.004817 * T - 0.000014 * T2) * Math.sin(dr * M);
        DL = DL + (0.019993 - 0.000101 * T)*Math.sin(dr*2*M) + 0.000290 * Math.sin(dr * 3 * M);
        L = L0 * dr;
        L = L * dr;
        L = L - PI * 2 * (Math.floor(L/(PI * 2))); //Math.floor
        return Math.floor(L/PI*6);//Math.floor
    }

     //Tinh ngay bat dau thang 11 am lich
    public double getLunarMonth11(int yy, double timeZone){
        double k, off, nm, sunLong;

        off = jdFromDate(31, 12, yy) - 2415021;
        k = Math.floor(off/29.530588853); //Math.floor
        nm = getNewMoonday(k, timeZone);

        sunLong = getSunLongitude(nm, timeZone);

        if (sunLong >= 9){
            nm = getNewMoonday(k - 1, timeZone);
        }

        return nm;

    }

     //Xac dinh thang nhuan
    public double getLeapMonthOffset(double a11, double timeZone){

        double k, last, arc, i;

        k = Math.floor((a11 - 2415021.076998695) / 29.530588853 + 0.5);//Math.floor

        last = 0;
        i = 1;
        arc = getSunLongitude(getNewMoonday(k+i, timeZone), timeZone);

        do {
            last = arc;
            i++;
            arc = getSunLongitude(getNewMoonday(k+i, timeZone), timeZone);

        } while (arc != last && i < 14);
        return i-1;

    }

     //Doi ngay duong ra ngay am
    public ArrayList<Double> convertSolar2Lunar(int dd,int mm, int yy, double timeZone){

        ArrayList<Double> result = new ArrayList<>();

        double k, dayNumber, monthStart, a11, b11, lunarDay, lunarMonth, lunarYear, lunarLeap, diff;

        lunarDay = 0;
        lunarMonth = 0;
        lunarYear = 0;

        dayNumber = jdFromDate(dd, mm, yy);

        k = Math.floor((dayNumber - 2415021.076998695) / 29.530588853);//Math.floor

        monthStart = getNewMoonday(k+1, timeZone);

        if (monthStart > dayNumber) {

            monthStart = getNewMoonday(k, timeZone);

        }
        a11 = getLunarMonth11(yy, timeZone);
        b11 = a11;

        if (a11 >= monthStart) {

            lunarYear = yy;
            a11 = getLunarMonth11(yy-1, timeZone);

        } else {

            lunarYear = yy+1;
            b11 = getLunarMonth11(yy+1, timeZone);

        }
        lunarDay = dayNumber-monthStart+1;

        diff = Math.floor((monthStart - a11)/29);//Math.floor

        lunarLeap = 0;
        lunarMonth = diff+11;

        if (b11 - a11 > 365) {

            double leapMonthDiff = getLeapMonthOffset(a11, timeZone);
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10;
                if (diff == leapMonthDiff) {
                    lunarLeap = 1;
                }
            }
        }

        if (lunarMonth > 12) {

            lunarMonth = lunarMonth - 12;

        }
        if (lunarMonth >= 11 && diff < 4) {

            lunarYear -= 1;

        }

        result.add(lunarDay);
        result.add(lunarMonth);
        result.add(lunarYear);

        return result;
    }

     //Doi am lich ra duong lich
    public ArrayList<Double> convertLunar2Solar(int lunarDay, int lunarMonth, int lunarYear, int lunarLeap, double timeZone) {

        double k, a11, b11, off, leapOff, leapMonth, monthStart;

        if (lunarMonth < 11) {

            a11 = getLunarMonth11(lunarYear-1, timeZone);
            b11 = getLunarMonth11(lunarYear, timeZone);

        } else {

            a11 = getLunarMonth11(lunarYear, timeZone);
            b11 = getLunarMonth11(lunarYear+1, timeZone);

        }
        off = lunarMonth - 11;
        if (off < 0) {
            off += 12;
        }
        if (b11 - a11 > 365) {

            leapOff = getLeapMonthOffset(a11, timeZone);
            leapMonth = leapOff - 2;

            if (leapMonth < 0) {
                leapMonth += 12;
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                ArrayList<Double> result = new ArrayList<>();
                result.add(0d);
                result.add(0d);
                result.add(0d);

                return result;
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1;
            }
        }
        k = Math.floor(0.5 + (a11 - 2415021.076998695) / 29.530588853);//Math.floor
        monthStart = getNewMoonday(k+off, timeZone);
        return jdToDate(monthStart+lunarDay-1);
    }

     //Ham JdFromDate
    public double jdFromDate(int dd, int mm, int yy){
        double a, y, m, jd;
        a = Math.floor((14 - mm) / 12);//Math.floor
        y = yy+4800-a;
        m = mm+12*a-3;
        jd = dd + Math.floor((153*m+2)/5) + 365*y + Math.floor(y/4) - Math.floor(y/100) + Math.floor(y/400) - 32045;//Math.floor
        if (jd < 2299161) {
            jd = dd + Math.floor((153*m+2)/5) + 365*y + Math.floor(y/4) - 32083;//Math.floor
        }

        return jd;
    }

     //Ham JdToDate
    public ArrayList<Double> jdToDate(double jd){
        double a, b, c, d, e, m, day, month, year;
        if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
            a = jd + 32044;
            b = Math.floor((4*a+3)/146097);//Math.floor
            c = a - Math.floor((b*146097)/4);//Math.floor
        } else {
            b = 0;
            c = jd + 32082;
        }
        d = Math.floor((4*c+3)/1461);//Math.floor
        e = c - Math.floor((1461*d)/4);//Math.floor
        m = Math.floor((5*e+2)/153);//Math.floor
        day = e - Math.floor((153*m+2)/5) + 1;//Math.floor
        month = m + 3 - 12*Math.floor(m/10);//Math.floor
        year = b*100 + d - 4800 + Math.floor(m/10);//Math.floor

        ArrayList<Double> result = new ArrayList<>();
        result.add(day);
        result.add(month);
        result.add(year);

        return result;
    }


}
