package com.bj.liveclient.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.bj.liveclient.R;
import com.bj.liveclient.model.response.LiveInfo;
import com.bj.liveclient.utils.PlatformPicSelector;

import java.util.List;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class LiveInfoAdapter extends RecyclerView.Adapter<LiveInfoAdapter.ViewHolder> {

    private List<LiveInfo> mLiveInfoList;

    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

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
        holder.roomLogo.setImageDrawable(mContext.getResources().getDrawable(
                PlatformPicSelector.Selector(mLiveInfoList.get(position).getPlatform_cn_name())));
        holder.roomName.setText(mLiveInfoList.get(position).getRoom_name());
        holder.platformName.setText(mLiveInfoList.get(position).getPlatform_cn_name());
        holder.liveUrl.setText(mLiveInfoList.get(position).getLive_url());
        holder.hostName.setText(mLiveInfoList.get(position).getHost_name());

        if (mLiveInfoList.get(position).isStatus()){
            holder.btnStatus.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
        }else {
            holder.btnStatus.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
        }

        if (mLiveInfoList.get(position).isListening()){
            holder.btnListening.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
        }else {
            holder.btnListening.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
        }

        if (mLiveInfoList.get(position).isRecoding()){
            holder.btnRecording.setBootstrapBrand(DefaultBootstrapBrand.SUCCESS);
        }else {
            holder.btnRecording.setBootstrapBrand(DefaultBootstrapBrand.REGULAR);
        }

        holder.cardView.setOnClickListener(view -> {
            mOnItemClickListener.onItemClick(view, position);
        });

    }

    @Override
    public int getItemCount() {
        return mLiveInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView roomLogo;
        TextView liveUrl;
        TextView platformName;
        TextView roomName;
        TextView hostName;
        BootstrapButton btnStatus;
        BootstrapButton btnListening;
        BootstrapButton btnRecording;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_live_room);
            roomLogo = itemView.findViewById(R.id.iv_room_logo);
            liveUrl = itemView.findViewById(R.id.tv_live_url);
            platformName = itemView.findViewById(R.id.tv_platform_name);
            roomName = itemView.findViewById(R.id.tv_room_name);
            hostName = itemView.findViewById(R.id.tv_host_name);
            btnStatus = itemView.findViewById(R.id.btn_status);
            btnListening = itemView.findViewById(R.id.btn_listening);
            btnRecording = itemView.findViewById(R.id.btn_record);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public OnItemClickListener getmOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
