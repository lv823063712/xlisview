package com.example.administrator.mvcshuaxin.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    //加载布局文件
    protected abstract int getOnLayout();

    //初始化控件
    protected abstract void initViews();

    //设置监听
    protected abstract void setOnClick();

    //逻辑代码的书写
    protected abstract void LogicCode();


    //设定代码执行顺序
    void init() {
        //进行判断布局页面不为空
        if (getOnLayout() != 0) {
            setContentView(getOnLayout());
            initViews();
            setOnClick();
            LogicCode();
        } else {
            throw new IllegalStateException("没有布局文件");
        }
    }
}
