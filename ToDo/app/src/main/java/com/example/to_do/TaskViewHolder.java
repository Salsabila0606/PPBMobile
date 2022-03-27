package com.example.to_do;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class TaskViewHolder extends RecyclerView.ViewHolder {

    LinearLayout layoutView;
    private Activity dialogView;
    private final TextView judul ;
//    private final TextView tanggal ;
//    private final TextView waktu ;

    private TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        judul = dialogView.findViewById(R.id.title);
//        tanggal = dialogView.findViewById(R.id.title);
//        waktu = dialogView.findViewById(R.id.title);
    }

    public void bind(String title, String date, String time) {
        judul.setText(title);
//        tanggal.setText(title);
//        waktu.setText(title);
        layoutView = itemView.findViewById(R.id.titleRow);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_to_do, parent, false);
        return new TaskViewHolder(view);
    }
}
