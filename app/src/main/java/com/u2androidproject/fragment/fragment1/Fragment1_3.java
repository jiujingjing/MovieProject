package com.u2androidproject.fragment.fragment1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.u2androidproject.R;
import com.u2androidproject.adapter.MyTotalMovieAdapter;
import com.u2androidproject.bean.TotalMovie;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1_3 extends Fragment {


    private View view;
    private GridView mGridView;

    public Fragment1_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment1_3, container, false);
        mGridView = (GridView) view.findViewById(R.id.mGridView);

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/series/indexV2?offset=0&count=48"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                TotalMovie totalMovie = gson.fromJson(s, TotalMovie.class);
                List<TotalMovie.SeriesListBean> seriesList = totalMovie.getSeriesList();
                MyTotalMovieAdapter adapter = new MyTotalMovieAdapter(seriesList,getContext());
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
        return view;
    }


}
