package com.u2androidproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class ThreeStar {
    /**
     * rescode : 0
     * ts : 1498060704459
     * hotStars : [{"sid":3,"name":"李钟硕","thumb":"http://pic8.qiyipic.com/image/20160307/b3/5f/p_1037671_m_601_m3.jpg","baikeUrl":"http://baike.baidu.com/link?url=_0M2NG17DFDCqsvF_Hw9Ljb_kRSWgF_1PHz76quSjtKoztOlwE7CxwgfeojYWxVV6SCIeORJ4KvF6ZfKI1qUta","fansCount":768747,"rank":1},{"sid":153,"name":"南柱赫","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FvIXN0oZZrTrcxFVPP8AzhZKhWSy.jpg","baikeUrl":"http://baike.baidu.com/item/%E5%8D%97%E6%9F%B1%E8%B5%AB","fansCount":626816,"rank":2},{"sid":24,"name":"李敏镐","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FpDdqMGE-rRDjOQQ-f310ZmcwnUR.png","baikeUrl":"http://baike.baidu.com/view/2156717.htm","fansCount":519429,"rank":3}]
     */

    private int rescode;
    private long ts;
    private List<HotStarsBean> hotStars;

    public int getRescode() {
        return rescode;
    }

    public void setRescode(int rescode) {
        this.rescode = rescode;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public List<HotStarsBean> getHotStars() {
        return hotStars;
    }

    public void setHotStars(List<HotStarsBean> hotStars) {
        this.hotStars = hotStars;
    }

    public static class HotStarsBean {
        /**
         * sid : 3
         * name : 李钟硕
         * thumb : http://pic8.qiyipic.com/image/20160307/b3/5f/p_1037671_m_601_m3.jpg
         * baikeUrl : http://baike.baidu.com/link?url=_0M2NG17DFDCqsvF_Hw9Ljb_kRSWgF_1PHz76quSjtKoztOlwE7CxwgfeojYWxVV6SCIeORJ4KvF6ZfKI1qUta
         * fansCount : 768747
         * rank : 1
         */

        private int sid;
        private String name;
        private String thumb;
        private String baikeUrl;
        private int fansCount;
        private int rank;

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getBaikeUrl() {
            return baikeUrl;
        }

        public void setBaikeUrl(String baikeUrl) {
            this.baikeUrl = baikeUrl;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
