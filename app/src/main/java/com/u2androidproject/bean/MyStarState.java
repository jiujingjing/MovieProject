package com.u2androidproject.bean;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MyStarState {
    private String title;
    private String thumb;

    public MyStarState(String title, String thumb) {
        this.title = title;
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
