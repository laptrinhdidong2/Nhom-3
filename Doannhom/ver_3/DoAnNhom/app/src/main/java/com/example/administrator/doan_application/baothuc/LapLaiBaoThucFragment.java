package com.example.administrator.doan_application.baothuc;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.doan_application.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LapLaiBaoThucFragment extends Fragment {


    public LapLaiBaoThucFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lap_lai_bao_thuc, container, false);
    }

}
