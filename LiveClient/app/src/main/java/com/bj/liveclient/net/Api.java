package com.bj.liveclient.net;

import com.bj.liveclient.model.AppInfo;
import com.bj.liveclient.model.LiveInfo;
import com.bj.liveclient.model.RspModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public interface Api {

    //录播机状态信息
    @GET("/info")
    Call<RspModel<AppInfo>> getAppInfo();

    //直播列表信息
    @GET("/lives")
    Call<RspModel<List<LiveInfo>>> getLives();

}
