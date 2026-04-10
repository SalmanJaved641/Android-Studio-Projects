package com.example.proximitysensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
TextView txt_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_value=findViewById(R.id.txt_value);

        SensorManager sensorManeger = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManeger != null) {
            Sensor proxmitySensor = sensorManeger.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if (proxmitySensor != null) {
                sensorManeger.registerListener(this, proxmitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_PROXIMITY) {
            ((TextView) txt_value).setText(" "+ sensorEvent.values[0]);
            if (sensorEvent.values[0]<1){
                txt_value.setTextColor(getColor(R.color.red));
                Toast.makeText(this, "Object is near.", Toast.LENGTH_SHORT).show();
            }else {
                txt_value.setTextColor(getColor(R.color.green));
                Toast.makeText(this, "Object is far.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}