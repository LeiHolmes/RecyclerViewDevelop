package com.sherlockxu.recyclerviewdevelop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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

//        showGridList();
    }

    /**
     * Grid与List混排，通过修改单独单独一行的列数实现。
     */
    private void showGridList() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int type;
            if (i < 5 || (i > 15 && i < 20))
                type = 1;
            else if (i < 10 || i > 26)
                type = 2;
            else
                type = 3;
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

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //返回横跨度，目前设置了一行两列。
                //return 1 时说明横跨了左边一块，占1/2，也就是当前正常的Item横跨度
                //return 2 时说明当前当前Item横跨了两块，也就是占满一行了。
                if (recyclerView.getAdapter().getItemViewType(position) == DataBean.TYPE_THREE)
                    return gridLayoutManager.getSpanCount();//返回横跨度2，也就是当前设置的列数
                else
                    return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
