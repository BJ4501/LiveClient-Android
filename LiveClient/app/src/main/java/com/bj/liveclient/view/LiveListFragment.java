package com.bj.liveclient.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bj.liveclient.R;
import com.bj.liveclient.adapter.LiveInfoAdapter;
import com.bj.liveclient.model.response.LiveInfo;
import com.bj.liveclient.model.response.RspModel;
import com.bj.liveclient.net.Net;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                LiveInfoAdapter liveInfoAdapter = new LiveInfoAdapter(data, getContext());
                liveInfoAdapter.setmOnItemClickListener((view, position) -> {
                    liveClick(position);
                });
                recyclerView.setAdapter(liveInfoAdapter);
            }

            @Override
            public void onFailure(Call<RspModel<List<LiveInfo>>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

        return inflate;
    }

    private void liveClick(int position) {
        String id = data.get(position).getId();
        boolean listening = data.get(position).isListening();
        String msg;
        if(listening){
            msg = "取消监听该直播间?";
        }else {
            msg = "开启监听该直播间?";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("LiveClient");
        builder.setMessage(msg);
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            if(listening){
                //关闭请求
                Call<RspModel<LiveInfo>> call = Net.create(getContext()).stopListenById(id);
                call.enqueue(new Callback<RspModel<LiveInfo>>() {
                    @Override
                    public void onResponse(Call<RspModel<LiveInfo>> call, Response<RspModel<LiveInfo>> response) {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();

                        //刷新RV 替换datalist 并 notifychanged
                    }

                    @Override
                    public void onFailure(Call<RspModel<LiveInfo>> call, Throwable t) {

                    }
                });
            }else {
                //开启请求
                Call<RspModel<LiveInfo>> call = Net.create(getContext()).startListenById(id);
                call.enqueue(new Callback<RspModel<LiveInfo>>() {
                    @Override
                    public void onResponse(Call<RspModel<LiveInfo>> call, Response<RspModel<LiveInfo>> response) {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RspModel<LiveInfo>> call, Throwable t) {

                    }
                });
            }
        });
        builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
            //do nothing
        });
        builder.show();
    }

}
