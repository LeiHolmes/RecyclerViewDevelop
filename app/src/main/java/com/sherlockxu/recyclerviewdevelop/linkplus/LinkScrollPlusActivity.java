package com.sherlockxu.recyclerviewdevelop.linkplus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.sherlockxu.recyclerviewdevelop.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinkScrollPlusActivity extends AppCompatActivity {
    @BindView(R.id.ll_container)
    LinearLayout llContainer;
    private HashSet<RecyclerView> observerList = new HashSet<>();
    private List<DemandModel> demandList;
    private List<List<String>> showList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_scroll_plus);
        ButterKnife.bind(this);
        initStateAndData();
        initView();
        initListener();
    }

    private void initStateAndData() {
        demandList = new ArrayList<>();
        demandList.add(new DemandModel("就餐时间", "桌台名称", "就餐人数", "操作"));
        demandList.add(new DemandModel("2018.12.27  12:30", "1楼卡座A0121楼卡座A0121楼卡座A0121楼卡座A0121楼卡座A0121楼卡座A012", "4", "免费茶水"));
        demandList.add(new DemandModel("2019.05.18  10:00", "2楼包厢B008", "12", "专职服务员"));
        demandList.add(new DemandModel("2019.06.12  11:45", "3楼宴会厅C666", "120", "配套音响设备"));
        showList = new ArrayList<>();
        for (DemandModel demandModel : demandList) {
            List<String> itemList = new ArrayList<>();
            itemList.add(demandModel.getMealTime());
            itemList.add(demandModel.getTableName());
            itemList.add(demandModel.getPeopleNum());
            itemList.add(demandModel.getOperate());
            showList.add(itemList);
        }
    }

    private void initView() {
        for (List<String> itemList : showList) {
            initRecyclerView(itemList);
        }
    }

    private void initListener() {

    }

    @SuppressLint("ClickableViewAccessibility")
    public void initRecyclerView(List<String> itemList) {
        RecyclerView recyclerView = new RecyclerView(this);
        DemandListAdapter adapter = new DemandListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        llContainer.addView(recyclerView);
        observerList.add(recyclerView);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        for (RecyclerView rv : observerList) {
                            rv.stopScroll();
                        }
                }
                return false;
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!(recyclerView.getTag() != null && recyclerView.getTag().equals("date"))) { //滑动日期不联动
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int firstPos = linearLayoutManager.findFirstVisibleItemPosition();
                    View firstVisibleItem = linearLayoutManager.getChildAt(0);
                    if (firstVisibleItem != null) {
                        int firstRight = linearLayoutManager.getDecoratedRight(firstVisibleItem);
                        int firstWidth = firstVisibleItem.getWidth();
                        for (RecyclerView observerRecyclerView : observerList) {
                            if (recyclerView != observerRecyclerView) {
                                LinearLayoutManager layoutManager = (LinearLayoutManager) observerRecyclerView.getLayoutManager();
                                if (layoutManager != null) {
                                    layoutManager.scrollToPositionWithOffset(firstPos + 1, firstRight);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                    Log.e("test_scroll", "newState: " + newState);
            }
        });
        adapter.setList(itemList);
    }
}
