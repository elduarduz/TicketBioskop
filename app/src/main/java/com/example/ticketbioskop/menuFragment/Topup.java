package com.example.ticketbioskop.menuFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ticketbioskop.Home;
import com.example.ticketbioskop.R;
import com.example.ticketbioskop.Saldo;
import com.example.ticketbioskop.userprofile;

import java.util.zip.Inflater;

public class Topup extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        EditText klmsaldo;
        Button btnTambah;
        DBDataSource dataSource;

        Button btnBack = findViewById(R.id.btn_back);
        klmsaldo = findViewById(R.id.kolom_saldo);
        //dataSource = new DBDataSource(this);
        //dataSource.open();

        btnTambah = (Button) findViewById(R.id.btn_nambah);

        btnTambah.setOnClickListener(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backProfile();
            }

            private void backProfile() {
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "saldo anda telah bertambah"  , Toast.LENGTH_LONG).show();
    }
}
