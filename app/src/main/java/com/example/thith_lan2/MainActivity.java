package com.example.thith_lan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText pl_pass,pl_email;
    Button btnDangNhap;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        pl_pass = findViewById(R.id.pl_pass);
        pl_email = findViewById(R.id.pl_email);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = pl_email.getText().toString();
                String password = pl_pass.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ các ô", Toast.LENGTH_SHORT).show();
                else
                    Dangnhap(email,password);

            }
        });
    }

    private void Dangnhap(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=  new Intent(MainActivity.this,Action.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}