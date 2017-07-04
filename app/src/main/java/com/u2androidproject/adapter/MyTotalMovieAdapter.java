package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.u2androidproject.ItemMovieActivity;
import com.u2androidproject.R;
import com.u2androidproject.bean.TotalMovie;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class MyTotalMovieAdapter extends BaseAdapter {

    private List<TotalMovie.SeriesListBean> mlist;
    private Context context;

    public MyTotalMovieAdapter(List<TotalMovie.SeriesListBean> mlist, Context context) {
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

            TextPaint paint = holder.tv_count.getPaint();
            paint.setFakeBoldText(true);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        TotalMovie.SeriesListBean seriesListBean = mlist.get(position);
        boolean isFinished = seriesListBean.isIsFinished();
        if (isFinished){
            holder.tv_count.setText(seriesListBean.getCount() + "集全");
        }else{
            holder.tv_count.setText("更新至第" + seriesListBean.getCount() + "集");
        }

        NumberFormat instance = NumberFormat.getNumberInstance();
        instance.setMaximumFractionDigits(1);
        String format = instance.format(seriesListBean.getRank() * 0.1);

        holder.tv_name.setText(seriesListBean.getName());
        holder.tv_score.setText(format);
        Glide.with(context).load(seriesListBean.getThumb()).into(holder.imageview);

        final String sid = seriesListBean.getSid();

        /*Intent intent = new Intent(context, SearchMovieActivity.class);
        intent.putExtra("name",seriesListBean.getName());
        context.startActivity(intent);*/

        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemMovieActivity.class);
                intent.putExtra("sid",sid);
                context.startActivity(intent);
            }
        });
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemMovieActivity.class);
                intent.putExtra("sid",sid);
                context.startActivity(intent);
            }
        });




        return convertView;
    }
    class ViewHolder{
        ImageView imageview;
        TextView tv_name,tv_count,tv_score;
    }

}
