package com.u2androidproject.fragment.fragment1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.u2androidproject.R;
import com.u2androidproject.adapter.MyRecommendAdapter;

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
public class Fragment1_2 extends Fragment {


    private View view;
    private ListView mListView;
    private List<JSONObject> mlist = new ArrayList<>();

    public Fragment1_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment1_2, container, false);
        mListView = (ListView) view.findViewById(R.id.mListView);
        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/index/recommend"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("recs");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        mlist.add(jsonObject);
                    }
                    MyRecommendAdapter adapter1 = new MyRecommendAdapter(mlist,getContext());
                    mListView.setAdapter(adapter1);
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
