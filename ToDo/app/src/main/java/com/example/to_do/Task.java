package com.example.to_do;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "task_table")

    public class Task {

        @PrimaryKey(autoGenerate = true)
        @NonNull
        int id;

        @ColumnInfo(name = "title")
        @NonNull
        private String title;

        @ColumnInfo(name = "date")
        @NonNull
        private String date;

        @ColumnInfo(name = "time")
        @NonNull
        private String time;

        Task(String title, String date, String time) {
            this.title = title;
            this.date = date;
            this.time = time;
        }

        int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }


    }