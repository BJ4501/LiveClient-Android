package com.bj.liveclient.model;

/**
 *
 * Date: 2018/10/23
 * Author: NHL
 */
public class AppInfo {

    /**
     * app_name : BiliLive-go
     * app_version : 0.22.7-2-gd853192
     * build_time : 2018-08-01_21:58:04
     * git_hash : d853192083ed880998175ba60eb528f5e1ded0e5
     * pid : 44783
     * platform : darwin/amd64
     * go_version : go1.10.3
     */

    private String app_name;
    private String app_version;
    private String build_time;
    private String git_hash;
    private int pid;
    private String platform;
    private String go_version;

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getBuild_time() {
        return build_time;
    }

    public void setBuild_time(String build_time) {
        this.build_time = build_time;
    }

    public String getGit_hash() {
        return git_hash;
    }

    public void setGit_hash(String git_hash) {
        this.git_hash = git_hash;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGo_version() {
        return go_version;
    }

    public void setGo_version(String go_version) {
        this.go_version = go_version;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "app_name='" + app_name + '\'' +
                ", app_version='" + app_version + '\'' +
                ", build_time='" + build_time + '\'' +
                ", git_hash='" + git_hash + '\'' +
                ", pid=" + pid +
                ", platform='" + platform + '\'' +
                ", go_version='" + go_version + '\'' +
                '}';
    }
}
