package com.example.to_do;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;

public class TaskListAdapter extends ListAdapter<Task, TaskViewHolder> {

    private Context context;

    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback) {
        super(diffCallback);
//        this.context = context;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current.getTitle(),current.getDate(),current.getTime());
//        holder.layoutView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent item = new Intent(context, TaskDetail.class);
////                item.putExtra(NewTaskActivity.EXTRA_TITLE,currentT.getTitle());
////                item.putExtra(NewTaskActivity.EXTRA_DATE,currentT.getDate());
////                item.putExtra(NewTaskActivity.EXTRA_TIME,currentT.getTime());
//                context.startActivity(item);
//            }
//        });
    }

    static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
