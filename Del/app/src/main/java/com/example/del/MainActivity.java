package com.example.del;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor accelerometer;
    TextView textView;
    float lastX, lastY, lastZ;
    long lastTime = 0;
    static final int SHAKE_THRESHOLD = 3; // sensitivity value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "Accelerometer not available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        long currentTime = System.currentTimeMillis();

        // Update text on screen
        textView.setText("X: " + x + "\nY: " + y + "\nZ: " + z);

        // Every 1 second, check if movement is large
        if ((currentTime - lastTime) > 1000) {
            float diff = Math.abs(x - lastX) + Math.abs(y - lastY) + Math.abs(z - lastZ);
            if (diff > SHAKE_THRESHOLD) {
                String movementType = detectMovement(x, y, z);
                saveToFile("Movement: " + movementType + " | X=" + x + " Y=" + y + " Z=" + z + " | Time=" + currentTime);
            }
            lastX = x;
            lastY = y;
            lastZ = z;
            lastTime = currentTime;
        }
    }

    private String detectMovement(float x, float y, float z) {
        // Simple logic for now
        if (Math.abs(z) > 9) return "Standing/Still";
        else if (Math.abs(x) > 5 || Math.abs(y) > 5) return "Walking/Moving";
        else return "Lying/Sitting";
    }

    private void saveToFile(String data) {
        try {
            File folder = new File(getExternalFilesDir(null), "MotionLogs");
            if (!folder.exists()) folder.mkdirs();

            File file = new File(folder, "movement_log.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.append(data + "\n");
            writer.close();

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Save failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
