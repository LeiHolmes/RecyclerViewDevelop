package com.sherlockxu.recyclerviewdevelop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description:   第二种类型的ViewHolder
 * author         xulei
 * Date           2017/3/29
 */

public class MyViewHolder2 extends AbstractViewHolder {
    TextView tvName;
    ImageView ivHead;

    public MyViewHolder2(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.item_tv_name);
        ivHead = (ImageView) itemView.findViewById(R.id.item_iv_head);
    }

    @Override
    public void bindData(DataBean bean) {
        tvName.setText(bean.getName());
        ivHead.setImageResource(bean.getHeadColor());
    }
}

