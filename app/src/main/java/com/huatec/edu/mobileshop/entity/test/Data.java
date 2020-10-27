package com.huatec.edu.mobileshop.entity.test;

import java.util.List;

public class Data {
        private int goodsId;
        private String name;
        private String sn;
        private String brief;
        private int price;
        private String cost;
        private String mktprice;
        private int mktEnable;
        private int catId;
        private int brandId;
        private String weight;
        private String creatime;
        private String lastModify;
        private String viewCount;
        private String buyCount;
        private String thumbnail;
        private String big;
        private String small;
        private String orinal;
        private BriefGoodsCat briefGoodsCat;
        private String briefGoodsCat2;
        private List<String> gis;
        private String goodStore;
        private BriefBrand briefBrand;
        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }
        public int getGoodsId() {
            return goodsId;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }
        public String getSn() {
            return sn;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }
        public String getBrief() {
            return brief;
        }

        public void setPrice(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }
        public String getCost() {
            return cost;
        }

        public void setMktprice(String mktprice) {
            this.mktprice = mktprice;
        }
        public String getMktprice() {
            return mktprice;
        }

        public void setMktEnable(int mktEnable) {
            this.mktEnable = mktEnable;
        }
        public int getMktEnable() {
            return mktEnable;
        }

        public void setCatId(int catId) {
            this.catId = catId;
        }
        public int getCatId() {
            return catId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }
        public int getBrandId() {
            return brandId;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
        public String getWeight() {
            return weight;
        }

        public void setCreatime(String creatime) {
            this.creatime = creatime;
        }
        public String getCreatime() {
            return creatime;
        }

        public void setLastModify(String lastModify) {
            this.lastModify = lastModify;
        }
        public String getLastModify() {
            return lastModify;
        }

        public void setViewCount(String viewCount) {
            this.viewCount = viewCount;
        }
        public String getViewCount() {
            return viewCount;
        }

        public void setBuyCount(String buyCount) {
            this.buyCount = buyCount;
        }
        public String getBuyCount() {
            return buyCount;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
        public String getThumbnail() {
            return thumbnail;
        }

        public void setBig(String big) {
            this.big = big;
        }
        public String getBig() {
            return big;
        }

        public void setSmall(String small) {
            this.small = small;
        }
        public String getSmall() {
            return small;
        }

        public void setOrinal(String orinal) {
            this.orinal = orinal;
        }
        public String getOrinal() {
            return orinal;
        }

        public void setBriefGoodsCat(BriefGoodsCat briefGoodsCat) {
            this.briefGoodsCat = briefGoodsCat;
        }
        public BriefGoodsCat getBriefGoodsCat() {
            return briefGoodsCat;
        }

        public void setBriefGoodsCat2(String briefGoodsCat2) {
            this.briefGoodsCat2 = briefGoodsCat2;
        }
        public String getBriefGoodsCat2() {
            return briefGoodsCat2;
        }

        public void setGis(List<String> gis) {
            this.gis = gis;
        }
        public List<String> getGis() {
            return gis;
        }

        public void setGoodStore(String goodStore) {
            this.goodStore = goodStore;
        }
        public String getGoodStore() {
            return goodStore;
        }

        public void setBriefBrand(BriefBrand briefBrand) {
            this.briefBrand = briefBrand;
        }
        public BriefBrand getBriefBrand() {
            return briefBrand;
        }

    @Override
    public String toString() {
        return "Data{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", brief='" + brief + '\'' +
                ", price=" + price +
                ", cost='" + cost + '\'' +
                ", mktprice='" + mktprice + '\'' +
                ", mktEnable=" + mktEnable +
                ", catId=" + catId +
                ", brandId=" + brandId +
                ", weight='" + weight + '\'' +
                ", creatime='" + creatime + '\'' +
                ", lastModify='" + lastModify + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", buyCount='" + buyCount + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", big='" + big + '\'' +
                ", small='" + small + '\'' +
                ", orinal='" + orinal + '\'' +
                ", briefGoodsCat=" + briefGoodsCat +
                ", briefGoodsCat2='" + briefGoodsCat2 + '\'' +
                ", gis=" + gis +
                ", goodStore='" + goodStore + '\'' +
                ", briefBrand=" + briefBrand +
                '}';
    }
}
