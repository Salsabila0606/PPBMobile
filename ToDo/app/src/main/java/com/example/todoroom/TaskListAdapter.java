package com.example.todoroom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskListAdapter extends ListAdapter<Task,TaskViewHolder> {

    Context context;

    protected TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current.getTitleTask(),current.getDateTask(),current.getTimeTask());
        holder.layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent item = new Intent(context, TaskDetailActivity.class);
                item.putExtra("titlename",current.getTitleTask());
                item.putExtra("datename",current.getDateTask());
                item.putExtra("timename",current.getTimeTask());
                context.startActivity(item);
            }
        });
    }

    static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTitleTask().equals(newItem.getTitleTask());
        }
    }
}
