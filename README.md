# LiveClient-Android
[![Build Status](https://www.travis-ci.org/BJ4501/LiveClient-Android.svg?branch=master)](https://www.travis-ci.org/BJ4501/LiveClient-Android)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/aa26a0891b93451683836ed79ea108e7)](https://app.codacy.com/app/BJ4501/LiveClient-Android?utm_source=github.com&utm_medium=referral&utm_content=BJ4501/LiveClient-Android&utm_campaign=Badge_Grade_Dashboard)
[![JMeowTech](https://img.shields.io/badge/Team-JMeowTech-blue.svg)](http://www.jmeow.org)

LiveClient-Android是用于在Android端对Bililive-go进行管理的Android应用。

## 使用之前
- 请确保你的bililive-go中开启rpc功能，详见：<herf>https://github.com/hr3lxphr6j/bililive-go/wiki/API</herf>
- 确保你的移动设备，可以访问到开启bililive-go的计算机

## 使用方法
- 在运行软件之后，在Settings界面中输入并保存URL即可，URL格式为
```
http://<URL>:<PORT>
```
- 在Status页面中：可以看到bililive-go当前状态信息
- 在直播间列表中，可以看到当前配置的直播间信息
	- 短按直播间条目：可以取消/开启监听直播间
	- 长按直播间条目：可以删除当前直播间	

## 权限使用
- 网络访问权限:android.permission.INTERNET

## LICENSE
<a href="https://github.com/BJ4501/LiveClient-Android/blob/master/LICENSE">GNU General Public License v3.0</a>
