package com.oupu.pss.vo;

import java.io.Serializable;

/**
 * Classname:children
 * Package:com.oupu.pss.vo
 * Description:
 *
 * @Data:2019/12/11 14:39
 * @Author:
 */
public class Children implements Serializable {
    int id;
    String title;

    public Children() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Children{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
