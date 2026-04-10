package com.example.mymap;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    int clickCount = 0;
    private GoogleMap mMap;
    Button btnChangeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap  googleMap) {

        mMap = googleMap;
        LatLng latLng =new LatLng(31.37453122555327, 73.66406709107731);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("My Home");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,11f));
        Log.d("mMap", "Map is Ready");


//        add circle overlay
        mMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(1000)
                .fillColor(Color.CYAN)
                .strokeColor(Color.MAGENTA));

//        changeMapType
        btnChangeMap = findViewById(R.id.btnChangeMapType);
        btnChangeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMapType();
            }
        });

//        set geocoder
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                mMap.addMarker(new MarkerOptions().position(latLng));

                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    ArrayList<Address> arradr =  (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude,1);

                    if (arradr != null && !arradr.isEmpty()) {
                        Log.d("Adr", arradr.get(0).getAddressLine(0));
                        Toast.makeText(getApplicationContext(), arradr.get(0).getAddressLine(0), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "No address found for this location", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
//                    throw new RuntimeException(e);
                    Toast.makeText(getApplicationContext(), "Failed to get address: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    changeMapType function

    private void changeMapType() {
        clickCount++;

        // Check the current click count and change the map type
        switch (clickCount) {
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);  // Third click - Satellite map
                Toast.makeText(getApplicationContext(), "Map Type: Satellite", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);  // First click - Normal map
                Toast.makeText(getApplicationContext(), "Map Type: Normal", Toast.LENGTH_SHORT).show();
                break;

        }

        if (clickCount == 2) {
            clickCount = 0;
        }
    }

}