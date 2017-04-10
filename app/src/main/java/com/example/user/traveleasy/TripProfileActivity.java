package com.example.user.traveleasy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TripProfileActivity extends AppCompatActivity {
    public static int index;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_profile);
        DBHandler db = new DBHandler(this);
/*        editText = (EditText) findViewById(R.id.editText11);
        editText2 = (EditText) findViewById(R.id.editText13);
        editText3 = (EditText) findViewById(R.id.editText14);
        editText4 = (EditText) findViewById(R.id.editText2);
        editText5 = (EditText) findViewById(R.id.editText9);
        editText6 = (EditText) findViewById(R.id.editText10);*/
        editText.setText(db.getTrip(index).getName());
        editText2.setText(db.getTrip(index).getStartDate());
        editText3.setText(db.getTrip(index).getEndDate());
        editText4.setText(String.valueOf(db.getTrip(index).getOverallBudget()));
        editText5.setText(String.valueOf(db.getTrip(index).getHotelExpenses()));
        editText6.setText(String.valueOf(db.getTrip(index).getTicketsExpenses()));
    }


/*    public void saveChanges(View view) {
        Trip trip = new Trip(index, editText.getText().toString(),editText2.getText().toString(), editText3.getText().toString(), Double.parseDouble(editText4.getText().toString()), Double.parseDouble(editText5.getText().toString()), Double.parseDouble(editText6.getText().toString()) );
        DBHandler db = new DBHandler(this);
        db.updateTrip(trip);
        AlertDialog alertDialog = new AlertDialog.Builder(TripProfileActivity.this).create();
        alertDialog.setTitle("Saved");
        alertDialog.setMessage("All changes saved!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

    public void deleteTrip(View view) {
        final Trip trip = new Trip(index, editText.getText().toString(),editText2.getText().toString(), editText3.getText().toString(), Double.parseDouble(editText4.getText().toString()), Double.parseDouble(editText5.getText().toString()), Double.parseDouble(editText6.getText().toString()) );
        final DBHandler db = new DBHandler(this);
        db.updateTrip(trip);
        AlertDialog alertDialog = new AlertDialog.Builder(TripProfileActivity.this).create();
        alertDialog.setTitle("Deleting");
        alertDialog.setMessage("Are you sure you want to delete this trip?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        db.updateTrip(trip);
                        db.deleteTrip(trip);
                        dialog.dismiss();
                        editText.setText("");
                        editText2.setText("");
                        editText3.setText("");
                        editText4.setText("");
                        editText5.setText("");
                        editText6.setText("");
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }*/

    public void showCalendar(View view) {
        Intent intent = new Intent(this, TripsCalendar.class);
        startActivity(intent);
    }

    public void showNotes(View view) {
        Intent intent = new Intent(this, TripsNotes.class);
        startActivity(intent);
    }
}
