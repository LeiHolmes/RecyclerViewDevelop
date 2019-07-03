package com.sherlockxu.recyclerviewdevelop.linkplus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sherlockxu.recyclerviewdevelop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/28
 */

public class HoriListAdapter extends RecyclerView.Adapter<HoriListAdapter.MyViewHolder> {
    private Context context;
    private List<HoriDataModel> list = new ArrayList<>();
    private LayoutInflater inflater;

    public HoriListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<HoriDataModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_recyclerview_hori, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HoriDataModel horiDataModel = list.get(position);
        holder.tvDate.setText(horiDataModel.getDate());
        holder.tvPlaceName.setText(horiDataModel.getPlaceName());
        holder.tvPeoples.setText(horiDataModel.getPeoples());
        holder.tvSubjects.setText(horiDataModel.getSubject());
        holder.tvPlaceRemark.setText(horiDataModel.getPlaceRemark());
        holder.tvFoodRemark.setText(horiDataModel.getFoodRemark());
        holder.tvRoomRemark.setText(horiDataModel.getRoomRemark());
        holder.tvRequirements.setText(horiDataModel.getRequirement());
        holder.tvDeposit.setText(horiDataModel.getDeposit());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvPlaceName;
        TextView tvPeoples;
        TextView tvSubjects;
        TextView tvPlaceRemark;
        TextView tvFoodRemark;
        TextView tvRoomRemark;
        TextView tvRequirements;
        TextView tvDeposit;

        MyViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvPlaceName = (TextView) itemView.findViewById(R.id.tv_place_name);
            tvPeoples = (TextView) itemView.findViewById(R.id.tv_peoples);
            tvSubjects = (TextView) itemView.findViewById(R.id.tv_subjects);
            tvPlaceRemark = (TextView) itemView.findViewById(R.id.tv_place_remark);
            tvFoodRemark = (TextView) itemView.findViewById(R.id.tv_food_remark);
            tvRoomRemark = (TextView) itemView.findViewById(R.id.tv_room_remark);
            tvRequirements = (TextView) itemView.findViewById(R.id.tv_requirements);
            tvDeposit = (TextView) itemView.findViewById(R.id.tv_deposit);
        }
    }
}
