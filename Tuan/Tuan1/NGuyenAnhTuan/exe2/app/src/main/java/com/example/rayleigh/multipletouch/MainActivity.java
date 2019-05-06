package com.example.rayleigh.multipletouch;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {
    ImageView img;
    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;
    int local_x = 0, local_y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView);
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);
//        int headerLayoutHeight = main.get;
        layoutParams = (RelativeLayout.LayoutParams)img.getLayoutParams();
//        layoutParams.topMargin = 52;
        img.setLayoutParams(layoutParams);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);

                v.startDrag(dragData,myShadow,null,0);
                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch(event.getAction())
                {
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        local_x = x_cord - v.getWidth()/2;
                        local_y = y_cord -  v.getHeight()/2 - 76;
                        layoutParams.leftMargin = local_x;
                        layoutParams.topMargin = local_y;
                        v.setLayoutParams(layoutParams);

                        Log.d(msg, "View - X-Y " + (int) v.getX() + ", " + (int) v.getY());
                        Log.d(msg, "X-Y" + x_cord + ", " + y_cord);
                        Log.d(msg, "Local X-Y" + local_x + ", " + local_y);

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED :
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY() - 76;
                        layoutParams.leftMargin = x_cord;
                        layoutParams.topMargin = y_cord;
                        v.setLayoutParams(layoutParams);
                        Log.d(msg, "View2 - X-Y  " + (int) v.getX() + ", " + (int) v.getY());
                        Log.d(msg, "X-Y  " + x_cord + ", " + y_cord);

                        break;

                    case DragEvent.ACTION_DRAG_LOCATION  :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord = (int) event.getX() - v.getWidth()/2;
                        y_cord = (int) event.getY() - v.getHeight()/2;
                        layoutParams.leftMargin = (int) v.getX() + (x_cord);
                        layoutParams.topMargin = (int) v.getY() + (y_cord);
                        v.setLayoutParams(layoutParams);
                        v.setAlpha(1);

                        Log.d(msg, "View - X-Y" + (int) v.getX() + ", " + (int) v.getY());
                        Log.d(msg, "X-Y" + x_cord + ", " + y_cord);

                        break;

                    case DragEvent.ACTION_DRAG_ENDED   :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                        v.setAlpha(1);

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event");
                        v.setAlpha(1);
                        // Do nothing
                        break;
                    default: break;
                }
                return true;
            }
        });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

                    img.startDrag(data, shadowBuilder, img, 0);
//                    v.setAlpha(0);
//                    img.setVisibility(View.INVISIBLE);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}