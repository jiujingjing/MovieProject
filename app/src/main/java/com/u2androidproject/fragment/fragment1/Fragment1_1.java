package com.u2androidproject.fragment.fragment1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.u2androidproject.R;
import com.u2androidproject.TotalStarActivity;
import com.u2androidproject.adapter.MyStarOrderAdapter;
import com.u2androidproject.adapter.MyStarStateAdapter;
import com.u2androidproject.bean.StarOrder;
import com.u2androidproject.bean.StarState;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1_1 extends Fragment{

    private View view;
    private GridView mGridView,mGridView2;
    private TextView tv_starOrder;

    public Fragment1_1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1_1, container, false);

        tv_starOrder = (TextView) view.findViewById(R.id.tv_starOrder);
        addStarClick();
        mGridView = (GridView) view.findViewById(R.id.mGridView);
        mGridView2 = (GridView) view.findViewById(R.id.mGridView2);

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/star/index"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                StarOrder starOrder = gson.fromJson(s, StarOrder.class);
                List<StarOrder.HotStarsBean> hotStars = starOrder.getHotStars();
                MyStarOrderAdapter adapter =  new MyStarOrderAdapter(hotStars,getContext());
                mGridView.setAdapter(adapter);
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

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/star/hotVideos"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                StarState starState = gson.fromJson(s, StarState.class);
                List<StarState.VideosBean> videos = starState.getVideos();
                MyStarStateAdapter adapter = new MyStarStateAdapter(videos,getContext());
                mGridView2.setAdapter(adapter);
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

    private void addStarClick() {
        tv_starOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TotalStarActivity.class);
                startActivity(intent);
            }
        });


    }




}
