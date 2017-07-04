package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.u2androidproject.R;
import com.u2androidproject.StarInfoActivity;
import com.u2androidproject.bean.TotalStar;
import com.u2androidproject.widget.RoundImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class MyTotalStarAdapter extends BaseAdapter {

    private List<TotalStar.HotStarsBean> mlist;
    private Context context;

    public MyTotalStarAdapter(List<TotalStar.HotStarsBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_totalstar,parent,false);
            holder.iv_head = (RoundImageView) convertView.findViewById(R.id.iv_head);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_fans = (TextView) convertView.findViewById(R.id.tv_fans);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        TotalStar.HotStarsBean hotStarsBean = mlist.get(position);
        holder.tv_num.setText(String.valueOf(hotStarsBean.getRank()));
        holder.tv_name.setText(hotStarsBean.getName());
        holder.tv_fans.setText(String.valueOf(hotStarsBean.getFansCount()));
        Glide.with(parent.getContext()).load(hotStarsBean.getThumb()).into(holder.iv_head);

        final String baikeUrl = hotStarsBean.getBaikeUrl();
        holder.iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StarInfoActivity.class);
                intent.putExtra("url",baikeUrl);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
    class ViewHolder{
        RoundImageView iv_head;
        TextView tv_num,tv_name,tv_fans;
    }
}
