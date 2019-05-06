package com.example.administrator.doan_application.baothuc;

import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class ChuongBao implements Serializable {



    public String getsTenChuong() {
        return sTenChuong;
    }

    public void setsTenChuong(String sTenChuong) {
        this.sTenChuong = sTenChuong;
    }

    public String getsDuongDan() {
        return sDuongDan;
    }

    public void setsDuongDan(String sDuongDan) {
        this.sDuongDan = sDuongDan;
    }

    public boolean isCkecked() {
        return isCkecked;
    }

    public void setCkecked(boolean ckecked) {
        isCkecked = ckecked;
    }

    public ChuongBao(String sTenChuong, String sDuongDan, boolean isCkecked) {
        this.sTenChuong = sTenChuong;
        this.sDuongDan = sDuongDan;
        this.isCkecked = isCkecked;
    }

    public ChuongBao()
    {

    }

    String sTenChuong;
    String sDuongDan;

    boolean isCkecked;
}
