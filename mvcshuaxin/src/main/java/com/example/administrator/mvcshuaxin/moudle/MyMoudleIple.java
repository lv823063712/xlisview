package com.example.administrator.mvcshuaxin.moudle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import com.example.administrator.mvcshuaxin.bean.MyData;

import com.example.administrator.mvcshuaxin.callback.MyCallBack;
import com.example.administrator.mvcshuaxin.util.HttpUtil;
import com.google.gson.Gson;

import java.util.List;


//moudle接口的实现类
public class MyMoudleIple implements MyMoudle {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String jsons = (String) msg.obj;
            Gson gson = new Gson();
            MyData data = gson.fromJson(jsons, MyData.class);
            //使用接口回调
            callBack.setData(data);
        }
    };
    public MyCallBack callBack;

    @Override
    public void getData(final String url, final int index, final MyCallBack callBack) {
        //进行传值(this)
        this.callBack = callBack;
        //创建子线程进行解析
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //进行数据解析
                    String s = HttpUtil.get(url + index);
                    handler.sendMessage(handler.obtainMessage(0, s));
                } catch (Exception e) {
                    Looper.prepare();
                    callBack.setError("出现错误了");
                    Looper.loop();
                }
            }
        }).start();

    }
}
