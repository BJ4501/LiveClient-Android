package com.bj.liveclient.net;

import android.content.Context;
import android.util.Log;

import com.bj.liveclient.common.Store;
import com.bj.liveclient.utils.PreferencesUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class Net {

    private static final String TAG = "Neko Net";

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
