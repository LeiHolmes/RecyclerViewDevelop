package com.sherlockxu.recyclerviewdevelop;

import android.view.View;
import android.widget.TextView;

/**
 * Description:   第一种类型的ViewHolder
 * author         xulei
 * Date           2017/3/29
 */

public class MyViewHolder1 extends AbstractViewHolder {
    TextView tvName;

    public MyViewHolder1(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.item_tv_name);
    }

    @Override
    public void bindData(DataBean bean) {
        tvName.setText(bean.getName());
    }
}
