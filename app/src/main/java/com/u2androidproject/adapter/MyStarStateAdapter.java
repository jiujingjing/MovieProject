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
import com.u2androidproject.R;
import com.u2androidproject.StarStatePageActivity;
import com.u2androidproject.bean.StarState;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MyStarStateAdapter extends BaseAdapter {

    private List<StarState.VideosBean> mlist;
    private Context context;

    public MyStarStateAdapter(List<StarState.VideosBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_starstate,parent,false);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
//            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        StarState.VideosBean videosBean = mlist.get(position);
        holder.tv_title.setText(videosBean.getTitle());
//        x.image().bind(holder.imageview,videosBean.getThumb());
        Glide.with(context).load(videosBean.getThumb()).into(holder.imageview);

        List<StarState.VideosBean.SourcesBean> sources = videosBean.getSources();
        for (StarState.VideosBean.SourcesBean bean : sources) {
            final String page = bean.getPage();
            holder.imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StarStatePageActivity.class);
                    intent.putExtra("page",page);
                    context.startActivity(intent);
                }
            });
        }



        //获得视频的时间长度

        return convertView;
    }
    class ViewHolder{
        ImageView imageview;
//        TextView tv_time;
        TextView tv_title;
    }
}
