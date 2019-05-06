package com.example.administrator.exe2_sensorgame;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import javax.sql.StatementEvent;
import javax.sql.StatementEventListener;

public class OrientationData implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor magnometor;

    private float[] accelOutput;
    private float[] magOutput;

    private float[] orientation = new float[3];

    public float[] getOrientation(){
        return orientation;
    }

    private float[] startOrientation = null;
    public float[] getStartOrientation(){
        return startOrientation;
    }

    public void newGame(){
        startOrientation = null;

    }

    public OrientationData(){
        sensorManager = (SensorManager)Constants.CURRENT_CONTEXT.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnometor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void register(){
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this, magnometor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void pause(){
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelOutput = event.values;
        }
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magOutput = event.values;
        }
        if (accelOutput != null && magOutput != null){
             float[] R = new float[9];
             float[] I = new float[9];

             boolean success = SensorManager.getRotationMatrix(R, I, accelOutput, magOutput);

             if (success){
                 SensorManager.getOrientation(R, orientation);
                 if (startOrientation == null){
                     startOrientation = new float[orientation.length];
                     System.arraycopy(orientation, 0, startOrientation, 0, orientation.length);

                 }
             }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
