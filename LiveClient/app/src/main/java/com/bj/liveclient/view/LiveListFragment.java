package com.bj.liveclient.view;


import android.content.Intent;
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
import com.bj.liveclient.common.Store;
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

    private List<LiveInfo> mData = new ArrayList<>();

    private LiveInfoAdapter mLiveInfoAdapter;

    private RecyclerView mRecyclerView;

    public LiveListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_live_list, container, false);
        mRecyclerView = inflate.findViewById(R.id.rv_list);

        Call<RspModel<List<LiveInfo>>> call = Net.create(getContext()).getLives();

        //发送请求与回调
        call.enqueue(new Callback<RspModel<List<LiveInfo>>>() {
            @Override
            public void onResponse(Call<RspModel<List<LiveInfo>>> call, Response<RspModel<List<LiveInfo>>> response) {
                if(response.body() != null){
                    Log.d(TAG,response.body().getData().toString());
                    mData = response.body().getData();
                }
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                mLiveInfoAdapter = new LiveInfoAdapter(mData, getContext());
                mLiveInfoAdapter.setmOnItemClickListener(new LiveInfoAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        liveClick(position);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        liveLongClick(position);
                    }
                });
                mRecyclerView.setAdapter(mLiveInfoAdapter);
            }

            @Override
            public void onFailure(Call<RspModel<List<LiveInfo>>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });

        return inflate;
    }

    /**
     * 短按可选择是否监听
     * @param position
     */
    private void liveClick(int position) {
        String id = mData.get(position).getId();
        boolean listening = mData.get(position).isListening();
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
                        if (response.body().getErr_no() == Store.RSP_OK){
                            mData.set(position, response.body().getData());
                            mLiveInfoAdapter.setDataList(mData);
                        }else {
                            Toast.makeText(getContext(), "关闭监听失败，请重试", Toast.LENGTH_SHORT).show();
                        }
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
                        if (response.body().getErr_no() == Store.RSP_OK){
                            mData.set(position, response.body().getData());
                            mLiveInfoAdapter.setDataList(mData);
                        }else {
                            Toast.makeText(getContext(), "开启监听失败，请重试", Toast.LENGTH_SHORT).show();
                        }
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

    /**
     * 当被长点击的时候可以选择删除
     * @param position
     */
    private void liveLongClick(int position) {
        String id = mData.get(position).getId();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("LiveClient");
        builder.setMessage("是否要删除当前直播间?");
        builder.setPositiveButton("OK", (dialogInterface, i) -> {
            Call<RspModel> call = Net.create(getContext()).deleteById(id);
            call.enqueue(new Callback<RspModel>() {
                @Override
                public void onResponse(Call<RspModel> call, Response<RspModel> response){
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    if (response.body().getErr_no() == Store.RSP_OK){
                        mData.remove(position);
                        mLiveInfoAdapter.setDataList(mData);
                    }else {
                        Toast.makeText(getContext(), "删除失败，请重试", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RspModel> call, Throwable t) {

                }
            });
        });
        builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
            //do nothing
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        boolean flag = bundle.getBoolean("refresh");
        if(flag){
            refreshList();
        }
    }

    //列表刷新
    private void refreshList() {
        Net.create(getContext()).getLives().enqueue(new Callback<RspModel<List<LiveInfo>>>() {
            @Override
            public void onResponse(Call<RspModel<List<LiveInfo>>> call, Response<RspModel<List<LiveInfo>>> response) {
                if(response.body() != null){
                    Log.d(TAG,"refresh : " + response.body().getData().toString());
                    mData = response.body().getData();
                }
                mLiveInfoAdapter.setDataList(mData);
            }

            @Override
            public void onFailure(Call<RspModel<List<LiveInfo>>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
