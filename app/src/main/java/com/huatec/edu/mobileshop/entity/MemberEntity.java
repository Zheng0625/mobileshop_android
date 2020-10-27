package com.huatec.edu.mobileshop.entity;

public class MemberEntity {
    private Integer memberId;
    private String uname;
    private String password;
    private String email;
    private Integer sex;
    private String mobile;
    private Object regtime;
    private Object lastlogin;
    private String image;
    private Object memberAddress;

    @Override
    public String toString() {
        return "MemberEntity{" +
                "member_id=" + memberId +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastlogin=" + lastlogin +
                ", image='" + image + '\'' +
                ", memberAddress=" + memberAddress +
                '}';
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMOBILE() {
        return mobile;
    }

    public void setMOBILE(String mobile) {
        this.mobile = mobile;
    }

    public Object getRegtime() {
        return regtime;
    }

    public void setRegtime(Object regtime) {
        this.regtime = regtime;
    }

    public Object getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Object lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(Object memberAddress) {
        this.memberAddress = memberAddress;
    }
}
