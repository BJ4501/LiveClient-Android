package com.bj.liveclient.model.request;

/**
 * Date: 2018/10/30
 * Author: NHL
 */
public class Live {

    /**
     * url : https://www.douyu.com/6655
     * listen : true
     */

    private String url;
    private boolean listen;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isListen() {
        return listen;
    }

    public void setListen(boolean listen) {
        this.listen = listen;
    }
}
