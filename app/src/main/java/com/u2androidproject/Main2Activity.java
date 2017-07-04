package com.u2androidproject;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;

import com.u2androidproject.fragment.Fragment1Copy;
import com.u2androidproject.fragment.Fragment2;
import com.u2androidproject.fragment.Fragment3;

public class Main2Activity extends AppCompatActivity {

    private RadioGroup mGroup;
    private FragmentManager manager;
    private Fragment1Copy fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mGroup = (RadioGroup) findViewById(R.id.mGroup);
        manager = getSupportFragmentManager();
        fragment1 = new Fragment1Copy();
        manager.beginTransaction().add(R.id.relative_fragment,fragment1).commit();

        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_1:
                        manager = getSupportFragmentManager();
                        fragment1 = new Fragment1Copy();
                        manager.beginTransaction().replace(R.id.relative_fragment,fragment1).commit();
                        break;
                    case R.id.rb_2:
                        manager = getSupportFragmentManager();
                        fragment2 = new Fragment2();
                        manager.beginTransaction().replace(R.id.relative_fragment,fragment2).commit();
                        break;
                    case R.id.rb_3:
                        manager = getSupportFragmentManager();
                        fragment3 = new Fragment3();
                        manager.beginTransaction().replace(R.id.relative_fragment,fragment3).commit();
                        break;
                }
            }
        });
    }
}

