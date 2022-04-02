package com.example.todoroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")

public class Task {

    @PrimaryKey
    @ColumnInfo(name = "title")
    @NonNull
    private String titleTask;

    @ColumnInfo(name = "date")
    @NonNull
    private String dateTask;

    @ColumnInfo(name = "time")
    @NonNull
    private String timeTask;

    public Task(@NonNull String titleTask, String dateTask, String timeTask) {
        this.titleTask = titleTask;
        this.dateTask = dateTask;
        this.timeTask = timeTask;
    }

    @NonNull
    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(@NonNull String titleTask) {
        this.titleTask = titleTask;
    }

    @NonNull
    public String getDateTask() {
        return dateTask;
    }

    public void setDateTask(@NonNull String dateTask) {
        this.dateTask = dateTask;
    }

    @NonNull
    public String getTimeTask() {
        return timeTask;
    }

    public void setTimeTask(@NonNull String timeTask) {
        this.timeTask = timeTask;
    }
}
