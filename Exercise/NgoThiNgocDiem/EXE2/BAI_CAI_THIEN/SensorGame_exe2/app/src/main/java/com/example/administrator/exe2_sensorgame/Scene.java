package com.example.administrator.exe2_sensorgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Scene {
    public void update();
    public void draw(Canvas canvas);
    public void terminate();

    public void receiveTouch(MotionEvent motionEvent);
}
