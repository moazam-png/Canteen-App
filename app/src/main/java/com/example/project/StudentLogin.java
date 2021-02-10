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

public class StudentLogin extends AppCompatActivity {

    private EditText edx_logins, edx_passs;
    private Button btn_studentl;
    private ProgressBar progressBar3;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        edx_logins = (EditText) findViewById(R.id.edx_logins);
        edx_passs = (EditText) findViewById(R.id.edx_passs);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        btn_studentl = (Button) findViewById(R.id.btn_studentl);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btn_studentl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edx_logins.getText().toString();

                final String password = edx_passs.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar3.setVisibility(View.VISIBLE);
                if (email.contains("@Student.com")) {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(StudentLogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar3.setVisibility(View.GONE);
                                    if (!task.isSuccessful()) {
                                        if (password.length() < 6) {
                                            edx_passs.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(StudentLogin.this, getString(R.string.auth_failed),
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        startActivity(new Intent(StudentLogin.this, StudentMain.class));

                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Email Domain", Toast.LENGTH_SHORT).show();
                }// end of onclick
            }
        }); // end of signin
    }
}
