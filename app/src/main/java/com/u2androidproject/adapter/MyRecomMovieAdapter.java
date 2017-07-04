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
import com.u2androidproject.ItemMovieActivity;
import com.u2androidproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class MyRecomMovieAdapter extends BaseAdapter {

    private List<JSONObject> mlist;
    private Context context;

    public MyRecomMovieAdapter(List<JSONObject> mlist, Context context) {
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
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_totalmovie, parent, false);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
            holder.tv_score = (TextView) convertView.findViewById(R.id.tv_score);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        JSONObject jsonObject = mlist.get(position);
        try {
            String name = jsonObject.getString("name");
            String thumb = jsonObject.getString("thumb");
            int rank = jsonObject.getInt("rank");
            boolean isFinished = jsonObject.getBoolean("isFinished");
            int count = jsonObject.getInt("count");
            if (isFinished){
                holder.tv_count.setText(count + "集全");
            }else{
                holder.tv_count.setText("更新至第" + count + "集");
            }
            holder.tv_name.setText(name);
            NumberFormat instance = NumberFormat.getNumberInstance();
            instance.setMaximumFractionDigits(1);
            String format = instance.format(rank * 0.1);
            holder.tv_score.setText(format);
            Glide.with(parent.getContext()).load(thumb).into(holder.imageview);

            final String sid = jsonObject.getString("sid");

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


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }

    class ViewHolder {
        ImageView imageview;
        //TextView tv_time;
        TextView tv_name,tv_count,tv_score;
    }
}
