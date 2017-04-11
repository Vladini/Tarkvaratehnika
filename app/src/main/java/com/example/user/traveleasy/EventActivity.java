package com.example.user.traveleasy;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventActivity extends AppCompatActivity {
    public static long date_ms;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        textView = (TextView) findViewById(R.id.textView3);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(new Date(date_ms));
        textView.setText(dateString);
        editText = (EditText) findViewById(R.id.editText2);
    }

    public void importToCalender(View view) {
        startActivity(new Intent(EventActivity.this, TripsCalendarActivity.class));
        TripsCalendarActivity.event =  editText.getText().toString();
    }
}
