package com.example.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ImageView img;
Button btn,btn2;
private final int CAMERA_REQ_CODE = 100;   //to make difference in camera and gallery etc outputs requests
private final int GALLERY_REQ_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.image);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera,CAMERA_REQ_CODE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) { //it tells that result is ok and means user do not back the camera app and click pic
            if (requestCode == CAMERA_REQ_CODE) {

                Bitmap imgBitmap = (Bitmap)(data.getExtras().get("data"));  //"data" is key for bitmap return type bundles.
                img.setImageBitmap(imgBitmap);

            }
            if (requestCode == GALLERY_REQ_CODE) {

                img.setImageURI(data.getData());
            }
        }
    }
}