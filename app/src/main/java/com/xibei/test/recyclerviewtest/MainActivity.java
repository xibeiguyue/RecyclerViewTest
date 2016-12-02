package com.xibei.test.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.xibei.test.recyclerviewtest.adapterutil.MyAdapter;
import com.xibei.test.recyclerviewtest.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<ItemBean> itemList = new ArrayList<ItemBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDatas();
        initview();
    }

    public void loadDatas(){
        itemList.add(new ItemBean("第一张图片",R.mipmap.item1));
        itemList.add(new ItemBean("第二张图片",R.mipmap.item2));
        itemList.add(new ItemBean("第三张图片",R.mipmap.item3));
        itemList.add(new ItemBean("第四张图片",R.mipmap.item4));
        itemList.add(new ItemBean("第五张图片",R.mipmap.item5));

    }

    public void initview() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewtest);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        myAdapter = new MyAdapter(this,itemList);
        mRecyclerView.setAdapter(myAdapter);

    }


}
