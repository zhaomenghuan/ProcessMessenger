package cn.com.agree.sdk.messenger;

import android.os.Bundle;

public interface MessageCallback {
    /**
     * 接收消息回调
     *
     * @param data 消息内容
     */
    void onReceive(Bundle data);
}
