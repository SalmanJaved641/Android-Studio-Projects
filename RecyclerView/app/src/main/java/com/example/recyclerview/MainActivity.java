package com.example.recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ContectModel> arrayContect = new ArrayList<>();
    RecyclerContectAdapter adapter;
    FloatingActionButton btnOpenDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleContects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnOpenDialog = findViewById(R.id.floating_button);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtname = dialog.findViewById(R.id.edtname);
                EditText edtnumber = dialog.findViewById(R.id.edtnumber);/*edtname and edtnumber */
                Button btnaction = dialog.findViewById(R.id.btnaction);

                btnaction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        if (!edtname.getText().toString().equals("") | !edtnumber.getText().toString().equals("")) {
                            name = edtname.getText().toString();
                            number = edtnumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "Please Enter both contect Name and Number", Toast.LENGTH_LONG).show();
                        }
                        arrayContect.add(new ContectModel(R.drawable.c,name,number));
                        adapter.notifyItemInserted(arrayContect.size()-1);
                        recyclerView.scrollToPosition(arrayContect.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.shanza,"APS","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));

        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.shanza,"APS","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));

        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.f,"fahad","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.h,"iqbal","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.a,"Salman","0347 0619641"));
        arrayContect.add(new ContectModel(R.drawable.b,"hamza","0343 0987461"));
        arrayContect.add(new ContectModel(R.drawable.c,"ali","0347 8739461"));
        arrayContect.add(new ContectModel(R.drawable.d,"abdullah","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.e,"M Ali","0347 0092361"));
        arrayContect.add(new ContectModel(R.drawable.shanza,"APS","0347 0619461"));
        arrayContect.add(new ContectModel(R.drawable.g,"javed","0347 0619461"));
        RecyclerContectAdapter obj1 = new RecyclerContectAdapter(MainActivity.this,arrayContect);
        int lastPosition = obj1.lastPosition();
        String a = String.valueOf(lastPosition);
        arrayContect.add(new ContectModel(R.drawable.b,"Last position",a));


        adapter = new RecyclerContectAdapter(this,arrayContect);

        recyclerView.setAdapter(adapter);

    }
}