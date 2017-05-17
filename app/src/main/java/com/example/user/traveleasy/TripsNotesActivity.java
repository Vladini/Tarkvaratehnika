package com.example.user.traveleasy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TripsNotesActivity extends AppCompatActivity {
    public static int index;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips_notes);
        textView = (TextView)findViewById(R.id.noteText);
        DBHandler db = new DBHandler(this);
        textView.setText(db.getTrip(index).getNotes());
    }

    public void addNotes(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("New Note");


        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(textView.getText() == ""){
                    String s = textView.getText() + input.getText().toString();
                    textView.setText(s);
                }else{
                    String s = textView.getText() +  "\n" + input.getText().toString();
                    textView.setText(s);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void saveNotes(View view) {
        DBHandler db = new DBHandler(this);
        Trip trip = new Trip(index, db.getTrip(index).getName(),db.getTrip(index).getStartDate(), db.getTrip(index).getEndDate(), db.getTrip(index).getOverallBudget(), db.getTrip(index).getHotelExpenses(), db.getTrip(index).getTicketsExpenses(), textView.getText().toString(), db.getTrip(index).getOtherExpenses());
        db.updateTrip(trip);
    }

    public void deleteNotes(View view) {
        textView.setText("");
    }
}
