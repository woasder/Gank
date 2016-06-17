package com.yyw.abc.ganhuo.model;

/**
 * Created by abc on 2016/6/15.
 */
public class Ganhuo {
    private Long id;
    /** Not-null value. */
    private String sid;
    private String url;
    private String who;
    private String type;
    private String publishedAt;
    private String desc;
    private boolean isMarked;

    public Ganhuo(){

    }

    public Ganhuo(Long id, String sid, String url, String who, String type, String publishedAt, String desc, boolean isMarked) {
        this.id = id;
        this.sid = sid;
        this.url = url;
        this.who = who;
        this.type = type;
        this.publishedAt = publishedAt;
        this.desc = desc;
        this.isMarked = isMarked;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
