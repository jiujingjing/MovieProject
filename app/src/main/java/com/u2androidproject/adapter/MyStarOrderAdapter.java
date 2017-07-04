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
import com.u2androidproject.bean.StarOrder;
import com.u2androidproject.widget.RoundImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class MyStarOrderAdapter extends BaseAdapter {

    private List<StarOrder.HotStarsBean> mlist;
    private Context context;

    public MyStarOrderAdapter(List<StarOrder.HotStarsBean> mlist, Context context) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview_starorder,parent,false);
            holder.iv_head = (RoundImageView) convertView.findViewById(R.id.iv_head);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        StarOrder.HotStarsBean hotStarsBean = mlist.get(position);
        holder.tv_name.setText(hotStarsBean.getName());
        holder.tv_num.setText(String.valueOf(hotStarsBean.getRank()));
        Glide.with(parent.getContext()).load(hotStarsBean.getThumb()).into(holder.iv_head);
//        x.image().bind(holder.iv_head,hotStarsBean.getThumb());

//        每个明星的详细资料 --> 百度百科
        final String baikeUrl = hotStarsBean.getBaikeUrl();
        holder.iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StarInfoActivity.class);
                intent.putExtra("url",baikeUrl);
                context.startActivity(intent);
            }
        });
//        iGetInfoUrl.getInfoUrl(baikeUrl);
        return convertView;
    }


    class ViewHolder{
        RoundImageView iv_head;
        TextView tv_num,tv_name;
    }

    /*public interface IGetInfoUrl{
        void getInfoUrl(String url);
    }

    private IGetInfoUrl iGetInfoUrl;

    public void setiGetInfoUrl(IGetInfoUrl iGetInfoUrl) {
        this.iGetInfoUrl = iGetInfoUrl;
    }*/
}
