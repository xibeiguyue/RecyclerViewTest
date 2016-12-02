package com.xibei.test.recyclerviewtest;

import android.content.SyncStatusObserver;
import android.provider.Settings;

/**
 * Description:
 * Author:Administrator
 * Date: 2016/12/2
 * Time: 11:41
 */

public class HelloGit {

    private String name;
    private int age;

    public HelloGit(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public HelloGit(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
