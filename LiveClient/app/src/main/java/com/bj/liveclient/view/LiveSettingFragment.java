package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bj.liveclient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveSettingFragment extends Fragment {


    public LiveSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_setting, container, false);
    }

}
