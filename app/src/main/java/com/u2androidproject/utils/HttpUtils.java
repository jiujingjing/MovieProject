package com.u2androidproject.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by cuilibao on 2017/6/20.
 */

public class HttpUtils {
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void getResult(final String url, final GetData getData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = new URL(url).openStream();
                    //-->byte
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int len = 0;
                    byte[] bytes = new byte[1024];

                    while ((len = inputStream.read(bytes)) != -1) {
                        baos.write(bytes, 0, len);
                    }

                    final byte[] data = baos.toByteArray();

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            getData.success(data);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            getData.error("网络异常");
                        }
                    });
                }
            }
        }).start();
    }


    public interface GetData {
        void success(byte[] data);

        void error(String error);

    }

}
