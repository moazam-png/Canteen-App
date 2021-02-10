package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity {
    private EditText edx_logina, edx_passa;
    private Button btn_adminl;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        edx_logina = (EditText) findViewById(R.id.edx_logina);
        edx_passa = (EditText) findViewById(R.id.edx_passa);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn_adminl = (Button) findViewById(R.id.btn_adminl);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btn_adminl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edx_logina.getText().toString();

                final String password = edx_passa.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                if (email.contains("moazamb40@gmail.com")) {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(AdminLogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (!task.isSuccessful()) {
                                        if (password.length() < 6) {
                                            edx_passa.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(AdminLogin.this, getString(R.string.auth_failed),
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        startActivity(new Intent(AdminLogin.this, AdminMain.class));

                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Invaild Email Domain", Toast.LENGTH_SHORT).show();
                }// end of onclick
            }
        }); // end of signin
    }
}
