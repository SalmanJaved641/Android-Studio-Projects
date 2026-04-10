package com.example.redcombalarm;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.redcombalarm.AddAlarmActivity;
import com.example.redcombalarm.R;

public class AlarmFragment extends Fragment {
    private Button btnAddAlarm;

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);
        btnAddAlarm = v.findViewById(R.id.btn_add_alarm);
        btnAddAlarm.setOnClickListener(view ->
                startActivity(new Intent(getActivity(), AddAlarmActivity.class))
        );
        return v;
    }
}
