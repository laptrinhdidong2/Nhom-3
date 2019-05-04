package com.example.administrator.doan_application.baothuc;

import android.app.AlarmManager;

public class BaoThucWrapper {
    private BaoThuc baoThuc;
    private AlarmManager alarmManager;

    public BaoThucWrapper() {}

    public BaoThucWrapper(BaoThuc baoThuc, AlarmManager alarmManager) {
        this.baoThuc = baoThuc;
        this.alarmManager = alarmManager;
    }

    public BaoThuc getBaoThuc() {
        return baoThuc;
    }

    public void setBaoThuc(BaoThuc baoThuc) {
        this.baoThuc = baoThuc;
    }

    public AlarmManager getAlarmManager() {
        return alarmManager;
    }

    public void setAlarmManager(AlarmManager alarmManager) {
        this.alarmManager = alarmManager;
    }
}
