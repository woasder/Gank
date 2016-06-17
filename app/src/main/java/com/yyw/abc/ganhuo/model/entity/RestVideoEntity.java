package com.yyw.abc.ganhuo.model.entity;

import java.util.List;

/**
 * Created by abc on 2016/5/27.
 */
public class RestVideoEntity {
    /**
     * error : false
     * results : [{"_id":"5732007267765974fbfcfa4a","createdAt":"2016-05-10T23:38:26.522Z","desc":"秒拍牛人大合集，[笑cry]目测膝盖根本不够用啊。","publishedAt":"2016-05-11T12:11:48.690Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/2304443956b04478364a64185f196f0a89266d","used":true,"who":"LHF"},{"_id":"572ca88b67765974fca83119","createdAt":"2016-05-06T22:22:03.382Z","desc":"有人的地方，就有江湖，KTV也是如此。如果把K歌拍成武侠\u2026\u2026","publishedAt":"2016-05-09T12:05:34.903Z","source":"web","type":"休息视频","url":"http://www.miaopai.com/show/8F6V4AfgspDrDDRufkLnxg__.htm","used":true,"who":null},{"_id":"572a20d667765974f885c007","createdAt":"2016-05-05T00:18:30.160Z","desc":"精神分裂症","publishedAt":"2016-05-05T12:14:21.156Z","source":"api","type":"休息视频","url":"http://video.weibo.com/show?fid=1034:ac383faec0900bc788f1ce1547d69a12","used":true,"who":"tripleCC"},{"_id":"5724d01d67765974fbfcf9cd","createdAt":"2016-04-30T23:32:45.195Z","desc":"搞笑动画短片《水手与死神》，现在的死神啊，一言不合就开始卖萌！ [笑cry]","publishedAt":"2016-05-03T12:13:53.904Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444316ab05ac84e5ba31e1d1d56434d5b65","used":true,"who":"LHF"},{"_id":"572186ca67765974fbfcf9ac","createdAt":"2016-04-28T11:43:06.585Z","desc":"《泰国网红的心酸日常》：凄美的浪漫，虚无与真实","publishedAt":"2016-05-04T12:26:08.372Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/2304449281503129ee2b8bd7017089e9661b46","used":true,"who":"lxxself"},{"_id":"5721830667765974f5e27e3f","createdAt":"2016-04-28T11:27:02.621Z","desc":"在交到男朋友之后，估计这段珍贵的视频就要被删除了。。。[笑cry]","publishedAt":"2016-04-29T11:36:42.906Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/2304443ed34ef641632c211ffcdb7d14d6b8b7","used":true,"who":"lxxself"},{"_id":"5720c8a767765974f885bfb6","createdAt":"2016-04-27T22:11:51.285Z","desc":"狼性团队.....","publishedAt":"2016-05-06T12:04:47.203Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/chj~~VGPqbVvDGQi2kvTuQ__.htm","used":true,"who":"LHF"},{"_id":"5720313b67765974fbfcf98f","createdAt":"2016-04-27T11:25:47.507Z","desc":"劲舞：DADDY - PSY  帅炸！！！","publishedAt":"2016-04-27T12:04:15.19Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444c1e567ded239dff9121c0e18fc25b3e7","used":true,"who":"lxxself"},{"_id":"571d73d467765974fbfcf96b","createdAt":"2016-04-25T09:33:08.822Z","desc":"暴露年龄系列；你还记得这些画面吗？现在的我已经长大，但有些回忆永远无法抹去，不知不觉已经泪目！","publishedAt":"2016-04-25T11:24:01.704Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444d56906201ae08d72efee28d06ea2b654","used":true,"who":"lxxself"},{"_id":"571b4bcf67765974f5e27def","createdAt":"2016-04-23T18:17:51.24Z","desc":"励志滑板短片[梦想]","publishedAt":"2016-04-26T11:58:55.460Z","source":"chrome","type":"休息视频","url":"http://www.wandoujia.com/eyepetizer/detail.html?vid=5868","used":true,"who":"蒋朋"}]
     */

    private boolean error;
    /**
     * _id : 5732007267765974fbfcfa4a
     * createdAt : 2016-05-10T23:38:26.522Z
     * desc : 秒拍牛人大合集，[笑cry]目测膝盖根本不够用啊。
     * publishedAt : 2016-05-11T12:11:48.690Z
     * source : chrome
     * type : 休息视频
     * url : http://weibo.com/p/2304443956b04478364a64185f196f0a89266d
     * used : true
     * who : LHF
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
