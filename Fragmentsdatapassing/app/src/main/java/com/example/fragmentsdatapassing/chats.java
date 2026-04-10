package com.example.fragmentsdatapassing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class chats extends Fragment {

    public chats() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//recieve data
        String name = null;
        int roll_no = 0;
        if (getArguments()!=null) {
            name = getArguments().getString("Arg1");
            roll_no = getArguments().getInt("Arg2");


        }

//        show data in screen
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        TextView txt_data = view.findViewById(R.id.txt_data);
        txt_data.setText(name+ " " +roll_no+".");

//        show data in logcat
        Log.d("dataFromActivity", "name: "+name+"Roll no: "+roll_no);

        return view;
    }
}