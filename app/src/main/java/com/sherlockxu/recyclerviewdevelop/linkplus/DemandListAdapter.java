package com.sherlockxu.recyclerviewdevelop.linkplus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sherlockxu.recyclerviewdevelop.DataBean;
import com.sherlockxu.recyclerviewdevelop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/28
 */

public class DemandListAdapter extends RecyclerView.Adapter<DemandListAdapter.MyViewHolder> {
    private Context context;
    private List<String> list = new ArrayList<>();
    private LayoutInflater inflater;

    public DemandListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_recyclerview_demand, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvContent.setText(list.get(position));
        ViewGroup.LayoutParams layoutParams = holder.llContainer.getLayoutParams();
        layoutParams.width = (int) ViewUtil.dpToPx(context, 70);
        switch (position) {
            case 0:
                layoutParams.width = (int) ViewUtil.dpToPx(context, 140);
                break;
            case 1:
                layoutParams.width = (int) ViewUtil.dpToPx(context, 175);
                break;
            case 2:
                layoutParams.width = (int) ViewUtil.dpToPx(context, 70);
                break;
            case 3:
                layoutParams.width = (int) ViewUtil.dpToPx(context, 200);
                break;
        }
        holder.llContainer.setLayoutParams(layoutParams);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        RelativeLayout llContainer;

        MyViewHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            llContainer = (RelativeLayout) itemView.findViewById(R.id.ll_container);
        }
    }
}
