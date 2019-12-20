package com.oupu.pss.vo;

import java.io.Serializable;

/**
 * Classname:tree
 * Package:com.oupu.pss.vo
 * Description:
 *
 * @Data:2019/12/11 14:38
 * @Author:
 */
public class Tree implements Serializable {
    int id;
    String title;
    Children children;

    public Tree() {
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

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", children=" + children +
                '}';
    }
}
