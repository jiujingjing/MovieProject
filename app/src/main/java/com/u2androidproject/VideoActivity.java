package com.u2androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class VideoActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mWebView = (WebView) findViewById(R.id.mWebView);

        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        String url = "http://api.hanju.koudaibaobao.com/api/series/itemRefV3?pid=" + pid;
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    jsonObject = jsonObject.getJSONObject("playItem");
                    JSONArray sources = jsonObject.getJSONArray("sources");
                    jsonObject = sources.getJSONObject(0);
                    String page = jsonObject.getString("page");
                    mWebView.loadUrl(page);

                    mWebView.setWebViewClient(new WebViewClient());
                    WebSettings webSettings = mWebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webSettings.setLoadWithOverviewMode(true);
                    webSettings.setUseWideViewPort(true);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
