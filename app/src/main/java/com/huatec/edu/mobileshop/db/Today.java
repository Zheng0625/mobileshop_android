package com.huatec.edu.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Today {
    @Id
    private Integer id;

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private Boolean used;
    private String who;

    @Override
    public String toString() {
        return "Today{" +
                "id=" + id +
                ", _id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    public String getWho() {
        return this.who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    public Boolean getUsed() {
        return this.used;
    }
    public void setUsed(Boolean used) {
        this.used = used;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getPublishedAt() {
        return this.publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Generated(hash = 1352437039)
    public Today(Integer id, String _id, String createdAt, String desc,
            String publishedAt, String source, String type, String url,
            Boolean used, String who) {
        this.id = id;
        this._id = _id;
        this.createdAt = createdAt;
        this.desc = desc;
        this.publishedAt = publishedAt;
        this.source = source;
        this.type = type;
        this.url = url;
        this.used = used;
        this.who = who;
    }
    @Generated(hash = 2021287401)
    public Today() {
    }

}