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
import com.u2androidproject.Main2Activity;
import com.u2androidproject.R;
import com.u2androidproject.bean.FindTypeEight;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MyFindTypeAdapter extends BaseAdapter {

    private List<FindTypeEight> mlist;
    private Context context;

    public MyFindTypeAdapter(List<FindTypeEight> mlist, Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_findtype,parent,false);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_title);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        FindTypeEight findTypeEight = mlist.get(position);
        holder.tv_name.setText(findTypeEight.getName());
        Glide.with(context).load(findTypeEight.getImg()).into(holder.imageview);

        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 7){
                    Intent intent = new Intent(context, Main2Activity.class);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView imageview;
        TextView tv_name;
    }
}
