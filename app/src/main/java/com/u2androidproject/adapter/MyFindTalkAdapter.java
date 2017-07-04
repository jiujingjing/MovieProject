package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.u2androidproject.ItemMyTalkActivity;
import com.u2androidproject.R;
import com.u2androidproject.bean.FindTalk;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MyFindTalkAdapter extends BaseAdapter {

    private List<FindTalk.MinesBean> mlist;
    private Context context;

    public MyFindTalkAdapter(List<FindTalk.MinesBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_findtalk,parent,false);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_lastTitle = (TextView) convertView.findViewById(R.id.tv_lastTitle);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        FindTalk.MinesBean minesBean = mlist.get(position);
        holder.tv_title.setText(minesBean.getTitle());
        holder.tv_lastTitle.setText(minesBean.getLastTopicTitle());

        int dailyCount = minesBean.getDailyCount();
        if (dailyCount > 99){
            holder.tv_count.setText("99+");
        }else {
            holder.tv_count.setText(String.valueOf(dailyCount));
        }

        long lastTopicModify = minesBean.getLastTopicModify();
        SimpleDateFormat format = new SimpleDateFormat("mm");
        String time = format.format(lastTopicModify);
        String substring = time.substring(0,1);
        String substring2 = time.substring(1);
        if (substring.equals("0")){
            if (substring2.equals("1") || substring2.equals("0")){
                holder.tv_time.setText("刚刚");
            }else{
                holder.tv_time.setText(substring2 + "分钟前");
            }
        }else {
            holder.tv_time.setText(time + "分钟前");
        }

        Glide.with(context).load(minesBean.getThumb()).into(holder.imageview);

        final int bid = minesBean.getBid();

        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemMyTalkActivity.class);
                intent.putExtra("bid",bid);
                context.startActivity(intent);
            }
        });

        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemMyTalkActivity.class);
                intent.putExtra("bid",bid);
                context.startActivity(intent);
            }
        });

        holder.tv_lastTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemMyTalkActivity.class);
                intent.putExtra("bid",bid);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView imageview;
        TextView tv_title,tv_count,tv_time,tv_lastTitle;
    }


}
