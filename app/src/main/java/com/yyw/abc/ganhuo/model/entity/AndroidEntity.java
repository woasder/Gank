package com.yyw.abc.ganhuo.model.entity;

import java.util.List;

/**
 * Created by abc on 2016/5/27.
 */
public class AndroidEntity {
    /**
     * error : false
     * results : [{"_id":"5747b19f6776594b0f050b37","createdAt":"2016-05-27T10:31:59.728Z","desc":"一个字符串模板的库","publishedAt":"2016-05-27T11:56:25.219Z","source":"chrome","type":"Android","url":"https://github.com/square/phrase","used":true,"who":"有时放纵"},{"_id":"5747b10f6776594b0bcff7d9","createdAt":"2016-05-27T10:29:35.433Z","desc":"一个自定义字体的类库","publishedAt":"2016-05-27T11:56:25.219Z","source":"chrome","type":"Android","url":"https://github.com/chrisjenx/Calligraphy","used":true,"who":"有时放纵"},{"_id":"5746e9f06776594b0bcff7ce","createdAt":"2016-05-26T20:20:00.393Z","desc":"由浅入深全面剖析ThreadLocal","publishedAt":"2016-05-27T11:56:25.219Z","source":"web","type":"Android","url":"http://blog.csdn.net/luoyanglizi/article/details/51510233","used":true,"who":"lypeer"},{"_id":"5746e0996776594b0f050b30","createdAt":"2016-05-26T19:40:09.733Z","desc":"在通知栏上的游戏(我妈妈问我为什么一副玛德智障的表情)","publishedAt":"2016-05-27T11:56:25.219Z","source":"chrome","type":"Android","url":"https://github.com/mikeroelens/HungerMoji","used":true,"who":"Dear宅学长"},{"_id":"57466ced6776594b0d64dc46","createdAt":"2016-05-26T11:26:37.745Z","desc":"从Instant run谈Android替换Application和动态加载机制","publishedAt":"2016-05-26T11:52:42.430Z","source":"web","type":"Android","url":"http://w4lle.github.io/2016/05/02/%E4%BB%8EInstant%20run%E8%B0%88Android%E6%9B%BF%E6%8D%A2Application%E5%92%8C%E5%8A%A8%E6%80%81%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6/","used":true,"who":"王令龙"},{"_id":"57465c856776594b0f050b18","createdAt":"2016-05-26T10:16:37.641Z","desc":"深入浅出Android打包","publishedAt":"2016-05-26T11:52:42.430Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzA4MzEwOTkyMQ==&mid=2667374595&idx=1&sn=96fe214204da55caa3e583039352f57c&scene=1&srcid=0526i6VbqnrECGE2lXL8P7cK&key=f5c31ae61525f82eea3e6200ce7a32a4f3cb0221c25d2de0f614ce1137fe351f09c6138b004bc19e7f9d811f3207b93b&ascene=0&uin=NTgyODM2NQ%3D%3D&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.11.3+build(15D21)&version=11020201&pass_ticket=l8tJ6JVIjnrpi9dw1PT8MvYxDtYzBXzxkhxlwofUg%2B8%3D","used":true,"who":"潇涧"},{"_id":"57465c1d6776594b0f050b17","createdAt":"2016-05-26T10:14:53.606Z","desc":"android动画中的插值器，配图解说！","publishedAt":"2016-05-26T11:52:42.430Z","source":"web","type":"Android","url":"http://my.oschina.net/banxi/blog/135633","used":true,"who":"潇涧"},{"_id":"57459b586776594b0bcff7ab","createdAt":"2016-05-25T20:32:24.698Z","desc":"合理优雅的进程保活方式","publishedAt":"2016-05-26T11:52:42.430Z","source":"chrome","type":"Android","url":"https://github.com/D-clock/AndroidDaemonService","used":true,"who":"蒋朋"},{"_id":"574592bf6776594b0bcff7aa","createdAt":"2016-05-25T19:55:43.689Z","desc":"Test if all models in project correctly implement Parcelable","publishedAt":"2016-05-26T11:52:42.430Z","source":"chrome","type":"Android","url":"https://github.com/Commit451/ParcelCheck","used":true,"who":"蒋朋"},{"_id":"57457ce06776594b0bcff7a9","createdAt":"2016-05-25T18:22:24.48Z","desc":"Fab  animation 挺牛逼的","publishedAt":"2016-05-26T11:52:42.430Z","source":"web","type":"Android","url":"https://github.com/qs-lll/FabActionAnimations","used":true,"who":null}]
     */

    private boolean error;
    /**
     * _id : 5747b19f6776594b0f050b37
     * createdAt : 2016-05-27T10:31:59.728Z
     * desc : 一个字符串模板的库
     * publishedAt : 2016-05-27T11:56:25.219Z
     * source : chrome
     * type : Android
     * url : https://github.com/square/phrase
     * used : true
     * who : 有时放纵
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
