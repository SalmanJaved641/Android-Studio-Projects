package com.example.dinamicjassonparsingget;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://jsonplaceholder.typicode.com/todos/1/users"; //Get Api
        ArrayList<String>arrNames = new ArrayList<>();
        ListView listview = findViewById(R.id.listView);


        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.d("RESPONSE", response.toString());
//                        RESPONSE Parsing:
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);//write index number
                                // of object of array you want from jason array
                                String name = jsonObject.getString("name");
                                String username = jsonObject.getString("username");

                                arrNames.add(name+", "+username);

                            }

                            ArrayAdapter<String>arrayAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrNames);
                            listview.setAdapter(arrayAdapter);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                        anError.getStackTrace();
                        Log.e("ERROR", anError.toString());
                    }
                });
    }
}