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
import com.u2androidproject.bean.MyMovie;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MySomeMovieAdapter extends BaseAdapter {

    private List<MyMovie> mlist;
    private Context context;

    public MySomeMovieAdapter(List<MyMovie> mlist, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_totalmovie,parent,false);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
            holder.tv_score = (TextView) convertView.findViewById(R.id.tv_score);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        MyMovie myMovie = mlist.get(position);
        holder.tv_name.setText(myMovie.getName());

        int count = myMovie.getCount();
        boolean finished = myMovie.isFinished();
        if (finished){
            holder.tv_count.setText(count + "集全");
        }else{
            holder.tv_count.setText("更新至第" + count + "集");
        }

        int rank = myMovie.getRank();
        NumberFormat instance = NumberFormat.getNumberInstance();
        instance.setMaximumFractionDigits(1);
        String format = instance.format(rank * 0.1);
        holder.tv_score.setText(format);

        Glide.with(context).load(myMovie.getThumb()).into(holder.imageview);

        return convertView;
    }

    class ViewHolder{
        ImageView imageview;
        TextView tv_name,tv_count,tv_score;
    }
}
