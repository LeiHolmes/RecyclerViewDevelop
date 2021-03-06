package com.sherlockxu.recyclerviewdevelop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/28
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DataBean> list;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataBean.TYPE_ONE:
                return new MyViewHolder1(inflater.inflate(R.layout.item_recyclerview_type1, parent, false));
            case DataBean.TYPE_TWO:
                return new MyViewHolder2(inflater.inflate(R.layout.item_recyclerview_type2, parent, false));
            case DataBean.TYPE_THREE:
                return new MyViewHolder3(inflater.inflate(R.layout.item_recyclerview_type3, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AbstractViewHolder) holder).bindData(list.get(position));
    }
}
