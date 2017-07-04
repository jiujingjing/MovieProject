package com.u2androidproject.bean;

/**
 * Created by Administrator on 2017/6/26.
 */

public class MyMovie {
    private String thumb;
    private String name;
    private int rank;
    private int count;
    private boolean isFinished;

    public MyMovie(String thumb, String name, int rank, int count, boolean isFinished) {
        this.thumb = thumb;
        this.name = name;
        this.rank = rank;
        this.count = count;
        this.isFinished = isFinished;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
