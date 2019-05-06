package com.example.ngocdiem.notedemo;

import android.app.Activity;
import android.content.Intent;

public class ThemeManage {

    public static int sTheme = 0;

    public final static int MyTheme = 0 ;
    public final static int MyTheme1 = 1;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case MyTheme:
                activity.setTheme(R.style.MyTheme);
                break;
            case MyTheme1:
                activity.setTheme(R.style.MyTheme1);
                break;
        }
    }

}
