package com.sherlockxu.recyclerviewdevelop.link;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.sherlockxu.recyclerviewdevelop.DataBean;
import com.sherlockxu.recyclerviewdevelop.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkScrollActivity extends AppCompatActivity {
    RecyclerView rvDate;
    RecyclerView rvType1;
    RecyclerView rvType2;
    private DateAdapter mDateAdapter;
    private TypeAdapter mTypeAdapter1;
    private TypeAdapter mTypeAdapter2;
    private List<DataBean> mDateList;
    private List<DataBean> mTypeList;
    private RecyclerView.OnScrollListener mOnScrollListener;
    private HashSet<RecyclerView> observerList = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_scroll);
        initView();
        initStateAndData();
        initListener();
    }

    private void initView() {
        rvDate = (RecyclerView) findViewById(R.id.rv_date_list);
        rvDate.setTag("date");
        rvType1 = (RecyclerView) findViewById(R.id.rv_type_list1);
        rvType1.setTag("type1");
        rvType2 = (RecyclerView) findViewById(R.id.rv_type_list2);
        rvType2.setTag("type2");
        observerList.add(rvDate);
        observerList.add(rvType1);
        observerList.add(rvType2);
        mDateAdapter = new DateAdapter(this);
        rvDate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDate.setItemAnimator(new DefaultItemAnimator());
        rvDate.setHasFixedSize(true);
        rvDate.setAdapter(mDateAdapter);
        mTypeAdapter1 = new TypeAdapter(this);
        rvType1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvType1.setItemAnimator(new DefaultItemAnimator());
        rvType1.setHasFixedSize(true);
        rvType1.setAdapter(mTypeAdapter1);
        mTypeAdapter2 = new TypeAdapter(this);
        rvType2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvType2.setItemAnimator(new DefaultItemAnimator());
        rvType2.setHasFixedSize(true);
        rvType2.setAdapter(mTypeAdapter2);
    }

    private void initStateAndData() {
        mDateList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setName("5月" + (i + 1) + "日");
            mDateList.add(dataBean);
        }
        mDateAdapter.setList(mDateList);

        mTypeList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            DataBean dataBean = new DataBean();
            switch (i % 3) {
                case 0:
                    dataBean.setName("午餐");
                    break;
                case 1:
                    dataBean.setName("晚餐");
                    break;
                case 2:
                    dataBean.setName("夜宵");
                    break;
            }
            mTypeList.add(dataBean);
        }
        mTypeAdapter1.setList(mTypeList);
        mTypeAdapter2.setList(mTypeList);
    }

    private void initListener() {
        mOnScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.getTag().equals("date")) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int firstPos = linearLayoutManager.findFirstVisibleItemPosition();
                    View firstVisibleItem = linearLayoutManager.getChildAt(0);
                    if (firstVisibleItem != null) {
                        int firstRight = linearLayoutManager.getDecoratedRight(firstVisibleItem);
                        int firstWidth = firstVisibleItem.getWidth();
                        for (RecyclerView observerRecyclerView : observerList) {
                            if (recyclerView != observerRecyclerView) {
                                if (observerRecyclerView.getTag().equals("date")) { //日期
                                    LinearLayoutManager layoutManagerDate = (LinearLayoutManager) observerRecyclerView.getLayoutManager();
                                    if (layoutManagerDate != null) {
                                        View firstVisibleItemDate = layoutManagerDate.getChildAt(0);
                                        if (firstVisibleItemDate != null) {
                                            int firstWidthDate = firstVisibleItemDate.getWidth();
                                            int firstPosDate = firstPos / 3;
                                            int firstPosType = firstPos % 3;
                                            int offsetDate = firstWidthDate - (firstPosType * firstWidth) - (firstWidth - firstRight);
                                            layoutManagerDate.scrollToPositionWithOffset(firstPosDate + 1, offsetDate);
                                            Log.e("test_scroll", "firstPosType: " +
                                                    firstPosType + ", firstPosDate: " +
                                                    firstPosDate + ", offset: " + offsetDate);
                                        }
                                    }
                                } else { //餐段
                                    LinearLayoutManager layoutManager = (LinearLayoutManager) observerRecyclerView.getLayoutManager();
                                    if (layoutManager != null) {
                                        layoutManager.scrollToPositionWithOffset(firstPos + 1, firstRight);
//                                        Log.e("test_scroll", "firstPos: " +
//                                                firstPos + ", firstRight: " + firstRight);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        rvDate.addOnScrollListener(mOnScrollListener);
        rvType1.addOnScrollListener(mOnScrollListener);
        rvType2.addOnScrollListener(mOnScrollListener);
    }
}
