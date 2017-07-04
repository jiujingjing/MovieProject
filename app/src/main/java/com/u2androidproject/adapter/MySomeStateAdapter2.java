package com.u2androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.u2androidproject.R;
import com.u2androidproject.bean.MyStarState;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MySomeStateAdapter2 extends BaseAdapter {

    private List<MyStarState> mlist;
    private Context context;

    public MySomeStateAdapter2(List<MyStarState> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_starstate,parent,false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyStarState myStarState = mlist.get(position);
        holder.tv_title.setText(myStarState.getTitle());
        Glide.with(context).load(myStarState.getThumb()).into(holder.imageView);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView tv_title;
    }
}
