package com.example.capstone.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.capstone.R;

public class SettingsFragment extends Fragment {

    View v;
    RadioButton rbPublic;
    RadioButton rbON;

    public SettingsFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_settings, container, false);

        rbPublic = v.findViewById(R.id.rbThin);
        rbON = v.findViewById(R.id.rbON);

        rbPublic.setChecked(true);
        rbON.setChecked(true);

        rbPublic.setSelected(true);
        rbON.setSelected(true);
        return v;
    }
}
