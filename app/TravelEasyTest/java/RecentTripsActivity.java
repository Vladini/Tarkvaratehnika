package com.example.vlad.traveleasytest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecentTripsActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_trips);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void searchForTrip(View view) throws ParseException {
        final LinearLayout layout = (LinearLayout) findViewById(R.id.ll2);
        layout.removeAllViews();
        DBHandler db = new DBHandler(this);
        List<Trip> trips = db.getAllTrips();
        for (final Trip trip : trips) {
            if (editText.getText().toString().equals(trip.getName())) {
                TextView tv1 = new TextView(view.getContext());
                TextView tv2 = new TextView(view.getContext());
                tv1.setTextSize(18);
                tv2.setTextSize(18);
                tv1.setTextColor(Color.BLACK);
                tv2.setTextColor(Color.BLACK);
                tv1.setText(editText.getText().toString() + " " + trip.getStartDate() + " - " + trip.getEndDate());
                try{

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


                    String str1 = trip.getStartDate().replace(".","/");
                    Date date1 = formatter.parse(str1);
                    String str3 = trip.getEndDate().replace(".","/");
                    Date date3 = formatter.parse(str3);

                    String str2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                    Date date2 = formatter.parse(str2);

                    if (date3.compareTo(date2)<0)
                    {
                        tv2.setText("Status: past");
                        tv1.setBackgroundColor(Color.LTGRAY);
                        tv2.setBackgroundColor(Color.LTGRAY);
                    } else if (date1.compareTo(date2)>0){
                        tv2.setText("Status: future");
                        tv1.setBackgroundColor(Color.GREEN);
                        tv2.setBackgroundColor(Color.GREEN);
                    }else if (date1.compareTo(date2)<0 && date3.compareTo(date2)>0){
                        tv2.setText("Status: active");
                        tv1.setBackgroundColor(Color.YELLOW);
                        tv2.setBackgroundColor(Color.YELLOW);
                    }

                }catch (ParseException e1){
                    e1.printStackTrace();
                }
                tv1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RecentTripsActivity.this, TripProfileActivity.class));
                        TripProfileActivity.index = trip.getId();
                    }
                });
                layout.addView(tv1);
                layout.addView(tv2);
//                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//                Date strDate = sdf.parse(trip.getStartDate());
//                if (new Date().after(strDate)) {
//                    tv2.setText("FUTURE");
//                }
            } else if(editText.getText().toString().matches("")){
                TextView tv1 = new TextView(view.getContext());
                TextView tv2 = new TextView(view.getContext());
                tv1.setTextSize(16);
                tv1.setTextColor(Color.BLACK);
                tv2.setTextSize(16);
                tv2.setTextColor(Color.BLACK);
                tv1.setText(trip.getName() + " " + trip.getStartDate() + " - " + trip.getEndDate());
                try{

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


                    String str1 = trip.getStartDate().replace(".","/");
                    Date date1 = formatter.parse(str1);
                    String str3 = trip.getEndDate().replace(".","/");
                    Date date3 = formatter.parse(str3);

                    String str2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                    Date date2 = formatter.parse(str2);

                    if (date3.compareTo(date2)<0)
                    {
                        tv2.setText("Status: past");
                        tv1.setBackgroundColor(Color.LTGRAY);
                        tv2.setBackgroundColor(Color.LTGRAY);
                    } else if (date1.compareTo(date2)>0){
                        tv2.setText("Status: future");
                        tv1.setBackgroundColor(Color.GREEN);
                        tv2.setBackgroundColor(Color.GREEN);
                    }else if (date1.compareTo(date2)<0 && date3.compareTo(date2)>0){
                        tv2.setText("Status: active");
                        tv1.setBackgroundColor(Color.YELLOW);
                        tv2.setBackgroundColor(Color.YELLOW);
                    }

                }catch (ParseException e1){
                    e1.printStackTrace();
                }
                tv1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RecentTripsActivity.this, TripProfileActivity.class));
                        TripProfileActivity.index = trip.getId();
                    }
                });
                layout.addView(tv1);
                layout.addView(tv2);
//                String valid_until = "01.07.2018";
//                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//                Date strDate = null;
//                try {
//                    strDate = sdf.parse(valid_until);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                if (new Date().after(strDate)) {
//                    tv2.setText("FUTURE");
//                }
            }
        }
//            String log = "Id: " + trip.getId() + " ,Name: " + trip.getName() + " ,Start Date: " + trip.getStartDate() + " ,End Date: " + trip.getEndDate() + " ,Budget: " + trip.getOverallBudget() + " ,Hotel Expenses: " + trip.getHotelExpenses() + " ,Tickets Expenses: " + trip.getTicketsExpenses();
//            Log.d("Trip: : ", log);
        }
    }

