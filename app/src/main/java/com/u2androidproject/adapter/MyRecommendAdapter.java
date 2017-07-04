package com.u2androidproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.u2androidproject.Main2Activity;
import com.u2androidproject.MainActivity;
import com.u2androidproject.R;
import com.u2androidproject.widget.NoScrollGridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class MyRecommendAdapter extends BaseAdapter {

    private List<JSONObject> mlist;
    private Context context;
    private int type;

    public MyRecommendAdapter(List<JSONObject> mlist, Context context) {
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
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        JSONObject jsonObject = mlist.get(position);
        try {
            int type = jsonObject.getInt("type");
            if (convertView == null) {
                switch (type){
                    case 1:
                        holder1 = new ViewHolder1();
                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend1, parent, false);
                        holder1.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                        holder1.mGridView = (NoScrollGridView) convertView.findViewById(R.id.mGridView);
                        convertView.setTag(holder1);
                        break;
                    case 2:
                        holder2 = new ViewHolder2();
                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend2, parent, false);
                        holder2.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                        holder2.mGridView = (NoScrollGridView) convertView.findViewById(R.id.mGridView);
                        convertView.setTag(holder2);
                        break;
                    case 3:
                        holder3 = new ViewHolder3();
                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend2, parent, false);
                        holder3.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                        holder3.mGridView = (NoScrollGridView) convertView.findViewById(R.id.mGridView);
                        convertView.setTag(holder3);
                        break;
                }

            } else {
                switch (type){
                    case 1:
                        holder1 = (ViewHolder1) convertView.getTag();
                        break;
                    case 2:
                        holder2 = (ViewHolder2) convertView.getTag();
                        break;
                    case 3:
                        holder3 = (ViewHolder3) convertView.getTag();
                        break;
                }

            }

            switch (type){
                case 1:
                    try {
                        String title = jsonObject.getString("title");
                        holder1.tv_title.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomMovieAdapter adapter1 = new MyRecomMovieAdapter(mlist, parent.getContext());
                        holder1.mGridView.setAdapter(adapter1);

                        holder1.tv_title.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, Main2Activity.class);
                                context.startActivity(intent);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        String title = jsonObject.getString("title");
                        holder2.tv_title.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomOtherAdapter adapter1 = new MyRecomOtherAdapter(mlist, parent.getContext());
                        holder2.mGridView.setAdapter(adapter1);

                        holder2.tv_title.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        String title = jsonObject.getString("title");
                        holder3.tv_title.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomOtherAdapter adapter1 = new MyRecomOtherAdapter(mlist, parent.getContext());
                        holder3.mGridView.setAdapter(adapter1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*JSONObject jsonObject = mlist.get(position);
        try {
            int type = jsonObject.getInt("type");
            switch (type){
                case 1:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend1, parent, false);
                    TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                    GridView mGridView = (GridView) convertView.findViewById(R.id.mGridView);
                    try {
                        String title = jsonObject.getString("title");
                        tv_title.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomMovieAdapter adapter1 = new MyRecomMovieAdapter(mlist, parent.getContext());
                        mGridView.setAdapter(adapter1);

                        tv_title.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, Main2Activity.class);
                                context.startActivity(intent);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend2, parent, false);
                    TextView tv_title2 = (TextView) convertView.findViewById(R.id.tv_title);
                    GridView mGridView2 = (GridView) convertView.findViewById(R.id.mGridView);
                    try {
                        String title = jsonObject.getString("title");
                        tv_title2.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomOtherAdapter adapter1 = new MyRecomOtherAdapter(mlist, parent.getContext());
                        mGridView2.setAdapter(adapter1);

                        tv_title2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_recommend2, parent, false);
                    TextView tv_title3 = (TextView) convertView.findViewById(R.id.tv_title);
                    GridView mGridView3 = (GridView) convertView.findViewById(R.id.mGridView);
                    try {
                        String title = jsonObject.getString("title");
                        tv_title3.setText(title);
                        JSONArray items = jsonObject.getJSONArray("items");
                        List<JSONObject> mlist = new ArrayList<>();
                        for (int i = 0; i < items.length(); i++) {
                            JSONObject object = items.getJSONObject(i);
                            mlist.add(object);
                        }
                        MyRecomOtherAdapter adapter1 = new MyRecomOtherAdapter(mlist, parent.getContext());
                        mGridView3.setAdapter(adapter1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        try {
            type = mlist.get(position).getInt("type");
            Toast.makeText(context, ""+type, Toast.LENGTH_SHORT).show();
            return type;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    class ViewHolder1 {
        TextView tv_title;
        NoScrollGridView mGridView;
    }

    class ViewHolder2 {
        TextView tv_title;
        NoScrollGridView mGridView;
    }

    class ViewHolder3 {
        TextView tv_title;
        NoScrollGridView mGridView;
    }


}
