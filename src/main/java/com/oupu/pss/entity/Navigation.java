package com.oupu.pss.entity;

import java.io.Serializable;

/**
 * Classname:Navigetion
 * Package:com.oupu.pss.entity
 * Description:导航栏
 *
 * @Data:2019/12/8 10:12
 * @Author:
 */
public class Navigation implements Serializable {
    int id;
    String name;
    String url;
    short grade;
    int parent_id;

    public Navigation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public short getGrade() {
        return grade;
    }

    public void setGrade(short grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Navigetion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", grade=" + grade +
                ", parentId=" + parent_id +
                '}';
    }
}
