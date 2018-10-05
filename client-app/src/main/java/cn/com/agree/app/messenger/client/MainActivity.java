package cn.com.agree.app.messenger.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.com.agree.sdk.messenger.ProcessMessenger;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "ClientApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, TestService.class);
        startService(intent);

        findViewById(R.id.sendInnerMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("name", "Client App 发送内部消息");
                ProcessMessenger.sendMessage("service", data);
            }
        });

        findViewById(R.id.sendOtherAPPMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("name", "Client App 发送应用间消息");
                ProcessMessenger.sendMessage("Server", data);
            }
        });
    }
}
