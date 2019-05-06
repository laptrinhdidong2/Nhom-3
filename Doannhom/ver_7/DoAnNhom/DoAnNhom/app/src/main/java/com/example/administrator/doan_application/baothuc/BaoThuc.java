package com.example.administrator.doan_application.baothuc;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@SuppressLint("ParcelCreator")
public class BaoThuc implements Serializable, Parcelable {

    protected BaoThuc(Parcel in) {
        sGioHen = in.readString();
        sMoTa = in.readString();
        isChuNhat = in.readByte() != 0;
        isThuHai = in.readByte() != 0;
        isThuBa = in.readByte() != 0;
        isThuTu = in.readByte() != 0;
        isThuNam = in.readByte() != 0;
        isThuSau = in.readByte() != 0;
        isThuBay = in.readByte() != 0;
        isChecked = in.readByte() != 0;
        id = in.readInt();
    }

    public static final Creator<BaoThuc> CREATOR = new Creator<BaoThuc>() {
        @Override
        public BaoThuc createFromParcel(Parcel in) {
            return new BaoThuc(in);
        }

        @Override
        public BaoThuc[] newArray(int size) {
            return new BaoThuc[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //dest.writeValue();
        dest.writeString(sGioHen);
        dest.writeString(sMoTa);
        dest.writeByte((byte) (isChuNhat ? 1 : 0));
        dest.writeByte((byte) (isThuHai ? 1 : 0));
        dest.writeByte((byte) (isThuBa ? 1 : 0));
        dest.writeByte((byte) (isThuTu ? 1 : 0));
        dest.writeByte((byte) (isThuNam ? 1 : 0));
        dest.writeByte((byte) (isThuSau ? 1 : 0));
        dest.writeByte((byte) (isThuBay ? 1 : 0));
        dest.writeByte((byte) (isChecked ? 1 : 0));
        dest.writeInt(id);
    }

    private Color colorSelected;

    public void setColorSelected(Color colorSelected) { this.colorSelected = colorSelected; }

    public Color getColorSelected() { return colorSelected; }

    public String getsGioHen() {
        return sGioHen;
    }

    public void setsGioHen(String sGioHen) {
        this.sGioHen = sGioHen;
    }

    public String getsMoTa() {
        return sMoTa;
    }

    public void setsMoTa(String sMoTa) {
        this.sMoTa = sMoTa;
    }

    public boolean isChuNhat() {
        return isChuNhat;
    }

    public void setChuNhat(boolean chuNhat) {
        isChuNhat = chuNhat;
    }

    public boolean isThuHai() {
        return isThuHai;
    }

    public void setThuHai(boolean thuHai) {
        isThuHai = thuHai;
    }

    public boolean isThuBa() {
        return isThuBa;
    }

    public void setThuBa(boolean thuBa) {
        isThuBa = thuBa;
    }

    public boolean isThuTu() {
        return isThuTu;
    }

    public void setThuTu(boolean thuTu) {
        isThuTu = thuTu;
    }

    public boolean isThuNam() {
        return isThuNam;
    }

    public void setThuNam(boolean thuNam) {
        isThuNam = thuNam;
    }

    public boolean isThuSau() {
        return isThuSau;
    }

    public void setThuSau(boolean thuSau) {
        isThuSau = thuSau;
    }

    public boolean isThuBay() {
        return isThuBay;
    }

    public void setThuBay(boolean thuBay) {
        isThuBay = thuBay;
    }

    public ChuongBao getsChuongBao() {
        return sChuongBao;
    }

    public void setsChuongBao(ChuongBao sChuongBao) {
        this.sChuongBao = sChuongBao;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    String sGioHen;
    String sMoTa;

    public BaoThuc(int id, String sGioHen, String sMoTa, ChuongBao sChuongBao, boolean isChuNhat, boolean isThuHai, boolean isThuBa, boolean isThuTu, boolean isThuNam, boolean isThuSau, boolean isThuBay) {
        this.id = id;
        this.sGioHen = sGioHen;
        this.sMoTa = sMoTa;
        this.isChuNhat = isChuNhat;
        this.isThuHai = isThuHai;
        this.isThuBa = isThuBa;
        this.isThuTu = isThuTu;
        this.isThuNam = isThuNam;
        this.isThuSau = isThuSau;
        this.isThuBay = isThuBay;
        this.sChuongBao = sChuongBao;
    }

    boolean isChuNhat;
    boolean isThuHai;
    boolean isThuBa;
    boolean isThuTu;
    boolean isThuNam;
    boolean isThuSau;
    boolean isThuBay;

    ChuongBao sChuongBao;

    private boolean isChecked;
    private int id;
    private AlarmManager alarmManager;

    public AlarmManager getAlarmManager() {
        return alarmManager;
    }

    public void setAlarmManager(AlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
