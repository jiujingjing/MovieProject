package com.u2androidproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class StarOrder {
    /**
     * rescode : 0
     * ts : 1498028078412
     * hotStars : [{"sid":3,"name":"李钟硕","thumb":"http://pic8.qiyipic.com/image/20160307/b3/5f/p_1037671_m_601_m3.jpg","baikeUrl":"http://baike.baidu.com/link?url=_0M2NG17DFDCqsvF_Hw9Ljb_kRSWgF_1PHz76quSjtKoztOlwE7CxwgfeojYWxVV6SCIeORJ4KvF6ZfKI1qUta","fansCount":768073,"rank":1},{"sid":153,"name":"南柱赫","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FvIXN0oZZrTrcxFVPP8AzhZKhWSy.jpg","baikeUrl":"http://baike.baidu.com/item/%E5%8D%97%E6%9F%B1%E8%B5%AB","fansCount":626221,"rank":2},{"sid":24,"name":"李敏镐","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FpDdqMGE-rRDjOQQ-f310ZmcwnUR.png","baikeUrl":"http://baike.baidu.com/view/2156717.htm","fansCount":519089,"rank":3},{"sid":9,"name":"宋仲基","thumb":"http://pic2.qiyipic.com/image/20160307/c2/7e/p_2012860_m_601_m3.jpg","baikeUrl":"http://baike.baidu.com/link?url=Ca51yMEttr59VbkZKEhg832tiDqI2wcesikmm1aCyljZzzp2QQPS0i_vJhir4ox0_eaYEcDsbN5VJ-pz9bftf_","fansCount":397417,"rank":4},{"sid":7,"name":"朴灿烈","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FjXgY0MAisl9kUIG7Ha_igvW43o_.png","baikeUrl":"http://baike.baidu.com/view/4277180.htm","fansCount":376418,"rank":5},{"sid":26,"name":"池昌旭","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/Fj5kEbF-11GSoEH2y3yTiaTOFRhZ.png","baikeUrl":"http://baike.baidu.com/view/2448556.htm","fansCount":368155,"rank":6},{"sid":34,"name":"朴信惠","thumb":"http://pic8.qiyipic.com/image/20160307/3d/07/p_5080_m_601_m1.jpg","baikeUrl":"http://baike.baidu.com/view/189132.htm","fansCount":316921,"rank":7}]
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
         * fansCount : 768073
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
