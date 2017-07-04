package com.u2androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.u2androidproject.adapter.ItemMyTalkAdapter;
import com.u2androidproject.bean.ItemMyTalk;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class ItemMyTalkActivity extends AppCompatActivity {

    private ListView mListview;
    private TextView tv_myTitle,tv_topicCount;
    private ImageView iv_head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_my_talk);

        mListview = (ListView) findViewById(R.id.mListView);
        tv_myTitle = (TextView) findViewById(R.id.tv_myTitle);
        tv_topicCount = (TextView) findViewById(R.id.tv_topicCount);
        iv_head = (ImageView) findViewById(R.id.iv_head);

        Intent intent = getIntent();
        int bid = intent.getIntExtra("bid",0);
        String url = "http://api.hanju.koudaibaobao.com/bbs/api/forum/topicsV2?bid=" + bid;

        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                ItemMyTalk itemMyTalk = gson.fromJson(s, ItemMyTalk.class);

                ItemMyTalk.BoardBean board = itemMyTalk.getBoard();
                String title = board.getTitle();
                String thumb = board.getThumb();
                int topicCount = board.getTopicCount();
                tv_myTitle.setText(title);
                tv_topicCount.setText(String.valueOf(topicCount));
                Glide.with(ItemMyTalkActivity.this).load(thumb).into(iv_head);

                List<ItemMyTalk.TopicsBean> topics = itemMyTalk.getTopics();
                ItemMyTalkAdapter adapter = new ItemMyTalkAdapter(topics,ItemMyTalkActivity.this);
                mListview.setAdapter(adapter);
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
