package com.huatec.edu.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class WeatherEntity {
    @Id
    private Integer id;
    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private Double aqi;
    private String ymd;
    private String week;
    private String fx;
    private String fl;
    private String type;
    private String notice;

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", sunset='" + sunset + '\'' +
                ", aqi=" + aqi +
                ", ymd='" + ymd + '\'' +
                ", week='" + week + '\'' +
                ", fx='" + fx + '\'' +
                ", fl='" + fl + '\'' +
                ", type='" + type + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }

    public String getNotice() {
        return this.notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFl() {
        return this.fl;
    }
    public void setFl(String fl) {
        this.fl = fl;
    }
    public String getFx() {
        return this.fx;
    }
    public void setFx(String fx) {
        this.fx = fx;
    }
    public String getWeek() {
        return this.week;
    }
    public void setWeek(String week) {
        this.week = week;
    }
    public String getYmd() {
        return this.ymd;
    }
    public void setYmd(String ymd) {
        this.ymd = ymd;
    }
    public Double getAqi() {
        return this.aqi;
    }
    public void setAqi(Double aqi) {
        this.aqi = aqi;
    }
    public String getSunset() {
        return this.sunset;
    }
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    public String getLow() {
        return this.low;
    }
    public void setLow(String low) {
        this.low = low;
    }
    public String getHigh() {
        return this.high;
    }
    public void setHigh(String high) {
        this.high = high;
    }
    public String getSunrise() {
        return this.sunrise;
    }
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Generated(hash = 1579599009)
    public WeatherEntity(Integer id, String date, String sunrise, String high,
            String low, String sunset, Double aqi, String ymd, String week,
            String fx, String fl, String type, String notice) {
        this.id = id;
        this.date = date;
        this.sunrise = sunrise;
        this.high = high;
        this.low = low;
        this.sunset = sunset;
        this.aqi = aqi;
        this.ymd = ymd;
        this.week = week;
        this.fx = fx;
        this.fl = fl;
        this.type = type;
        this.notice = notice;
    }
    @Generated(hash = 1598697471)
    public WeatherEntity() {
    }
}
