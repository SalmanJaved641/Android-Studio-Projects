package com.example.lightsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements  SensorEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            
            if (lightSensor != null) {
                sensorManager.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
            }else {
                Toast.makeText(this, "Light sensor is not working.", Toast.LENGTH_SHORT).show();
            }

        }else
            Toast.makeText(this, "Sensor manager not working properly.", Toast.LENGTH_SHORT).show();
        

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            ((TextView)(findViewById(R.id.text))).setText("values: "+ sensorEvent.values[0]);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}