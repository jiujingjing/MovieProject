package com.u2androidproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class FindTalk {

    private List<MinesBean> mines;
    private List<HotsBean> hots;

    public List<MinesBean> getMines() {
        return mines;
    }

    public void setMines(List<MinesBean> mines) {
        this.mines = mines;
    }

    public List<HotsBean> getHots() {
        return hots;
    }

    public void setHots(List<HotsBean> hots) {
        this.hots = hots;
    }

    public static class MinesBean {
        /**
         * bid : 1038
         * title : 要命的自拍控
         * thumb : http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/Fow5gwND-_FIyD__0D4LWapA-Jrr.jpg?imageView2/1/w/200/h/200/interlace/1
         * cateId : 3
         * allowMedia : true
         * dailyCount : 843
         * lastTopicTitle : 追奇怪的搭档
         * lastTopicModify : 1498479336822
         * asManager : false
         */

        private int bid;
        private String title;
        private String thumb;
        private int cateId;
        private boolean allowMedia;
        private int dailyCount;
        private String lastTopicTitle;
        private long lastTopicModify;
        private boolean asManager;

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
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

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public boolean isAllowMedia() {
            return allowMedia;
        }

        public void setAllowMedia(boolean allowMedia) {
            this.allowMedia = allowMedia;
        }

        public int getDailyCount() {
            return dailyCount;
        }

        public void setDailyCount(int dailyCount) {
            this.dailyCount = dailyCount;
        }

        public String getLastTopicTitle() {
            return lastTopicTitle;
        }

        public void setLastTopicTitle(String lastTopicTitle) {
            this.lastTopicTitle = lastTopicTitle;
        }

        public long getLastTopicModify() {
            return lastTopicModify;
        }

        public void setLastTopicModify(long lastTopicModify) {
            this.lastTopicModify = lastTopicModify;
        }

        public boolean isAsManager() {
            return asManager;
        }

        public void setAsManager(boolean asManager) {
            this.asManager = asManager;
        }
    }

    public static class HotsBean {
        /**
         * bid : 737
         * title : 李钟硕
         * thumb : http://pic8.qiyipic.com/image/20160307/b3/5f/p_1037671_m_601_m3.jpg
         * cateId : 2
         * sid : 3
         * allowMedia : true
         * dailyCount : 214
         * lastTopicTitle : 李钟硕❤朴信惠
         * lastTopicModify : 1498478463000
         * asManager : false
         */

        private int bid;
        private String title;
        private String thumb;
        private int cateId;
        private String sid;
        private boolean allowMedia;
        private int dailyCount;
        private String lastTopicTitle;
        private long lastTopicModify;
        private boolean asManager;

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
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

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public boolean isAllowMedia() {
            return allowMedia;
        }

        public void setAllowMedia(boolean allowMedia) {
            this.allowMedia = allowMedia;
        }

        public int getDailyCount() {
            return dailyCount;
        }

        public void setDailyCount(int dailyCount) {
            this.dailyCount = dailyCount;
        }

        public String getLastTopicTitle() {
            return lastTopicTitle;
        }

        public void setLastTopicTitle(String lastTopicTitle) {
            this.lastTopicTitle = lastTopicTitle;
        }

        public long getLastTopicModify() {
            return lastTopicModify;
        }

        public void setLastTopicModify(long lastTopicModify) {
            this.lastTopicModify = lastTopicModify;
        }

        public boolean isAsManager() {
            return asManager;
        }

        public void setAsManager(boolean asManager) {
            this.asManager = asManager;
        }
    }
}
