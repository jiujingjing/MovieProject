package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.u2androidproject.DragImgActivity;
import com.u2androidproject.R;
import com.u2androidproject.bean.ItemMyTalk;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MyTalkPhotoAdapter extends BaseAdapter {

    private List<ItemMyTalk.TopicsBean.PhotoesBean> mlist;
    private Context context;

    public MyTalkPhotoAdapter(List<ItemMyTalk.TopicsBean.PhotoesBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_img,parent,false);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemMyTalk.TopicsBean.PhotoesBean photoesBean = mlist.get(position);
        String thumb = photoesBean.getThumb();
        Glide.with(context).load(thumb).into(holder.imageview);

        //放大的图片资源
        final String image = photoesBean.getImage();
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DragImgActivity.class);
                intent.putExtra("image",image);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView imageview;
    }
}
