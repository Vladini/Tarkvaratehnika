package com.example.user.traveleasy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ActiveTripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_trips);

    }

    public void showActiveTrips(View view) {
        final LinearLayout layout = (LinearLayout) findViewById(R.id.ll2);
        layout.removeAllViews();
        DBHandler db = new DBHandler(this);
        List<Trip> trips = db.getAllTrips();
        for (final Trip trip : trips) {

            TextView tv1 = new TextView(view.getContext());
            TextView tv2 = new TextView(view.getContext());
            tv1.setTextSize(18);
            tv2.setTextSize(18);
            tv1.setTextColor(Color.BLACK);
            tv2.setTextColor(Color.BLACK);
            tv1.setText(trip.getName() + " " + trip.getStartDate() + " - " + trip.getEndDate());
            tv2.setText("Status: active");
            tv1.setBackgroundColor(Color.YELLOW);
            tv2.setBackgroundColor(Color.YELLOW);
            tv1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ActiveTripsActivity.this, TripProfileActivity.class));
                    TripProfileActivity.index = trip.getId();
                }
            });
            try{

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String str1 = trip.getStartDate().replace(".","/");
                Date date1 = formatter.parse(str1);
                String str3 = trip.getEndDate().replace(".","/");
                Date date3 = formatter.parse(str3);
                String str2 = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                Date date2 = formatter.parse(str2);

                if (date1.compareTo(date2)<0 && date3.compareTo(date2)>0)
                {
                    layout.addView(tv1);
                    layout.addView(tv2);
                }

            }catch (ParseException e1){
                e1.printStackTrace();
            }


        }
    }

}
