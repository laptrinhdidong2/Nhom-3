package com.example.rayleigh.multipletouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class SingleTouchEventView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();

    public SingleTouchEventView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Toast.makeText(getContext(), "Test Down", Toast.LENGTH_SHORT).show();
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
//                Toast.makeText(getContext(), "Test Move", Toast.LENGTH_SHORT).show();
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // nothing to do
//                Toast.makeText(getContext(), "Test Up", Toast.LENGTH_SHORT).show();
                path.addCircle(eventX, eventY, 10, Path.Direction.CW);
                break;
            case MotionEvent.ACTION_CANCEL: {
                Toast.makeText(getContext(), "Test CANCE", Toast.LENGTH_SHORT).show();
                path.addCircle(eventX, eventY, 10, Path.Direction.CW);
                break;
            }
            default:
                return false;
        }

        // Schedules a repaint.
        invalidate();
        return true;
    }
}