package com.bj.liveclient.net;

import com.bj.liveclient.model.response.AppInfo;
import com.bj.liveclient.model.response.ConfigInfo;
import com.bj.liveclient.model.response.LiveInfo;
import com.bj.liveclient.model.response.RspModel;
import com.bj.liveclient.model.request.Live;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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

    //根据Id查询直播间信息
    @GET("/lives/{id}")
    Call<RspModel<LiveInfo>> getLiveById(@Path("id")int id);

    //添加直播间
    @POST("/lives")
    Call<RspModel<LiveInfo>> addLive(@Body List<Live> liveList);

    //根据id删除直播间
    @DELETE("/lives/{id}")
    Call<RspModel> deleteById(@Path("id")int id);

    //开启对{id}房间的监听
    @GET("/lives/{id}/start")
    Call<RspModel<LiveInfo>> startListenById(@Path("id")String id);

    //停止对{id}房间的监听
    @GET("/lives/{id}/stop")
    Call<RspModel<LiveInfo>> stopListenById(@Path("id")String id);

    //配置项信息
    @GET("/config")
    Call<RspModel<ConfigInfo>> getConfigInfo();

    //Save lives info to config file
    @PUT("/config")
    Call<RspModel> saveLivesInfo();

    //Test：Basic file Server
    @GET("/files")
    Call<RspModel> getFiles();

}
