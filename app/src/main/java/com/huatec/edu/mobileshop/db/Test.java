package com.huatec.edu.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Test {
    @Id
    private Integer id;
    private String content;
    private String hashId;
    private Long unixtime;
    private String updatetime;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", hashId='" + hashId + '\'' +
                ", unixtime=" + unixtime +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    public String getUpdatetime() {
        return this.updatetime;
    }
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
    public Long getUnixtime() {
        return this.unixtime;
    }
    public void setUnixtime(Long unixtime) {
        this.unixtime = unixtime;
    }
    public String getHashId() {
        return this.hashId;
    }
    public void setHashId(String hashId) {
        this.hashId = hashId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Generated(hash = 338557128)
    public Test(Integer id, String content, String hashId, Long unixtime,
            String updatetime) {
        this.id = id;
        this.content = content;
        this.hashId = hashId;
        this.unixtime = unixtime;
        this.updatetime = updatetime;
    }
    @Generated(hash = 372557997)
    public Test() {
    }
}
