package com.xibei.test.recyclerviewtest.bean;

/**
 * Description: item的实体类
 * Author:Administrator
 * Date: 2016/11/30
 * Time: 15:06
 */

public class ItemBean {

    private String title;
    private int resId;

    public ItemBean(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
