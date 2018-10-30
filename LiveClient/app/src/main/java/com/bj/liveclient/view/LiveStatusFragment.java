package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bj.liveclient.R;
import com.bj.liveclient.model.response.AppInfo;
import com.bj.liveclient.model.response.RspModel;
import com.bj.liveclient.net.Net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 录播机状态
 * A simple {@link Fragment} subclass.
 */
public class LiveStatusFragment extends Fragment {

    private static final String TAG = "LiveStatusFragment";

    public LiveStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_live_status, container, false);
        //Status Item
        TextView appName = inflate.findViewById(R.id.tv_app_name);
        TextView appVersion = inflate.findViewById(R.id.tv_app_version);
        TextView buildTime = inflate.findViewById(R.id.tv_build_time);
        TextView pid = inflate.findViewById(R.id.tv_pid);
        TextView platform = inflate.findViewById(R.id.tv_platform);
        TextView goVersion = inflate.findViewById(R.id.tv_go_version);

        Call<RspModel<AppInfo>> call = Net.create(getContext()).getAppInfo();

        //发送请求与回调
        call.enqueue(new Callback<RspModel<AppInfo>>() {
            @Override
            public void onResponse(Call<RspModel<AppInfo>> call, Response<RspModel<AppInfo>> response) {
                if(response.body() != null){
                    Log.d(TAG,response.body().getData().toString());
                    appName.setText(response.body().getData().getApp_name());
                    appVersion.setText(response.body().getData().getApp_version());
                    buildTime.setText(response.body().getData().getBuild_time());
                    pid.setText(String.valueOf(response.body().getData().getPid()));
                    platform.setText(response.body().getData().getPlatform());
                    goVersion.setText(response.body().getData().getGo_version());
                }
            }

            @Override
            public void onFailure(Call<RspModel<AppInfo>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
        return inflate;
    }

}
