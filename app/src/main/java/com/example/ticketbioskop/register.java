package com.example.ticketbioskop;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import android.os.Bundle;

import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {

    EditText tUsername, tEmail, tPassword, tConfirmPassword;
    Button tombolRegis;
    TextView tombolLogin;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        tUsername = findViewById(R.id.txt_username);
        tEmail = findViewById(R.id.txt_email);
        tPassword = findViewById(R.id.txt_password);
        tConfirmPassword = findViewById(R.id.txt_confirm_password);
        tombolRegis = findViewById(R.id.btn_register);
        tombolLogin = findViewById(R.id.jump_login);

        firebaseAuth =  FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if (firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        }

        tombolLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        tombolRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tEmail.getText().toString().trim();
                String password = tPassword.getText().toString().trim();
                String confPass = tConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    tEmail.setError("Email harus di isi!!");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    tPassword.setError("Password harus di isi!!");
                    return;
                }
                if (password.length() < 7){
                    tPassword.setError("Password minimal harus 8 karakter atau lebih");
                    return;
                }
                if (!password.equals(confPass)){
                    tConfirmPassword.setError("Konfirmasi Password salah!!");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(register.this, "Akun telah dibuat", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }else{
                            Toast.makeText(register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        Toast.makeText(register.this, "Masukkan Email dan Password!!", Toast.LENGTH_LONG).show();
    }
}