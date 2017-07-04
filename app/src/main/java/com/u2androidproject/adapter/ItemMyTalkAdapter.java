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
import com.u2androidproject.bean.ItemMyTalk;
import com.u2androidproject.widget.NoScrollGridView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class ItemMyTalkAdapter extends BaseAdapter {

    private List<ItemMyTalk.TopicsBean> mlist;
    private Context context;

    public ItemMyTalkAdapter(List<ItemMyTalk.TopicsBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_mytalk,parent,false);
            holder.iv_head = (ImageView) convertView.findViewById(R.id.iv_head);
            holder.tv_nick = (TextView) convertView.findViewById(R.id.tv_nick);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            holder.mGridView = (NoScrollGridView) convertView.findViewById(R.id.mGridView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemMyTalk.TopicsBean topicsBean = mlist.get(position);
        holder.tv_nick.setText(topicsBean.getUserNick());
        holder.tv_title.setText(topicsBean.getTitle());
        holder.tv_content.setText(topicsBean.getContent());

        long lastReplyTime = topicsBean.getLastReplyTime();
        SimpleDateFormat format = new SimpleDateFormat("mm");
        String time = format.format(lastReplyTime);
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

        Glide.with(context).load(topicsBean.getUserAvatar()).into(holder.iv_head);

        List<ItemMyTalk.TopicsBean.PhotoesBean> photoes = topicsBean.getPhotoes();
        if (photoes != null) {
            MyTalkPhotoAdapter adapter = new MyTalkPhotoAdapter(photoes, context);
            holder.mGridView.setAdapter(adapter);
        }

        return convertView;
    }

    class ViewHolder{
        ImageView iv_head;
        TextView tv_nick,tv_time,tv_title,tv_content;
        NoScrollGridView mGridView;
    }
}
