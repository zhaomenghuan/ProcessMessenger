package cn.com.agree.sdk.messenger;

public interface Constant {
    // 订阅
    int SUBSCRIBE = 1;

    // 取消订阅
    int UNSUBSCRIBE = -1;

    // 发送消息给指定目标
    int SEND_MSG_TO_TARGET = 2;

    // 传递key的关键字
    String KEY_STRING = "process_messenger_key_tag";
}
