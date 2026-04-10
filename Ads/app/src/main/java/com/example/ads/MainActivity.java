/*
package com.example.ads;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adView=findViewById(R.id.adView);
//step 1
        MobileAds.initialize(this, initializationStatus -> {
            Log.d("AdMobInit", "Mobile Ads SDK initialized.");
        });
//step 2
        AdRequest adRequest = new AdRequest.Builder().build();
//step 3
        adView.loadAd(adRequest);


    }
}*/

package com.example.ads;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Log.d("addebugkarona", "Step 1: Starting AdMob Initialization...");

        MobileAds.initialize(this, initializationStatus -> {
            Log.d("addebugkarona", "Step 1 Done: AdMob SDK Initialized");

            Map<String, AdapterStatus> statusMap = initializationStatus.getAdapterStatusMap();
            for (String adapterClass : statusMap.keySet()) {
                AdapterStatus status = statusMap.get(adapterClass);
                Log.d("addebugkarona", "Adapter: " + adapterClass +
                        ", Description: " + status.getDescription() +
                        ", Latency: " + status.getLatency());
            }

            Log.d("addebugkarona", "Step 2: Finding AdView from layout...");
            adView = findViewById(R.id.adView);

            if (adView == null) {
                Log.e("addebugkarona", "Error: adView is null. Check your XML layout and ID.");
                return;
            }

            Log.d("addebugkarona", "Step 3: Creating AdRequest...");
            AdRequest adRequest = new AdRequest.Builder().build();

            Log.d("addebugkarona", "Step 4: Loading Ad into AdView...");
            adView.loadAd(adRequest);

            Log.d("addebugkarona", "Step 5: Ad request sent. Waiting for ad to load...");
        });
    }
}
