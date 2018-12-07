package com.example.administrator.mvcshuaxin.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvcshuaxin.R;
import com.example.administrator.mvcshuaxin.bean.MyData;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<MyData.DataBean> datas;
    private Context context;

    public MyAdapter(ArrayList<MyData.DataBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public ArrayList<MyData.DataBean> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<MyData.DataBean> datas) {
        this.datas = datas;
        //刷新适配器
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明一个holder
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.adapter, null);
            holder = new ViewHolder();
            holder.tv_date = convertView.findViewById(R.id.My_date);
            holder.tv_title = convertView.findViewById(R.id.My_Title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_date.setText(datas.get(position).getAuthor_name());
        holder.tv_title.setText(datas.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        TextView tv_date;
        TextView tv_title;
    }

}
