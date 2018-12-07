package com.example.administrator.mvcshuaxin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.mvcshuaxin.adapter.MyAdapter;
import com.example.administrator.mvcshuaxin.bean.MyData;
import com.example.administrator.mvcshuaxin.iview.IView;
import com.example.administrator.mvcshuaxin.presenter.PresenterImpl;
import com.example.xlistviewflush.view.XListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener, IView {

    private XListView xListView;
    private ArrayList<MyData.DataBean> datas = new ArrayList<>();
    private String murl = "http://www.xieast.com/api/news/news.php?page=";
    private PresenterImpl presenter;
    private MyAdapter adapter;
    private int index = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //实现P类
        presenter = new PresenterImpl(this);
        adapter = new MyAdapter(datas, MainActivity.this);
        xListView.setAdapter(adapter);
        presenter.startRequest(murl, index);

    }

    private void initView() {
        xListView = findViewById(R.id.MyXListView);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(this);
    }

    @Override
    public void success(Object data) {
        //将数值取过来
        MyData myData = (MyData) data;
        //将数据添加到集合中
        datas.addAll(myData.getData());
        //刷新适配器
        adapter.notifyDataSetChanged();
        //将刷新动画进行停止
        stopReflush();
    }

    private void stopReflush() {
        xListView.stopLoadMore();
        xListView.stopRefresh();
        xListView.setRefreshTime("刚才");
    }

    @Override
    public void error(Object error) {
    }

    @Override
    public void onRefresh() {
        index = 1;
        datas.clear();
        presenter.startRequest(murl, index);
    }

    @Override
    public void onLoadMore() {
        index++;
        presenter.startRequest(murl, index);
    }


}
