package com.u2androidproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.u2androidproject.R;
import com.u2androidproject.SearchMovieActivity;
import com.u2androidproject.adapter.MyFragmentAdapter;
import com.u2androidproject.fragment.fragment1.Fragment1_1;
import com.u2androidproject.fragment.fragment1.Fragment1_2;
import com.u2androidproject.fragment.fragment1.Fragment1_3;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private ViewPager mViewPager;
    private RadioGroup mGroup;
    private List<Fragment> fragmentList;
    private ImageView iv_search;
    private FragmentManager manager;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment1, container, false);
        iv_search = (ImageView) view.findViewById(R.id.iv_search);

        addImgClick();

        mViewPager = (ViewPager) view.findViewById(R.id.mViewPager);
        mGroup = (RadioGroup) view.findViewById(R.id.mGroup);
        fragmentList = new ArrayList<>();

        addFragment();

        MyFragmentAdapter adapter = new MyFragmentAdapter(getChildFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);



        mRGListener();

        mVPListener();

        mViewPager.setOffscreenPageLimit(2);


        return view;
    }

    private void addImgClick() {
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchMovieActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mVPListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                RadioButton childAt = (RadioButton) mGroup.getChildAt(position);
                int id = childAt.getId();
                mGroup.check(id);
            }
        });

    }

    private void mRGListener() {
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        mViewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    private void addFragment() {
        fragmentList.add(new Fragment1_1());
        fragmentList.add(new Fragment1_2());
        fragmentList.add(new Fragment1_3());
    }

}
