package cn.com.agree.sdk.messenger;

import android.os.Bundle;

import java.util.concurrent.ConcurrentHashMap;

public class ProcessMessageCenter {
    private static ConcurrentHashMap<String, MessageCallback> subscribers = new ConcurrentHashMap<>();

    private ProcessMessageCenter() {

    }

    public static void subscribe(String key, MessageCallback callback) {
        subscribers.put(key, callback);
    }

    public static void unsubscribe(String key) {
        subscribers.remove(key);
    }

    public static void onMessageReceive(Bundle bundle) {
        String key = bundle.getString(Constant.KEY_STRING);
        if (key != null) {
            MessageCallback messageCallback = subscribers.get(key);
            if (messageCallback != null) {
                messageCallback.onReceive(bundle);
            }
        }
    }
}
