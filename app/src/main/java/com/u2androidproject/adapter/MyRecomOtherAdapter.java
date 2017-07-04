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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class MyRecomOtherAdapter extends BaseAdapter {

    private List<JSONObject> mlist;
    private Context context;

    public MyRecomOtherAdapter(List<JSONObject> mlist, Context context) {
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
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        JSONObject jsonObject = mlist.get(position);
        try {
            String title = jsonObject.getString("title");
            String thumb = jsonObject.getString("thumb");
            holder.tv_title.setText(title);
            Glide.with(parent.getContext()).load(thumb).into(holder.imageview);

            //播放源
            JSONArray sources = jsonObject.getJSONArray("sources");
            JSONObject jsonObject1 = sources.getJSONObject(0);
            final String page = jsonObject1.getString("page");
            holder.imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StarStatePageActivity.class);
                    intent.putExtra("page",page);
                    context.startActivity(intent);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
    class ViewHolder{
        ImageView imageview;
        //TextView tv_time;
        TextView tv_title;
    }
}
