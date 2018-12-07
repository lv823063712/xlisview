package com.example.administrator.mvcshuaxin.moudle;

import com.example.administrator.mvcshuaxin.callback.MyCallBack;

public interface MyMoudle {
    //moudle层的接口
    void getData(String url, int index, MyCallBack callBack);
}
