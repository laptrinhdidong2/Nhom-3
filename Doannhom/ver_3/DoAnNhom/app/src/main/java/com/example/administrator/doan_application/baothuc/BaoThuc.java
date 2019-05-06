package com.example.administrator.doan_application.baothuc;

import android.graphics.Color;

import java.io.Serializable;

public class BaoThuc implements Serializable {

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

    public BaoThuc(String sGioHen, String sMoTa, ChuongBao sChuongBao, boolean isChuNhat, boolean isThuHai, boolean isThuBa, boolean isThuTu, boolean isThuNam, boolean isThuSau, boolean isThuBay) {
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
}
