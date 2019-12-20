package com.oupu.pss.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:DetailVo
 * Package:com.oupu.pss.vo
 * Description:
 *
 * @Data:2019/12/17 20:51
 * @Author:
 */
public class DetailVO implements Serializable {
    Integer id;
    Integer num;
    Integer option;
    String descript;
    Date createtime;
    String goodsName;
    Integer goodsStock;
    Integer residue;//剩余

    public DetailVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "DetailVo{" +
                "id=" + id +
                ", num=" + num +
                ", option='" + option + '\'' +
                ", descript='" + descript + '\'' +
                ", createtime=" + createtime +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
