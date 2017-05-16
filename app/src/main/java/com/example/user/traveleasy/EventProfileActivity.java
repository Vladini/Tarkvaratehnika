package com.example.user.traveleasy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EventProfileActivity extends AppCompatActivity {
    public static int eventIndex;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_profile);
        textView = (TextView) findViewById(R.id.textView2);
        DBHandler2 db = new DBHandler2(this);
        textView.setText(db.getEvent(eventIndex).getTime() + " " + db.getEvent(eventIndex).getText());

    }

    public void deleteEvent(View view) {
        final DBHandler2 db = new DBHandler2(this);
        AlertDialog alertDialog = new AlertDialog.Builder(EventProfileActivity.this).create();
        alertDialog.setTitle("Deleting");
        alertDialog.setMessage("Are you sure you want to delete this event?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteEvent(db.getEvent(eventIndex));
                        dialog.dismiss();
                        startActivity(new Intent(EventProfileActivity.this, EventActivity.class));
                        Toast.makeText(getApplicationContext(),"This event was deleted",
                                Toast.LENGTH_SHORT).show();

                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
