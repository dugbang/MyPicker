package com.example.shbae.mypicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    DateTimePicker picker;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        //textView.setText("...");
        picker = (DateTimePicker) findViewById(R.id.picker);

        picker.setOnDateTimeChangeListener(new OnDateTimeChangeListener() {
            @Override
            public void onDateTimeChange(DateTimePicker view, int year, int monthOfYear, int day, int hour, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, day, hour, minute);
                String curTime = format.format(calendar.getTime());

                textView.setText(curTime);

                // 호출되지 않음... 이유는?
                Toast.makeText(getApplicationContext(), "excute..", Toast.LENGTH_LONG).show();
            }
        });


    }
}
