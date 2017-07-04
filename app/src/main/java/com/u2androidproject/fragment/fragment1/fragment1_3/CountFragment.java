package com.u2androidproject.fragment.fragment1.fragment1_3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.u2androidproject.R;
import com.u2androidproject.adapter.MyItemMovieAdapter;
import com.u2androidproject.bean.ItemMovie;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountFragment extends Fragment {


    private View view;
    private GridView mGridView;
    private List<String> mlist = new ArrayList<>();

    public CountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_count, container, false);
        mGridView = (GridView) view.findViewById(R.id.mGridView);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String sid = bundle.getString("sid");
            String url = "http://api.hanju.koudaibaobao.com/api/series/detailV3?sid=" + sid;
            x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Gson gson = new Gson();
                    ItemMovie itemMovie = gson.fromJson(s, ItemMovie.class);
                    List<ItemMovie.PlayItemsBean> playItems = itemMovie.getPlayItems();
                    MyItemMovieAdapter adapter = new MyItemMovieAdapter(playItems, getContext());
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
        }

        return view;
    }

}
