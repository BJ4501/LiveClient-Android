package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bj.liveclient.R;
import com.bj.liveclient.common.Store;
import com.bj.liveclient.model.AppInfo;
import com.bj.liveclient.model.RspModel;
import com.bj.liveclient.net.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        // Inflate the layout for this fragment
        final TextView textView = inflate.findViewById(R.id.tv_msg);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Store.IP + ":" + Store.PORT)
                .build();

        Api request = retrofit.create(Api.class);
        Call<RspModel<AppInfo>> call = request.getAppInfo();

        //发送请求与回调
        call.enqueue(new Callback<RspModel<AppInfo>>() {
            @Override
            public void onResponse(Call<RspModel<AppInfo>> call, Response<RspModel<AppInfo>> response) {
                Log.d(TAG,response.body().getData().toString());
                textView.setText(response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<RspModel<AppInfo>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
        return inflate;
    }

}
