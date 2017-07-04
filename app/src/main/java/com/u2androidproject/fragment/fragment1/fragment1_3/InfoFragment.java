package com.u2androidproject.fragment.fragment1.fragment1_3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.u2androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    private View view;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_info, container, false);
        WebView mWebView = (WebView) view.findViewById(R.id.mWebView);
//        TextView tv_intro = (TextView) view.findViewById(R.id.tv_intro);

        Bundle bundle = getArguments();
        if (bundle != null){
            String intro = bundle.getString("intro");

            //解决中文乱码问题
            mWebView.loadData(intro, "text/html; charset=UTF-8", null);

            mWebView.setWebViewClient(new WebViewClient());
            WebSettings settings = mWebView.getSettings();
            settings.setJavaScriptEnabled(true);

            //
        }

        return view;
    }


}
