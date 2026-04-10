package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
Button btn_dial,btn_msg,btn_share,btn_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_dial = findViewById(R.id.dial);
        btn_msg = findViewById(R.id.msg);
        btn_share = findViewById(R.id.Share);
        btn_email = findViewById(R.id.email);
        
        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
//                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: 03470619641"));
                startActivity(iDial);
            }
        });

        btn_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMsg = new Intent();
                iMsg.setAction(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:"+Uri.encode("03470619641")));
                iMsg.putExtra("sms_body","Please solve this issue");
                startActivity(iMsg);
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent();
                iEmail.setAction(Intent.ACTION_SEND);
                iEmail.setType("massage/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"javedsalman56@gmail.com","javedsalman642@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please solve this issue");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare =new Intent();
                iShare.setAction(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download this amazing app from play store, https://play.google.com/store/apps");
                startActivity(Intent.createChooser(iShare,"Share through:"));
            }
        });
    }
}