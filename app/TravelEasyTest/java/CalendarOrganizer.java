package com.example.user.traveleasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CalendarOrganizer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_organizer);
    }

    public void addEvent(View view) {
        Intent intent = new Intent(this, CalendarOrganizer.class);
        startActivity(intent);
    }
}
