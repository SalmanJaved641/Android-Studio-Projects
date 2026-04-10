package com.example.fragmentsdatapassing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class status extends Fragment {
private  static final String ARG1= "arg3";
private  static final String ARG2= "arg4";

    public status() {
        // Required empty public constructor
    }

    public static status getInstance(String value1,int value2){

        status status_frag_instance = new status();
        Bundle bundle = new Bundle();
        bundle.putString(ARG1,value1);
        bundle.putInt(ARG2,value2);

        status_frag_instance.setArguments(bundle);
        return status_frag_instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        String name = null;
        int roll_no = 0;
        if (getArguments()!=null) {
            name = getArguments().getString(ARG1);
            roll_no = getArguments().getInt(ARG2);

        }

        View view = inflater.inflate(R.layout.fragment_status, container, false);
        TextView data_from_instance = view.findViewById(R.id.data_from_instance);
        data_from_instance.setText("Name: " + name + ", Roll No: " + roll_no);
        return view;
    }
}