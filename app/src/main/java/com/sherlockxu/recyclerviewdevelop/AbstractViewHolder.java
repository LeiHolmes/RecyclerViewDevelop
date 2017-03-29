package com.sherlockxu.recyclerviewdevelop;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description:   不同ViewHolder的抽象类
 * author         xulei
 * Date           2017/3/29
 */

abstract public class AbstractViewHolder extends RecyclerView.ViewHolder {
    public AbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(DataBean bean);
}
