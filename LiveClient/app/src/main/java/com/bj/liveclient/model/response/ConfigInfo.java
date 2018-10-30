package com.bj.liveclient.model.response;

import java.util.List;

/**
 * Date: 2018/10/30
 * Author: NHL
 */
public class ConfigInfo {


    /**
     * RPC : {"Enable":true,"Port":"127.0.0.1:8080","Token":"","TLS":{"Enable":false,"CertFile":"","KeyFile":""}}
     * Debug : true
     * Interval : 15
     * OutPutPath : /Users/chigusa/Movies
     * LiveRooms : ["https://www.panda.tv/10300","https://live.bilibili.com/1010"]
     */

    private RPCBean RPC;
    private boolean Debug;
    private int Interval;
    private String OutPutPath;
    private List<String> LiveRooms;

    public RPCBean getRPC() {
        return RPC;
    }

    public void setRPC(RPCBean RPC) {
        this.RPC = RPC;
    }

    public boolean isDebug() {
        return Debug;
    }

    public void setDebug(boolean Debug) {
        this.Debug = Debug;
    }

    public int getInterval() {
        return Interval;
    }

    public void setInterval(int Interval) {
        this.Interval = Interval;
    }

    public String getOutPutPath() {
        return OutPutPath;
    }

    public void setOutPutPath(String OutPutPath) {
        this.OutPutPath = OutPutPath;
    }

    public List<String> getLiveRooms() {
        return LiveRooms;
    }

    public void setLiveRooms(List<String> LiveRooms) {
        this.LiveRooms = LiveRooms;
    }

    public static class RPCBean {
        /**
         * Enable : true
         * Port : 127.0.0.1:8080
         * Token :
         * TLS : {"Enable":false,"CertFile":"","KeyFile":""}
         */

        private boolean Enable;
        private String Port;
        private String Token;
        private TLSBean TLS;

        public boolean isEnable() {
            return Enable;
        }

        public void setEnable(boolean Enable) {
            this.Enable = Enable;
        }

        public String getPort() {
            return Port;
        }

        public void setPort(String Port) {
            this.Port = Port;
        }

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public TLSBean getTLS() {
            return TLS;
        }

        public void setTLS(TLSBean TLS) {
            this.TLS = TLS;
        }

        public static class TLSBean {
            /**
             * Enable : false
             * CertFile :
             * KeyFile :
             */

            private boolean Enable;
            private String CertFile;
            private String KeyFile;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getCertFile() {
                return CertFile;
            }

            public void setCertFile(String CertFile) {
                this.CertFile = CertFile;
            }

            public String getKeyFile() {
                return KeyFile;
            }

            public void setKeyFile(String KeyFile) {
                this.KeyFile = KeyFile;
            }
        }
    }
}
