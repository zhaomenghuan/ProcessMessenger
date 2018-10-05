package cn.com.agree.app.messenger.client;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import cn.com.agree.sdk.messenger.MessageCallback;
import cn.com.agree.sdk.messenger.ProcessMessenger;

public class TestService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "onCreate");

        ProcessMessenger.subscribe("service", new MessageCallback() {
            @Override
            public void onReceive(Bundle data) {
                String message = data.getString("name");
                Log.e("service", "收到消息 -> " + message);
                Toast.makeText(TestService.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "onDestroy");

        ProcessMessenger.unsubscribe("service");
    }
}
