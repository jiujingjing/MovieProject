package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.u2androidproject.R;
import com.u2androidproject.VideoActivity;
import com.u2androidproject.bean.ItemMovie;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MyItemMovieAdapter extends BaseAdapter {

    private List<ItemMovie.PlayItemsBean> mlist;
    private Context context;

    public MyItemMovieAdapter(List<ItemMovie.PlayItemsBean> mlist, Context context) {
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
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_moviecount,parent,false);
            holder.tv_serialNo = (TextView) convertView.findViewById(R.id.tv_serialNo);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemMovie.PlayItemsBean playItemsBean = mlist.get(position);
        holder.tv_serialNo.setText(String.valueOf(playItemsBean.getSerialNo()));

        //播放源的id
        final String pid = playItemsBean.getPid();

        holder.tv_serialNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_serialNo.setBackgroundResource(R.drawable.count_red_shape);
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder{
        TextView tv_serialNo;
    }

}
