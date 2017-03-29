package com.sherlockxu.recyclerviewdevelop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    /**
     * 不同ViewHolder的抽象类
     */
    abstract class AbstractViewHolder extends RecyclerView.ViewHolder {

        public AbstractViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindData(DataBean bean);
    }

    class MyViewHolder1 extends AbstractViewHolder {
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

    class MyViewHolder2 extends AbstractViewHolder {
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

    class MyViewHolder3 extends AbstractViewHolder {
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
}
