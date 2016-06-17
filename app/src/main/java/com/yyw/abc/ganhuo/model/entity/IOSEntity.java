package com.yyw.abc.ganhuo.model.entity;

import java.util.List;

/**
 * Created by abc on 2016/5/27.
 */
public class IOSEntity {
    /**
     * error : false
     * results : [{"_id":"57451d676776594b08b2d6f4","createdAt":"2016-05-25T11:35:03.93Z","desc":"Swift 实现的一个 轻量但强大的色彩工具","publishedAt":"2016-05-25T11:50:54.367Z","source":"chrome","type":"iOS","url":"https://github.com/boycechang/BCColor","used":true,"who":"代码家"},{"_id":"57451d3b6776594b0f050b04","createdAt":"2016-05-25T11:34:19.980Z","desc":"ipa 重新签名，实现快速部署","publishedAt":"2016-05-25T11:50:54.367Z","source":"chrome","type":"iOS","url":"https://github.com/qiaoxueshi/iReSign","used":true,"who":"代码家"},{"_id":"57451a166776594b0f050b02","createdAt":"2016-05-25T11:20:54.487Z","desc":"UI Testing in Xcode 7","publishedAt":"2016-05-25T11:50:54.367Z","source":"chrome","type":"iOS","url":"https://www.bignerdranch.com/blog/ui-testing-in-xcode-7-part-1-ui-testing-gotchas/","used":true,"who":"tripleCC"},{"_id":"574501036776594b0bcff789","createdAt":"2016-05-25T09:33:55.811Z","desc":"iOS微信安装包瘦身","publishedAt":"2016-05-25T11:50:54.367Z","source":"api","type":"iOS","url":"http://mp.weixin.qq.com/s?__biz=MzAwNDY1ODY2OQ==&mid=207986417&idx=1&sn=77ea7d8e4f8ab7b59111e78c86ccfe66&scene=4#wechat_redirect","used":true,"who":"tripleCC"},{"_id":"57448d066776594b0d64dc1d","createdAt":"2016-05-25T01:19:02.674Z","desc":"iOS应用支持IPV6，就那点事儿 - 简书","publishedAt":"2016-05-25T11:50:54.367Z","source":"api","type":"iOS","url":"http://www.jianshu.com/p/a6bab07c4062","used":true,"who":"tripleCC"},{"_id":"574451456776594b0d64dc19","createdAt":"2016-05-24T21:04:05.56Z","desc":"Pod 预编译，减少不必要的生命浪费","publishedAt":"2016-05-25T11:50:54.367Z","source":"api","type":"iOS","url":"http://mp.weixin.qq.com/s?__biz=MzIwMTYzMzcwOQ==&mid=2650948341&idx=1&sn=bf12097fe33d3bb553fab040a394eab6&scene=0#wechat_redirect","used":true,"who":"tripleCC"},{"_id":"57440fe66776594b0bcff771","createdAt":"2016-05-24T16:25:10.562Z","desc":"Swift 学习之函数(Func)基础","publishedAt":"2016-05-25T11:50:54.367Z","source":"web","type":"iOS","url":"http://www.jianshu.com/p/679932f1b083","used":true,"who":"孙福生"},{"_id":"5743f46d6776594541e5523e","createdAt":"2016-05-24T14:27:57.599Z","desc":"一个用来展示 Mac 下载和上传速度的插件，类似 iStat 的效果，超级实用。","publishedAt":"2016-05-25T11:50:54.367Z","source":"chrome","type":"iOS","url":"https://github.com/gjiazhe/Up-Down","used":true,"who":"代码家"},{"_id":"5743ddeb6776594541e55238","createdAt":"2016-05-24T12:51:55.918Z","desc":"我也分享一下我的Gank iOS客户端\u2014\u2014干货儿","publishedAt":"2016-05-25T11:50:54.367Z","source":"web","type":"iOS","url":"https://appsto.re/cn/ZSeYab.i","used":true,"who":"俨小良"},{"_id":"5743c51f677659453e2b2842","createdAt":"2016-05-24T11:06:07.340Z","desc":"ios上架的Gank客户端~~~撒花~~~","publishedAt":"2016-05-24T11:56:12.924Z","source":"chrome","type":"iOS","url":"http://gank.applinzi.com/","used":true,"who":"longyiqun"}]
     */

    private boolean error;
    /**
     * _id : 57451d676776594b08b2d6f4
     * createdAt : 2016-05-25T11:35:03.93Z
     * desc : Swift 实现的一个 轻量但强大的色彩工具
     * publishedAt : 2016-05-25T11:50:54.367Z
     * source : chrome
     * type : iOS
     * url : https://github.com/boycechang/BCColor
     * used : true
     * who : 代码家
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
