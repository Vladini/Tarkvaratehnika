package com.example.user.traveleasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TripsCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_calendar);
    }


    public void showCalendar(View view) {
        Intent intent = new Intent(this, TripsCalendar.class);
        startActivity(intent);
    }

    public void showNotes(View view) {
        Intent intent = new Intent(this, TripsNotes.class);
        startActivity(intent);
    }
}

