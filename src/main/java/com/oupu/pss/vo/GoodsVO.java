package com.oupu.pss.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:Goods
 * Package:com.oupu.pss.entity
 * Description:商品
 *
 * @Data:2019/12/7 17:35
 * @Author:
 */
public class GoodsVO implements Serializable {
    private int id;
    private String name;
    private int stock;
    private String descript;
    private String catName;
    private String cat;
    private Date createtime;

    public GoodsVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", descript='" + descript + '\'' +
                ", cat='" + cat + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
