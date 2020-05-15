package com.example.ticketbioskop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText tEmail, tPassword;
    Button tombolLogin;
    TextView tombolSignup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        tEmail = findViewById(R.id.isi_email);
        tPassword = findViewById(R.id.isi_password);
        tombolSignup = findViewById(R.id.jump_signup);
        tombolLogin = findViewById(R.id.tombol_login);
        firebaseAuth = FirebaseAuth.getInstance();

        tombolLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tEmail.getText().toString().trim();
                String password = tPassword.getText().toString().trim();

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

                //Authentication user

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Berhasil Login!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        tombolSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegis();
            }
        });
    }

    private void openRegis() {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

        Toast.makeText(LoginActivity.this, "Lakukan Pendaftaran", Toast.LENGTH_LONG).show();
    }
}
