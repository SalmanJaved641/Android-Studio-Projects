package com.example.anmations;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
TextView txtAnim;
Button btnmove,btnscale,btnalpha,btnrotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         txtAnim = findViewById(R.id.txtAnim);

         btnmove= findViewById(R.id.btnmove);
         btnscale = findViewById(R.id.btnscale);
         btnrotate = findViewById(R.id.btnrotate);
         btnalpha = findViewById(R.id.btnalpha);

         btnmove.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Animation move= AnimationUtils.loadAnimation(MainActivity.this,R.anim.move);
                 txtAnim.setAnimation(move);
             }
         });
         btnalpha.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Animation alpha= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);
                 txtAnim.setAnimation(alpha);
             }
         });
         btnscale.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Animation scale= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
                 txtAnim.setAnimation(scale);
             }
         });
         btnrotate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Animation rotate= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                 txtAnim.setAnimation(rotate);
             }
         });


         }
}
/*ctrl + space : to see suggestion in " "*/