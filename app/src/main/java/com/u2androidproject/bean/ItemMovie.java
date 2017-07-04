package com.u2androidproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25.
 */

public class ItemMovie {

    /**
     * rescode : 0
     * ts : 1498404075946
     * series : {"sid":"K6N0COVmzW17U3EbwPh4c","name":"三流之路","rank":87,"isFinished":false,"publishTime":1495382400000,"intro":"<p><span><span class=\"pl\">导演<\/span>: <span class=\"attrs\">李娜靜<\/span><\/span><br />\n<span><span class=\"pl\">编剧<\/span>: <span class=\"attrs\">林尚春<\/span><\/span><br />\n<span class=\"actor\"><span class=\"pl\">主演<\/span>: <span class=\"attrs\"><a data=\"star:189\">朴叙俊<\/a> / <a data=\"star:188\">金智媛<\/a> / 宋昰昀 / 安宰弘<\/span><\/span><br />\n<span class=\"pl\">制片国家/地区:<\/span> 韩国<br />\n<span class=\"pl\">语言:<\/span> 韩语<br />\n<span class=\"pl\">首播:<\/span> <span content=\"2017-05-22(韩国)\" property=\"v:initialReleaseDate\">2017-05-22(韩国)<\/span><br />\n<span class=\"pl\">集数:<\/span> 16<br />\n<span class=\"pl\">又名:<\/span> 我的打架之路 / 쌈 마이 웨이<\/p>\n\n<div class=\"para\" label-module=\"para\">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 朴叙俊剧中饰演男主高东万（音译）一角，高东万学生时期是一个穿着跆拳道服的热血斗士，现在是一名平凡的合同制公司职员，他是一个为了能东山再起不再练跆拳道，开始挑战UFC选手的人物。<\/div>\n\n<div class=\"para\" label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 金智媛剧中饰演百货商店服务台工作的崔爱拉一角，她过去梦想成为一名播音员，所以每年都报考播音员公开招聘考试却每次都落榜，这是个不依靠别人，不信运气，不心存侥幸，非常自立的角色。<\/div>\n\n<div class=\"para\" label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 朴叙俊和金智媛两人将在剧中表现出一边经历挫折，一边又朝气蓬勃笑对人生的演技，吸引大众目光，加上两人的角色会由从小一起长大的男闺蜜女闺蜜发展成恋人关系，这样的现实罗曼史不由令观众激动。<\/div>\n\n<div class=\"para\" label-module=\"para\">\n<div class=\"para\" label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 安在洪将出演电视购物公司的代理金周万（音译），在过去的六年里，在女友的精心帮助下成为了一名优秀的公司职员，&ldquo;就业的话，站稳脚跟的话，找到出租房的话&rdquo;以各种陈旧的理由一天天地推迟结婚，在公司有新职员艺珍（音译）的追求，她是国内首屈一指的财阀家族的女儿。《我的女儿琴四月》之后一年回归荧幕的宋昰昀扮演的周万的女朋友白雪熙，是电视购物公司的合同工，对她来说没有什么了不起的男友，他成为正式工也是值得骄傲的事，由于家境贫寒，赚了钱也舍不得花买什么东西。而对于周万来说看起来像是过不下去的人，真是越来越吝啬了，后来她才知道，周万不是因为自己而是其他女人而动摇。周万想借用眼前的身份寻找升职的机会，能否成为&ldquo;青春的陷阱&rdquo;呢？<\/div>\n<\/div>","thumb":"http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FjY5LgOyPnT3neNiNQ4LZNMbpdlB.jpeg?imageView2/2/w/200/interlace/1","count":10,"source":"youku","category":1}
     * playItems : [{"pid":"7W88fz7z1qSdfGqdbGlz","serialNo":1,"publishTime":1495486619000},{"pid":"kJPVcPvIc7L40l5eKD1j","serialNo":2,"publishTime":1495582993000},{"pid":"JBmzqRN8dSnf2dlwlXZ0","serialNo":3,"publishTime":1496093184000},{"pid":"5b8Xs1kO2_CTL7LLtEb1","serialNo":4,"publishTime":1496178191000},{"pid":"PlNPQQUCHtfquPjkgs98","serialNo":5,"publishTime":1496701905000},{"pid":"10rpzliHgn_2hJGC9RgYL","serialNo":6,"publishTime":1496788348000},{"pid":"R4RBq6dWeGM4vwzTfYo1","serialNo":7,"publishTime":1497313950000},{"pid":"98dHrx_p4F15uoQ0Gu96u","serialNo":8,"publishTime":1497407195000},{"pid":"f0xBzSUKIw11lDwvnnPPs","serialNo":9,"publishTime":1497918152000},{"pid":"OqFEyF44C510a5OGTbrfR","serialNo":10,"publishTime":1498002245000}]
     * forum : 0
     * forumMsg : 该功能在测试阶段，仅对部分用户开启，敬请期待
     */

