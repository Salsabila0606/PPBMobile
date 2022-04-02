package com.example.todoroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TextView vtitle ;
    private final TextView vdate ;
    private final TextView vtime ;
    LinearLayout layout;

    private TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        vtitle = itemView.findViewById(R.id.titleView);
        vdate = itemView.findViewById(R.id.dateView);
        vtime = itemView.findViewById(R.id.timeView);
        layout = itemView.findViewById(R.id.linearLayout);
    }

    public void bind(String title, String date, String time) {
        vtitle.setText(title);
        vdate.setText(date);
        vtime.setText(time);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_to_do, parent, false);
        return new TaskViewHolder(view);
    }
}
