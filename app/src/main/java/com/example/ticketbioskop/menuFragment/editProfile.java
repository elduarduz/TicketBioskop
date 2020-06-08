package com.example.ticketbioskop.menuFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticketbioskop.Home;
import com.example.ticketbioskop.R;
import com.example.ticketbioskop.register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class editProfile extends AppCompatActivity {

    EditText ePassword, eConfirmPassword;
    Button tombolConfirm;
    Button kembali;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        ePassword = findViewById(R.id.txt_password);
        eConfirmPassword = findViewById(R.id.txt_confirm_password);
        tombolConfirm = findViewById(R.id.btn_confirm);
        kembali = findViewById(R.id.btn_kembali);


        tombolConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ePassword.getText().toString().trim();
                String confPass = eConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(password)){
                    ePassword.setError("Password harus di isi!!");
                    return;
                }
                if (password.length() < 7){
                    ePassword.setError("Password minimal harus 8 karakter atau lebih");
                    return;
                }
                if (!password.equals(confPass)){
                    eConfirmPassword.setError("Konfirmasi Password salah!!");
                    return;
                }

                user.updatePassword(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(editProfile.this, "Akun Telah Dibuat!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }
                        else {
                            Toast.makeText(editProfile.this, "Error!" + task.getException() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backProfile();
            }

            private void backProfile() {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });
    }

    }
