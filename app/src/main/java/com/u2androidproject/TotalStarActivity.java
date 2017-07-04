package com.u2androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.u2androidproject.adapter.MyTotalStarAdapter;
import com.u2androidproject.bean.TotalStar;
import com.u2androidproject.widget.RoundImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class TotalStarActivity extends AppCompatActivity {

    private TextView tv_title,tv_num,tv_name,tv_num2,tv_name2,tv_num3,tv_name3;
    private RoundImageView iv_head,iv_head2,iv_head3;
    private ListView mListView;
    private ImageView iv_back,iv_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_star);

        iv_search = (ImageView) findViewById(R.id.iv_search);
        mListView = (ListView) findViewById(R.id.mListView);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        addBackClick();
        addImgClick();

        iv_head = (RoundImageView) findViewById(R.id.iv_head);
        iv_head2 = (RoundImageView) findViewById(R.id.iv_head2);
        iv_head3 = (RoundImageView) findViewById(R.id.iv_head3);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_num = (TextView) findViewById(R.id.tv_num);
        tv_num2 = (TextView) findViewById(R.id.tv_num2);
        tv_num3 = (TextView) findViewById(R.id.tv_num3);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name2 = (TextView) findViewById(R.id.tv_name2);
        tv_name3 = (TextView) findViewById(R.id.tv_name3);
        //字体加粗
        TextPaint paint = tv_title.getPaint();
        paint.setFakeBoldText(true);

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/star/hotStars?offset=0&count=3"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("hotStars");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String thumb = jsonObject.getString("thumb");
                        int rank = jsonObject.getInt("rank");
                        final String baikeUrl = jsonObject.getString("baikeUrl");

                        switch (rank){
                            case 1:
                                tv_name.setText(name);
                                tv_num.setText(String.valueOf(rank));
                                Glide.with(TotalStarActivity.this).load(thumb).into(iv_head);
                                iv_head.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(TotalStarActivity.this,StarInfoActivity.class);
                                        intent.putExtra("url",baikeUrl);
                                        startActivity(intent);
                                    }
                                });
//                                x.image().bind(iv_head,thumb);
                                break;
                            case 2:
                                tv_name2.setText(name);
                                tv_num2.setText(String.valueOf(rank));
                                Glide.with(TotalStarActivity.this).load(thumb).into(iv_head2);
                                iv_head2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent2 = new Intent(TotalStarActivity.this,StarInfoActivity.class);
                                        intent2.putExtra("url",baikeUrl);
                                        startActivity(intent2);
                                    }
                                });
//                                x.image().bind(iv_head2,thumb);
                                break;
                            case 3:
                                tv_name3.setText(name);
                                tv_num3.setText(String.valueOf(rank));
                                Glide.with(TotalStarActivity.this).load(thumb).into(iv_head3);
                                iv_head3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent3 = new Intent(TotalStarActivity.this,StarInfoActivity.class);
                                        intent3.putExtra("url",baikeUrl);
                                        startActivity(intent3);
                                    }
                                });
//                                x.image().bind(iv_head3,thumb);
                                break;
                        }

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

        x.http().get(new RequestParams("http://api.hanju.koudaibaobao.com/api/star/hotStars?offset=3&count=30"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                TotalStar totalStar = gson.fromJson(s, TotalStar.class);
                List<TotalStar.HotStarsBean> hotStars = totalStar.getHotStars();
                MyTotalStarAdapter adapter = new MyTotalStarAdapter(hotStars,TotalStarActivity.this);
                mListView.setAdapter(adapter);
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

    private void addImgClick() {
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalStarActivity.this,SearchMovieActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addBackClick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalStarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
