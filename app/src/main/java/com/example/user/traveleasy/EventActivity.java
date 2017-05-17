package com.example.user.traveleasy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EventActivity extends AppCompatActivity {
    public static String dateString;
    TextView textView;
    EditText editText;
    EditText editText2;
    TextView plannedEvents;
    String eventsList = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        DBHandler2 db = new DBHandler2(this);
        textView = (TextView) findViewById(R.id.textView3);
        textView.setText(dateString);
        editText = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText3);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.ll2);
        List<Event> events = db.getAllEvents();
        for (final Event event : events) {
            if(event.getDate().equals(dateString)){
                TextView tv1 = new TextView(EventActivity.this);
                tv1.setTextSize(18);
                tv1.setTextColor(Color.WHITE);
                tv1.setText(event.getTime() + " " + event.getText());
                layout.addView(tv1);
                tv1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(EventActivity.this, EventProfileActivity.class));
                        EventProfileActivity.eventIndex = event.getId();
                    }
                });
            }
        }
//        List<Event> events = db.getAllEvents();
//        for (Event event : events) {
//            if(event.getDate().equals(dateString)){
//                eventsList = eventsList + event.getTime() + " " + event.getText() + "\n";
//            }
//        }
//        plannedEvents.setText(eventsList);
    }

    public void importToCalender(View view) {
//        final LinearLayout layout = (LinearLayout) findViewById(R.id.ll2);
        if(editText.getText().toString().length()!=0) {
            DBHandler2 db = new DBHandler2(this);
            db.addEvent(new Event(1, dateString, editText.getText().toString(), editText2.getText().toString()));
//            List<Event> events = db.getAllEvents();
//            for (Event event : events) {
//                if(event.getDate().equals(dateString)){
//                    TextView tv1 = new TextView(view.getContext());
//                    tv1.setTextSize(18);
//                    tv1.setTextColor(Color.WHITE);
//                    tv1.setText(event.getTime() + " " + event.getText());
//                    layout.addView(tv1);
//                }
//            }
            startActivity(new Intent(EventActivity.this, TripsCalendarActivity.class));
            Toast.makeText(getApplicationContext(),"Your event has been imported",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
