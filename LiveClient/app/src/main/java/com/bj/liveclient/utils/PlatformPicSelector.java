package com.bj.liveclient.utils;

import com.bj.liveclient.R;
import com.bj.liveclient.common.Store;

/**
 * Date: 2018/10/24
 * Author: NHL
 */
public class PlatformPicSelector {

    public static int Selector(String name) {
        switch (name){
            case Store.LIVE_PANDA:
                return R.drawable.ic_panda;
            case Store.LIVE_BILIBILI:
                return R.drawable.ic_bilibili;
            case Store.LIVE_ZHANQI:
                return R.drawable.ic_zhanqi;
            case Store.LIVE_DOUYU:
                return R.drawable.ic_douyu;
            case Store.LIVE_LONGZHU:
                return R.drawable.ic_longzhu;
            case Store.LIVE_HUOMAO:
                return R.drawable.ic_huomao;
            case Store.LIVE_YIZHIBO:
                return R.drawable.ic_yizhibo;
            case Store.LIVE_TWITCH:
                return R.drawable.ic_twitch;
            case Store.LIVE_HUYA:
                return R.drawable.ic_huya;
            case Store.LIVE_QUANMIN:
                return R.drawable.ic_quanmin;
            case Store.LIVE_CC:
                return R.drawable.ic_cc;
            case Store.LIVE_OPENREC:
                return R.drawable.ic_openrec;
            default:
                return R.drawable.ic_panda;
        }
    }
}