    private int rescode;
    private long ts;
    private SeriesBean series;
    private int forum;
    private String forumMsg;
    private List<PlayItemsBean> playItems;

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

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public int getForum() {
        return forum;
    }

    public void setForum(int forum) {
        this.forum = forum;
    }

    public String getForumMsg() {
        return forumMsg;
    }

    public void setForumMsg(String forumMsg) {
        this.forumMsg = forumMsg;
    }

    public List<PlayItemsBean> getPlayItems() {
        return playItems;
    }

    public void setPlayItems(List<PlayItemsBean> playItems) {
        this.playItems = playItems;
    }

    public static class SeriesBean {
        /**
         * sid : K6N0COVmzW17U3EbwPh4c
         * name : 三流之路
         * rank : 87
         * isFinished : false
         * publishTime : 1495382400000
         * intro : <p><span><span class="pl">导演</span>: <span class="attrs">李娜靜</span></span><br />
         <span><span class="pl">编剧</span>: <span class="attrs">林尚春</span></span><br />
         <span class="actor"><span class="pl">主演</span>: <span class="attrs"><a data="star:189">朴叙俊</a> / <a data="star:188">金智媛</a> / 宋昰昀 / 安宰弘</span></span><br />
         <span class="pl">制片国家/地区:</span> 韩国<br />
         <span class="pl">语言:</span> 韩语<br />
         <span class="pl">首播:</span> <span content="2017-05-22(韩国)" property="v:initialReleaseDate">2017-05-22(韩国)</span><br />
         <span class="pl">集数:</span> 16<br />
         <span class="pl">又名:</span> 我的打架之路 / 쌈 마이 웨이</p>

         <div class="para" label-module="para">&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 朴叙俊剧中饰演男主高东万（音译）一角，高东万学生时期是一个穿着跆拳道服的热血斗士，现在是一名平凡的合同制公司职员，他是一个为了能东山再起不再练跆拳道，开始挑战UFC选手的人物。</div>

         <div class="para" label-module="para">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 金智媛剧中饰演百货商店服务台工作的崔爱拉一角，她过去梦想成为一名播音员，所以每年都报考播音员公开招聘考试却每次都落榜，这是个不依靠别人，不信运气，不心存侥幸，非常自立的角色。</div>

         <div class="para" label-module="para">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 朴叙俊和金智媛两人将在剧中表现出一边经历挫折，一边又朝气蓬勃笑对人生的演技，吸引大众目光，加上两人的角色会由从小一起长大的男闺蜜女闺蜜发展成恋人关系，这样的现实罗曼史不由令观众激动。</div>

         <div class="para" label-module="para">
         <div class="para" label-module="para">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 安在洪将出演电视购物公司的代理金周万（音译），在过去的六年里，在女友的精心帮助下成为了一名优秀的公司职员，&ldquo;就业的话，站稳脚跟的话，找到出租房的话&rdquo;以各种陈旧的理由一天天地推迟结婚，在公司有新职员艺珍（音译）的追求，她是国内首屈一指的财阀家族的女儿。《我的女儿琴四月》之后一年回归荧幕的宋昰昀扮演的周万的女朋友白雪熙，是电视购物公司的合同工，对她来说没有什么了不起的男友，他成为正式工也是值得骄傲的事，由于家境贫寒，赚了钱也舍不得花买什么东西。而对于周万来说看起来像是过不下去的人，真是越来越吝啬了，后来她才知道，周万不是因为自己而是其他女人而动摇。周万想借用眼前的身份寻找升职的机会，能否成为&ldquo;青春的陷阱&rdquo;呢？</div>
         </div>
         * thumb : http://7xk9kc.com2.z0.glb.qiniucdn.com/hj_res/FjY5LgOyPnT3neNiNQ4LZNMbpdlB.jpeg?imageView2/2/w/200/interlace/1
         * count : 10
         * source : youku
         * category : 1
         */

        private String sid;
        private String name;
        private int rank;
        private boolean isFinished;
        private long publishTime;
        private String intro;
        private String thumb;
        private int count;
        private String source;
        private int category;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
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

        public boolean isIsFinished() {
            return isFinished;
        }

        public void setIsFinished(boolean isFinished) {
            this.isFinished = isFinished;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class PlayItemsBean {
        /**
         * pid : 7W88fz7z1qSdfGqdbGlz
         * serialNo : 1
         * publishTime : 1495486619000
         */

        private String pid;
        private int serialNo;
        private long publishTime;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public int getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }


    }
}
