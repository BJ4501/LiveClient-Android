package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bj.liveclient.R;
import com.bj.liveclient.common.Store;
import com.bj.liveclient.utils.PreferencesUtils;

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
        View view = inflater.inflate(R.layout.fragment_live_setting, container, false);

        EditText editText = view.findViewById(R.id.et_url);
        Button button = view.findViewById(R.id.btn_save);
        button.setOnClickListener(view1 -> {
            String s = editText.getText().toString();
            if (s.equals("")){
                Toast.makeText(getContext(), "Not a URL", Toast.LENGTH_SHORT).show();
            }else {
                PreferencesUtils.putString(view.getContext(), Store.URL_KEY, s);
            }
        });
        return view;
    }

}
