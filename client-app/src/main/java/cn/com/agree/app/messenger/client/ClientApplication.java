package cn.com.agree.app.messenger.client;

import android.app.Application;

import cn.com.agree.sdk.messenger.ProcessMessenger;

/**
 * Author: zhaomenghuan
 * Email: zhaomenghuan@agree.com.cn
 * Date：2018/10/5.
 */
public class ClientApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessMessenger.init(this);
    }
}
