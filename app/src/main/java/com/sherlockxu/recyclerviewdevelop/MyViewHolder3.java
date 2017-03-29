package com.sherlockxu.recyclerviewdevelop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description:   第三种类型的ViewHolder
 * author         xulei
 * Date           2017/3/29
 */

public class MyViewHolder3 extends AbstractViewHolder {
    TextView tvName;
    TextView tvcContent;
    ImageView ivHead;
    ImageView ivContent;

    public MyViewHolder3(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.item_tv_name);
        tvcContent = (TextView) itemView.findViewById(R.id.item_tv_content);
        ivHead = (ImageView) itemView.findViewById(R.id.item_iv_head);
        ivContent = (ImageView) itemView.findViewById(R.id.item_iv_content);
    }

    @Override
    public void bindData(DataBean bean) {
        tvName.setText(bean.getName());
        tvcContent.setText(bean.getContentName());
        ivHead.setImageResource(bean.getHeadColor());
        ivContent.setImageResource(bean.getContentColor());
    }
}
