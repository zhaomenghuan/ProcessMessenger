# ProcessMessenger

Android 进程通信，实现了 Android 跨进程、跨 App 通信的方便调用和封装。

第一步，初始化：

```java
ProcessMessenger.init(this);
```

第二步，订阅消息和取消订阅：

订阅消息：

```java
ProcessMessenger.subscribe(String key, MessageCallback callback);
```

实例：
```java
ProcessMessenger.subscribe("service", new MessageCallback() {
    @Override
    public void onReceive(Bundle data) {
        String message = data.getString("name");
        Log.e("service", "收到消息 -> " + message);
        Toast.makeText(TestService.this, message, Toast.LENGTH_SHORT).show();
    }
});
```

取消订阅：
```
ProcessMessenger.unsubscribe(String key, MessageCallback callback);
```

第三步，发送消息：

```java
ProcessMessenger.sendMessage(String key, Bundle data);
```

订阅消息和发送消息第一个参数是消息的标志，需要唯一；消息依赖 bundle 传递，发送消息第二个参数可传递类型跟 Bundle 允许类型一致。