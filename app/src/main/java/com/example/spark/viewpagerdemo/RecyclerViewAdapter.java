package com.example.spark.viewpagerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<TasksModel> mData;

    public RecyclerViewAdapter(Context mContext, List<TasksModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_tasks, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.time_date.setText(mData.get(position).getTime_date());
        holder.task_Status.setImageResource(mData.get(position).getTaskStatus());
        holder.task_details.setText(mData.get(position).getTask_details());
        holder.task_Color.setBackgroundResource(mData.get(position).getTaskColor());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView time_date;
        private TextView task_details;
        private ImageView task_Status;
        private View task_Color;

        public MyViewHolder(View itemView) {
            super(itemView);
                task_Status = itemView.findViewById(R.id.taskStatus);
                time_date = itemView.findViewById(R.id.time_date);
                task_details = itemView.findViewById(R.id.task_details);
                task_Color = itemView.findViewById(R.id.left_view);
        }
    }
}

