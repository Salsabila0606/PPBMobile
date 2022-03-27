package com.example.to_do;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.to_do.EXTRA_TITLE";
    public static final String EXTRA_DATE = "com.example.to_do.EXTRA_DATE";
    public static final String EXTRA_TIME = "com.example.to_do.EXTRA_TIME";


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        showAddDialog();
    }

    //implementasi add_to_do
    @SuppressLint("SimpleDateFormat")
    private void showAddDialog () {

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getLayoutInflater().getContext());
            LayoutInflater inflater = this.getLayoutInflater();
            @SuppressLint("InflateParams") final View dialogView = inflater.inflate(R.layout.add_to_do, null);
            dialogBuilder.setView(dialogView);

            final EditText judul = dialogView.findViewById(R.id.title);
            final TextView tanggal = dialogView.findViewById(R.id.date);
            final TextView waktu = dialogView.findViewById(R.id.time);

            final long date = System.currentTimeMillis();
            SimpleDateFormat dateSdf = new SimpleDateFormat("d MMMM");
            String dateString = dateSdf.format(date);
            tanggal.setText(dateString);

            SimpleDateFormat timeSdf = new SimpleDateFormat("hh : mm a");
            String timeString = timeSdf.format(date);
            waktu.setText(timeString);

            final Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());

            //Set tanggal
            tanggal.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {
                    final DatePickerDialog datePickerDialog = new DatePickerDialog(getLayoutInflater().getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    String newMonth = getMonth(monthOfYear + 1);
                                    tanggal.setText(dayOfMonth + " " + newMonth);
                                    cal.set(Calendar.YEAR, year);
                                    cal.set(Calendar.MONTH, monthOfYear);
                                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                }
                            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.show();
                    datePickerDialog.getDatePicker().setMinDate(date);
                }
            });

            //Set waktu
            waktu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(getLayoutInflater().getContext(),
                            new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                    String time;
                                    @SuppressLint("DefaultLocale") String minTime = String.format("%02d", minute);
                                    if (hourOfDay >= 0 && hourOfDay < 12) {
                                        time = hourOfDay + " : " + minTime + " AM";
                                    } else {
                                        if (hourOfDay != 12) {
                                            hourOfDay = hourOfDay - 12;
                                        }
                                        time = hourOfDay + " : " + minTime + " PM";
                                    }
                                    waktu.setText(time);
                                    cal.set(Calendar.HOUR, hourOfDay);
                                    cal.set(Calendar.MINUTE, minute);
                                    cal.set(Calendar.SECOND, 0);
                                    Log.d(TAG, "onTimeSet: Time has been set successfully");
                                }
                            }, cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), false);
                    timePickerDialog.show();
                }
            });

            dialogBuilder.setTitle("Buat tugas baru");
            dialogBuilder.setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent replyIntent = new Intent();
                    if (TextUtils.isEmpty(judul.getText())) {
                        toastMsg("Oops, Gak bisa kosong tugas nya.");
                        setResult(RESULT_CANCELED, replyIntent);
                    } else {
                        String taskTitle = judul.getText().toString();
                        replyIntent.putExtra(EXTRA_TITLE, taskTitle);
                        String taskDate = tanggal.getText().toString();
                        replyIntent.putExtra(EXTRA_DATE, taskDate);
                        String taskTime = waktu.getText().toString();
                        replyIntent.putExtra(EXTRA_TIME, taskTime);
                        setResult(RESULT_OK, replyIntent);
                    }
                    finish();
                }
//            //implementasi button save
//            public void onClick(DialogInterface dialog, int whichButton) {
//
//                String title = judul.getText().toString();
//                    String date = tanggal.getText().toString();
//                    String time = waktu.getText().toString();
//                    if (title.length() != 0) {
//                        try {
//                            insertDataToDb(title, date, time);
//                            scheduleNotification(getNotification(title), cal.getTimeInMillis());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        toastMsg("Oops, Gak bisa kosong tugas nya.");
//                    }
//                }
//            });
                //implementasi button cancel
//            dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int whichButton) {
//                    dialog.cancel();
//                }
            });
            AlertDialog b = dialogBuilder.create();
            b.show();
        }

    //Metode pesan toast
    private void toastMsg (String msg){
        Toast t = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }

    //Mengkonversi bulan dari huruf menjadi angka
    private String getMonth ( int month){
        return new DateFormatSymbols().getMonths()[month - 1];
    }
}
