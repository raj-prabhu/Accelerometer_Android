package com.example.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class accelerometer extends AppCompatActivity implements SensorEventListener {

    private TextView ax,ay,az;
    private Sensor accelerometer;
    private SensorManager s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sensormanager creating
        s=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //assign our sensor to type accelerometer
        accelerometer=s.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //registrying our sensorManager to listener
        s.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        //linking views
        ax=findViewById(R.id.x_value);
        ay=findViewById(R.id.y_value);
        az=findViewById(R.id.z_value);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //here we will asign event values to our output view
        ax.setText("x: "+event.values[0]);
        ay.setText("y: "+event.values[1]);
        az.setText("z: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
