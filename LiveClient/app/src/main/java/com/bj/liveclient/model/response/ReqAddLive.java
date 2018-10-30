package com.bj.liveclient.model.response;

import java.util.List;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class ReqAddLive {

    private List<LivesBean> lives;

    public List<LivesBean> getLives() {
        return lives;
    }

    public void setLives(List<LivesBean> lives) {
        this.lives = lives;
    }

    public static class LivesBean {
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
}
