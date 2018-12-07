package com.example.administrator.mvcshuaxin.callback;
//接口回调,使用泛型
public interface MyCallBack<T> {
    //成功时回调,获得数据
    void setData(T data);
    //失败是回调
    void setError(T error);
}
