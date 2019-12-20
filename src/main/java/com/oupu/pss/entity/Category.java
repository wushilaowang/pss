package com.oupu.pss.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:cotegory
 * Package:com.oupu.pss.entity
 * Description:
 *
 * @Data:2019/12/11 10:53
 * @Author:
 */
public class Category implements Serializable {
    Integer id;
    String name;
    Integer child_size;
    Integer parent_id;
    Date createtime;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getChild_size() {
        return child_size;
    }

    public void setChild_size(Integer child_size) {
        this.child_size = child_size;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", child_size=" + child_size +
                ", parent_id=" + parent_id +
                ", createtime=" + createtime +
                '}';
    }
}
