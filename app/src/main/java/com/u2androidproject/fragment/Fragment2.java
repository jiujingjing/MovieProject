package com.u2androidproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.u2androidproject.R;
import com.u2androidproject.SearchMovieActivity;
import com.u2androidproject.adapter.MyFindTalkAdapter;
import com.u2androidproject.adapter.MyFindTalkAdapter2;
import com.u2androidproject.adapter.MyFindTypeAdapter;
import com.u2androidproject.bean.FindTalk;
import com.u2androidproject.bean.FindTypeEight;
import com.u2androidproject.widget.NoScrollGridView;
import com.u2androidproject.widget.NoScrollListView;

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
public class Fragment2 extends Fragment {


    private View view;
    private NoScrollGridView mGridView;
    private List<FindTypeEight> mlist;
    private TextView tv_search;
    private NoScrollListView mListView;
    private NoScrollListView mListView2;
    private int cid;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment2, container, false);
        mGridView = (NoScrollGridView) view.findViewById(R.id.mGridView);
        tv_search = (TextView) view.findViewById(R.id.tv_search);
        mListView = (NoScrollListView) view.findViewById(R.id.mListView);
        mListView2 = (NoScrollListView) view.findViewById(R.id.mListView2);

        addEditextClick();

        mlist = new ArrayList<>();
        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/series/discovery_v5"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray items = jsonObject.getJSONArray("items");
                    for (int i = 0; i < items.length() - 2; i++) {
                        jsonObject = items.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String img = jsonObject.getString("icon");
                        cid = jsonObject.getInt("cid");
                        FindTypeEight findTypeEight = new FindTypeEight(name, img);
                        mlist.add(findTypeEight);
                    }
                    MyFindTypeAdapter adapter = new MyFindTypeAdapter(mlist, getContext());
                    mGridView.setAdapter(adapter);


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

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/bbs/api/forum/getBoardsV2"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                FindTalk findTalk = gson.fromJson(s, FindTalk.class);
                List<FindTalk.MinesBean> mines = findTalk.getMines();
                MyFindTalkAdapter adapter = new MyFindTalkAdapter(mines, getContext());
                mListView.setAdapter(adapter);

                List<FindTalk.HotsBean> hots = findTalk.getHots();
                MyFindTalkAdapter2 adapter2 = new MyFindTalkAdapter2(hots, getContext());
                mListView2.setAdapter(adapter2);
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

    private void addEditextClick() {
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchMovieActivity.class);
                startActivity(intent);
            }
        });
    }


}
