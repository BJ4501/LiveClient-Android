package com.bj.liveclient.net;

import android.content.Context;
import android.util.Log;

import com.bj.liveclient.common.Store;
import com.bj.liveclient.model.AppInfo;
import com.bj.liveclient.model.RspModel;
import com.bj.liveclient.utils.PreferencesUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class Net {

    private static final String TAG = "Neko Net";

    public void request(){
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
            }

            @Override
            public void onFailure(Call<RspModel<AppInfo>> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
    }

    public static Api create(Context context){
        String url = PreferencesUtils.getString(context, Store.URL_KEY, "");
        if (url.equals("")){
            url = Store.BASIC_URL;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        Log.d(TAG,"url: " + url);

        return retrofit.create(Api.class);
    }

}
