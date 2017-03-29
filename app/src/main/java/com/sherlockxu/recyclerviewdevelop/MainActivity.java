package com.sherlockxu.recyclerviewdevelop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:   RecyclerView之Item多种布局的实现
 * author         xulei
 * Date           2017/3/29 14:36
 */
public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<DataBean> list;
    private int[] color = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int type = (int) (Math.random() * 3 + 1);//随机1-3
            DataBean bean = new DataBean();
            bean.setType(type);
            bean.setName("包子：" + i);
            bean.setContentName("会敲代码的包子：" + i);
            bean.setHeadColor(color[type - 1]);
            bean.setContentColor(color[2 - (type - 1)]);
            list.add(bean);
        }
        adapter = new RecyclerViewAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
