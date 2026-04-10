package com.example.animationlottie;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* lottieV.setAnimation(R.raw.lottieanimation);
        lottieV.playAnimation();
        lottieV.loop(true);you can also set play animation in java in onCreate or onClick method by defining its id*/

    }
}