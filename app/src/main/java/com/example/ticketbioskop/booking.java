package com.example.ticketbioskop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking extends Activity {

    Button cinema,movie;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);
        //TabHost tabHost = getTabHost();

//	        // Tab for Cinemas
//	        TabSpec cinemaspec = tabHost.newTabSpec("Cinemas");
//	        // setting Title and Icon for the Tab
//	        cinemaspec.setIndicator("NEARBY CINEMAS");
//	        Intent cinemaIntent = new Intent(this, MainActivity.class);
//	        cinemaspec.setContent(cinemaIntent);
//
//	        // Tab for Movies
//	        TabSpec moviespec = tabHost.newTabSpec("Movies");
//	        moviespec.setIndicator("LIST OF MOVIES");
//	        Intent movieIntent = new Intent(this, Cinemas.class);
//	        moviespec.setContent(movieIntent);
//
//
//	        // Adding all TabSpec to TabHost
//
//	        tabHost.addTab(moviespec); // Adding movies tab
//	        tabHost.addTab(cinemaspec); // Adding cinemas tab
//	        tabHost.setCurrentTabByTag("Movies");

        cinema= findViewById(R.id.tabs);
        movie= findViewById(R.id.tabcontent);
    }


    public void cinemaBtn(View view)
    {
        intent = new Intent(this, CinemasCopy.class);
        startActivity(intent);
    }

    public void nearByBtn(View view)
    {
        intent = new Intent(this, HomeFragment.class);
        startActivity(intent);
    }


    public void onBackPressed()
    {

        new AlertDialog.Builder(this).setTitle("EXIT").setMessage("Do you want to Exit?").setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }).setNegativeButton("No",null).show();






    }

}
