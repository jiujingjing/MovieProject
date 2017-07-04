package com.u2androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.u2androidproject.bean.ItemMovie;
import com.u2androidproject.fragment.fragment1.fragment1_3.CountFragment;
import com.u2androidproject.fragment.fragment1.fragment1_3.InfoFragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.NumberFormat;

public class ItemMovieActivity extends AppCompatActivity {


    private RadioGroup mGroup;
    private ImageView imageview;
    private TextView tv_score,tv_count,tv_source,tv_name;
    private InfoFragment infoFragment;
    private CountFragment countFragment;
    private FragmentManager manager;
    private String sid;
    private String intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_movie);

        imageview = (ImageView) findViewById(R.id.imageview);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_count = (TextView) findViewById(R.id.tv_count);
        tv_source = (TextView) findViewById(R.id.tv_source);
        mGroup = (RadioGroup) findViewById(R.id.mGroup);


        addRadioClick();

        Intent intent = getIntent();
        sid = intent.getStringExtra("sid");
        String url = "http://api.hanju.koudaibaobao.com/api/series/detailV3?sid=" + sid;


        manager = getSupportFragmentManager();
        countFragment = new CountFragment();
        Bundle bundle = new Bundle();
        bundle.putString("sid",sid);
        countFragment.setArguments(bundle);
        manager.beginTransaction().add(R.id.container,countFragment).commit();


        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                ItemMovie itemMovie = gson.fromJson(s, ItemMovie.class);
                ItemMovie.SeriesBean series = itemMovie.getSeries();
                String name = series.getName();
                int rank = series.getRank();
                int count = series.getCount();
                boolean isFinished = series.isIsFinished();
                intro = series.getIntro();
                String source = series.getSource();
                String thumb = series.getThumb();
                tv_name.setText(name);
                Glide.with(ItemMovieActivity.this).load(thumb).into(imageview);
                //把整数转化为小数点后一位的浮点数
                NumberFormat instance = NumberFormat.getNumberInstance();
                instance.setMaximumFractionDigits(1);
                String format = instance.format(rank * 0.1);
                tv_score.setText(format);
                tv_source.setText(source);
                if (isFinished){
                    tv_count.setText(count + "集全");
                }else {
                    tv_count.setText("更新至第" + count + "集");
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

    private void addRadioClick() {
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_1:
                        manager = getSupportFragmentManager();
                        countFragment = new CountFragment();
                       /* Bundle bundle = new Bundle();
                        bundle.putString("pid",pid);
                        bundle.putInt("serialNo",serialNo);*/
//                        countFragment.setArguments(bundle);
                        Bundle bundle = new Bundle();
                        bundle.putString("sid",sid);
                        countFragment.setArguments(bundle);
                        manager.beginTransaction().replace(R.id.container,countFragment).commit();
                        break;
                    case R.id.rb_2:
                        manager = getSupportFragmentManager();
                        infoFragment = new InfoFragment();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("intro",intro);
                        infoFragment.setArguments(bundle1);
                        manager.beginTransaction().replace(R.id.container,infoFragment).commit();

                        break;
                }
            }
        });
    }


}
