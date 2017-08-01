package com.example.a127107.demodialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Tally against the respective action item clicked
        //  and implement the appropriate action
        if (item.getItemId() == R.id.itemConfirmation) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are you sure?")
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "You clicked yes",
                                    Toast.LENGTH_LONG).show();
                        }
                    })
                    // Set text for the negative button and the corresponding
                    //  OnClickListener when it is clicked
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "You clicked no",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // Create the AlertDialog object and return it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (item.getItemId() == R.id.itemSimpleList) {
            String [] list = new String[] { "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday" };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Which is your freest weekday?")
                    // Set the list of items easily by just supplying an
                    //  array of the items
                    .setItems(list, new DialogInterface.OnClickListener() {
                        // The parameter "which" is the item index
                        // clicked, starting from 0
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                Toast.makeText(MainActivity.this, "You said Monday",
                                        Toast.LENGTH_LONG).show();
                            } else if (which == 4) {
                                Toast.makeText(MainActivity.this, "You said Friday",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, "You said middle of the week",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }else if (item.getItemId() == R.id.itemPassPhrase) {
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout passPhrase =
                    (LinearLayout) inflater.inflate(R.layout.parsephase, null);
            final EditText etPassphrase = (EditText) passPhrase
                    .findViewById(R.id.editTextPassPhrase);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Please Enter")
                    .setView(passPhrase)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(MainActivity.this, "You had entered " +
                                    etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }




        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

}
