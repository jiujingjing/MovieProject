package com.u2androidproject.fragment.fragment1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u2androidproject.R;
import com.u2androidproject.adapter.MySomeMovieAdapter;
import com.u2androidproject.bean.MyMovie;
import com.u2androidproject.bean.MyStarState;
import com.u2androidproject.widget.NoScrollGridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1_2_ extends Fragment {


    private View view;
    private NoScrollGridView mGridView;
    private TextView tv_title;
    private List<MyMovie> mlist;
    private List<MyStarState> mlist2;


    public Fragment1_2_() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.item_listview_recommend1, container, false);
        mGridView = (NoScrollGridView) view.findViewById(R.id.mGridView);
//        mGridView2 = (NoScrollGridView) view.findViewById(mGridView2);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
//        tv_title2 = (TextView) view.findViewById(tv_title2);
        mlist = new ArrayList<>();
        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/index/recommend"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("recs");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        int type = jsonObject1.getInt("type");
                        if (type == 1) {
                            String title = jsonObject1.getString("title");
                            tv_title.setText(title);
                            JSONArray items = jsonObject1.getJSONArray("items");
                            for (int j = 0; j < items.length(); j++) {
                                jsonObject1 = items.getJSONObject(j);
                                String name = jsonObject1.getString("name");
                                int rank = jsonObject1.getInt("rank");
                                boolean isFinished = jsonObject1.getBoolean("isFinished");
                                String thumb = jsonObject1.getString("thumb");
                                int count = jsonObject1.getInt("count");
                                MyMovie myMovie = new MyMovie(thumb, name, rank, count, isFinished);
                                mlist.add(myMovie);
                            }
                            MySomeMovieAdapter adapter = new MySomeMovieAdapter(mlist, getContext());
                            mGridView.setAdapter(adapter);
                        }
//                        else if (type == 2){
//                            String title = jsonObject1.getString("title");
//                            tv_title2.setText(title);
//                            JSONArray items = jsonObject1.getJSONArray("items");
//                            for (int j = 0; j < items.length(); j++) {
//                                JSONObject jsonObject2 = items.getJSONObject(j);
//                                String name = jsonObject2.getString("title");
//                                String thumb = jsonObject2.getString("thumb");
//                                MyStarState myStarState = new MyStarState(name,thumb);
//                                mlist2.add(myStarState);
//                            }
//                            MySomeStateAdapter2 adapter = new MySomeStateAdapter2(mlist2,getContext());
//                            mGridView2.setAdapter(adapter);
//                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
        return view;
    }

}
