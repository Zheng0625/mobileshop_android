package com.huatec.edu.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id
    private Integer marjectkey;
    private String username;
    private String password;
    private String email;
    private String birth;
    private String lastlogin;
    private String registerdate;
    private int sex;

    @Override
    public String toString() {
        return "User{" +
                "marjectkey=" + marjectkey +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", lastlogin='" + lastlogin + '\'' +
                ", registerdate='" + registerdate + '\'' +
                ", sex=" + sex +
                '}';
    }

    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getRegisterdate() {
        return this.registerdate;
    }
    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }
    public String getLastlogin() {
        return this.lastlogin;
    }
    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }
    public String getBirth() {
        return this.birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getMarjectkey() {
        return this.marjectkey;
    }
    public void setMarjectkey(Integer marjectkey) {
        this.marjectkey = marjectkey;
    }
    @Generated(hash = 2125652969)
    public User(Integer marjectkey, String username, String password, String email,
            String birth, String lastlogin, String registerdate, int sex) {
        this.marjectkey = marjectkey;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birth = birth;
        this.lastlogin = lastlogin;
        this.registerdate = registerdate;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    
}
