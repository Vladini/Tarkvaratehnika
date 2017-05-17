package com.example.user.traveleasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showTrips(View view) {
        Intent intent = new Intent(this, RecentTripsActivity.class);
        startActivity(intent);
    }


    public void addTrip(View view) {
        Intent intent = new Intent(this, NewTripActivity.class);
        startActivity(intent);
    }

    public void showActiveTrips(View view) {
        Intent intent = new Intent(this, ActiveTripsActivity.class);
        startActivity(intent);

    }
}


