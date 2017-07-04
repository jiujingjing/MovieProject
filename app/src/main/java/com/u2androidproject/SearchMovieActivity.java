package com.u2androidproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.u2androidproject.widget.MyFlowLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SearchMovieActivity extends AppCompatActivity {
    private MyFlowLayout mFlowLayout;
    private List<String> mlist;
    private TextView tv_search, tv_noMatch;
    private EditText et_search;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tv_search = (TextView) findViewById(R.id.tv_search);
        et_search = (EditText) findViewById(R.id.et_search);
        tv_noMatch = (TextView) findViewById(R.id.tv_noMatch);
        linear = (LinearLayout) findViewById(R.id.linear);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String myName = et_search.getText().toString();
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myName.equals(name)) {
                    Intent intent1 = new Intent(SearchMovieActivity.this, ItemMovieActivity.class);
                    intent1.putExtra("name", name);
                    startActivity(intent1);
                } else {
                    linear.setVisibility(View.GONE);
                    tv_noMatch.setVisibility(View.VISIBLE);

                }
            }
        });


        mFlowLayout = (MyFlowLayout) findViewById(R.id.flowlayout);
        mlist = new ArrayList<>();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 120);
        final ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(layoutParams);
        lp.leftMargin = 30;
        lp.rightMargin = 30;
        lp.topMargin = 20;
        lp.bottomMargin = 20;

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/search/configs"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray hotWords = jsonObject.getJSONArray("hotWords");
                    for (int i = 0; i < hotWords.length(); i++) {
                        String name = hotWords.getString(i);
                        mlist.add(name);
                        TextView view =  new TextView(SearchMovieActivity.this);
                        view.setText(name);
                        view.setTextSize(20);
                        view.setPadding(30, 0, 30, 0);
                        view.setGravity(Gravity.CENTER);
                        view.setTextColor(Color.BLACK);
                        view.setBackgroundDrawable(getResources().getDrawable(R.drawable.count_black_shape));
                        mFlowLayout.addView(view, lp);
                        /*view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent1 = new Intent(SearchMovieActivity.this, ItemMovieActivity.class);
                                intent1.putExtra("name", name);
                                startActivity(intent1);
                            }
                        });*/
                    }
                    /*for (String name:mlist) {

//                        view.setBackgroundDrawable(getResources().getDrawable(R.drawable.count_black_shape));
                    }*/

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

    }
}

