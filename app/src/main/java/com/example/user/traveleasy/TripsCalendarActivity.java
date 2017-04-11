package com.example.vlad.traveleasytest;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TripsCalendarActivity extends AppCompatActivity {
    public static int index;
    public static String event;
    TextView textView;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_calendar);
        DBHandler db = new DBHandler(this);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(db.getTrip(index).getName());
        calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setFirstDayOfWeek(2);
        String input = db.getTrip(index).getStartDate();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long milliseconds = date.getTime();
        calendarView.setDate(milliseconds);
    }


    public void showNotes(View view) {
        Intent intent = new Intent(this, TripsNotesActivity.class);
        startActivity(intent);
    }

    public void editTrip(View view) {
        startActivity(new Intent(TripsCalendarActivity.this, TripProfileActivity.class));
        TripProfileActivity.index = index;
    }

    public void editBudget(View view) {
        startActivity(new Intent(TripsCalendarActivity.this, BudgetActivity.class));
        BudgetActivity.index = index;
    }

    public void addEvent(View view) {
        startActivity(new Intent(TripsCalendarActivity.this,EventActivity.class));
        calendarView.getDate();
        EventActivity.date_ms = calendarView.getDate();
    }
}
