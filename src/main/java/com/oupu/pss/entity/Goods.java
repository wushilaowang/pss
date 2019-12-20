package com.oupu.pss.entity;

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
public class Goods implements Serializable {
    private int id;
    private String name;
    private int stock;
    private String descript;
    private int cat;
    private Date createtime;

    public Goods() {
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

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name=" + name +
                ", stock=" + stock +
                ", descript='" + descript + '\'' +
                ", cat=" + cat +
                '}';
    }
}
