package com.bj.liveclient.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bj.liveclient.R;
import com.bj.liveclient.model.LiveInfo;

import java.util.List;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class LiveInfoAdapter extends RecyclerView.Adapter<LiveInfoAdapter.ViewHolder> {

    private List<LiveInfo> mLiveInfoList;

    private Context mContext;

    public LiveInfoAdapter(List<LiveInfo> mLiveInfoList, Context mContext) {
        this.mLiveInfoList = mLiveInfoList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_live_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.roomName.setText(mLiveInfoList.get(position).getRoom_name());
        holder.roomStatus.setText(mLiveInfoList.get(position).getPlatform_cn_name());
    }

    @Override
    public int getItemCount() {
        return mLiveInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView roomName;
        TextView roomStatus;
        public ViewHolder(View itemView) {
            super(itemView);
            roomName = itemView.findViewById(R.id.tv_room_name);
            roomStatus = itemView.findViewById(R.id.tv_room_status);
        }
    }
}
