package tdc.edu.vn.gamesensor;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public MainThread thread;

    private SceneManager manager;
    public GamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        thread = new MainThread(getHolder() , this);

        manager = new SceneManager();

        setFocusable(true);
    }



    public void surfaceChanged(SurfaceHolder holder,int format , int width , int height){

    }

    public void surfaceCreated(SurfaceHolder holder){
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch (Exception e){ e.printStackTrace();}
            retry = false;


        }
    }

    public boolean onTouchEvent(MotionEvent event){
        manager.recieveTouch(event);
        return super.onTouchEvent(event);

    }

    public void update()
    {
        manager.update();
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        manager.draw(canvas);
    }

}
