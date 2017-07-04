package com.u2androidproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.u2androidproject.LoginActivity;
import com.u2androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    private View view;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment3, container, false);
        TextView tv_login = (TextView) view.findViewById(R.id.tv_login);
        ImageView iv_mine = (ImageView) view.findViewById(R.id.iv_mine);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        iv_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
