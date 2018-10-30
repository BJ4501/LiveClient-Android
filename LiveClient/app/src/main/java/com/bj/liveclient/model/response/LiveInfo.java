package com.bj.liveclient.model.response;

/**
 * Date: 2018/10/23
 * Author: NHL
 */
public class LiveInfo {

    /**
     * id : 94d6fe233dc6f184d3dd78b6a73ee571
     * live_url : https://live.bilibili.com/1010
     * platform_cn_name : 哔哩哔哩
     * host_name : KB呆又呆
     * room_name : 老菊蚊香初体验【KBDYD】
     * status : true
     * listening : true
     * recoding : true
     */

    private String id;
    private String live_url;
    private String platform_cn_name;
    private String host_name;
    private String room_name;
    private boolean status;
    private boolean listening;
    private boolean recoding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLive_url() {
        return live_url;
    }

    public void setLive_url(String live_url) {
        this.live_url = live_url;
    }

    public String getPlatform_cn_name() {
        return platform_cn_name;
    }

    public void setPlatform_cn_name(String platform_cn_name) {
        this.platform_cn_name = platform_cn_name;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isListening() {
        return listening;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    public boolean isRecoding() {
        return recoding;
    }

    public void setRecoding(boolean recoding) {
        this.recoding = recoding;
    }

    @Override
    public String toString() {
        return "LiveInfo{" +
                "id='" + id + '\'' +
                ", live_url='" + live_url + '\'' +
                ", platform_cn_name='" + platform_cn_name + '\'' +
                ", host_name='" + host_name + '\'' +
                ", room_name='" + room_name + '\'' +
                ", status=" + status +
                ", listening=" + listening +
                ", recoding=" + recoding +
                '}';
    }
}
