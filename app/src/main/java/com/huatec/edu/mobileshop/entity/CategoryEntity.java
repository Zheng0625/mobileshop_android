package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;

public class CategoryEntity implements Serializable {

    private Integer catId;
    private String name;
    private Integer parentId;
    private String catPath;
    private Integer goodsCount;
    private Integer sort;
    private Integer typeId;
    private Integer listShow;
    private String image;
    private String creatime;
    private String modifytime;
    private BriefGoodsType briefGoodsType ;


    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCatPath() {
        return catPath;
    }

    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getListShow() {
        return listShow;
    }

    public void setListShow(Integer listShow) {
        this.listShow = listShow;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatime() {
        return creatime;
    }

    public void setCreatime(String creatime) {
        this.creatime = creatime;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public BriefGoodsType getBriefGoodsType() {
        return briefGoodsType;
    }

    public void setBriefGoodsType(BriefGoodsType briefGoodsType) {
        this.briefGoodsType = briefGoodsType;
    }
}
