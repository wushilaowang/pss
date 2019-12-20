package com.oupu.pss.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:detail
 * Package:com.oupu.pss.entity
 * Description:出入库详情
 *
 * @Data:2019/12/8 20:46
 * @Author:
 */
public class Detail implements Serializable {

    Integer id;
    Integer num;
    Short option;
    String descript;
    Date createtime;
    Integer goods_id;
    Integer residue;//剩余库存

    public Detail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Short getOption() {
        return option;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

    public void setOption(Short option) {
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

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", num=" + num +
                ", option=" + option +
                ", descript='" + descript + '\'' +
                ", createtime=" + createtime +
                ", goods_id=" + goods_id +
                ", residue=" + residue +
                '}';
    }
}
