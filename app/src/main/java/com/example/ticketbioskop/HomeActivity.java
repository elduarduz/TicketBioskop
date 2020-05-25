package com.example.ticketbioskop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

    }

    public void profil(View view){
        startActivity(new Intent(getApplicationContext(), userprofile.class));
        finish();
    }
}
