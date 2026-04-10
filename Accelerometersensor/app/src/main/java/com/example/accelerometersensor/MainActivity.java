package com.example.accelerometersensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= findViewById(R.id.textV);
        SensorManager sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if (acceleroSensor != null) {
                sensorManager.registerListener(this,acceleroSensor,SensorManager.SENSOR_DELAY_NORMAL);
            }else {
                Toast.makeText(this, "Accelerometer not Responding.", Toast.LENGTH_SHORT).show();
            }
            
        }else {

            Toast.makeText(this, "Sensor Servicce not detected", Toast.LENGTH_SHORT).show();
        }
        }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {

            String x = String.format("%.0f", sensorEvent.values[0]);
            String y = String.format("%.0f", sensorEvent.values[1]);
            String z = String.format("%.0f", sensorEvent.values[2]);

            text.setText("X: " + x + "\nY: " + y + "\nZ: " + z);
        }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}