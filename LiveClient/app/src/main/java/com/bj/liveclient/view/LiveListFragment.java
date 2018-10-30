package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bj.liveclient.MainActivity;
import com.bj.liveclient.R;
import com.bj.liveclient.adapter.LiveInfoAdapter;
import com.bj.liveclient.common.Store;
import com.bj.liveclient.model.AppInfo;
import com.bj.liveclient.model.LiveInfo;
import com.bj.liveclient.model.RspModel;
import com.bj.liveclient.net.Api;
import com.bj.liveclient.net.Net;
import com.bj.liveclient.utils.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 直播信息列表
 * A simple {@link Fragment} subclass.
 */
public class LiveListFragment extends Fragment {

    private static final String TAG = "LiveListFragment";

    private List<LiveInfo> data = new ArrayList<>();

    public LiveListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_live_list, container, false);
        // Inflate the layout for this fragment
        final RecyclerView recyclerView = inflate.findViewById(R.id.rv_list);
        String url = PreferencesUtils.getString(inflate.getContext(), Store.URL_KEY, "");
        if (url.equals("")){
            url = Store.BASIC_URL;
        }

/*        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        final Api request = retrofit.create(Api.class);*/



//        Call<RspModel<List<LiveInfo>>> call = request.getLives();

        Call<RspModel<List<LiveInfo>>> call = Net.create(getContext()).getLives();

        //发送请求与回调
        call.enqueue(new Callback<RspModel<List<LiveInfo>>>() {
            @Override
            public void onResponse(Call<RspModel<List<LiveInfo>>> call, Response<RspModel<List<LiveInfo>>> response) {
                if(response.body() != null){
                    Log.d(TAG,response.body().getData().toString());
                    data = response.body().getData();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new LiveInfoAdapter(data, getContext()));
            }

            @Override
            public void onFailure(Call<RspModel<List<LiveInfo>>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

        return inflate;
    }

}
