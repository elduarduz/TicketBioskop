package com.example.ticketbioskop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ticketbioskop.menuFragment.Topup;
import com.google.firebase.auth.FirebaseAuth;

public class userprofile extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
    }

    public void topup(View view){
        startActivity(new Intent(getApplicationContext(), Topup.class));
        finish();
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finishAffinity();
    }


    public void editProfile(View view){
        startActivity(new Intent(getApplicationContext(), Home.class));
        finish();
    }

    public void isiulang(View view) {
        startActivity(new Intent(getApplicationContext(), Topup.class));
        finish();
    }

}

