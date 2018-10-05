package cn.com.agree.app.messenger.server;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import cn.com.agree.sdk.messenger.MessageCallback;
import cn.com.agree.sdk.messenger.ProcessMessenger;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "ServerApp";

    private TextView textView;
    private int offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.message);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        // 注册消息
        ProcessMessenger.subscribe("Server", new MessageCallback() {
            @Override
            public void onReceive(Bundle data) {
                String message = data.getString("name");
                Log.e(TAG, "ServerApp 接收到消息" + message);
                Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();

                offset = textView.getLineCount() * textView.getLineHeight();
                if (offset > textView.getHeight()) {
                    textView.scrollTo(0, offset - textView.getHeight());
                }
                textView.append(message + "\n");
            }
        });
    }
}
