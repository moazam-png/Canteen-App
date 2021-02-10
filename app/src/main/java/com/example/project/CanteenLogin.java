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

public class CanteenLogin extends AppCompatActivity {

    private EditText edx_loginc, edx_passc;
    private Button btn_lcan;
    private ProgressBar progressBar2;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_login);

        edx_loginc = (EditText) findViewById(R.id.edx_loginc);
        edx_passc = (EditText) findViewById(R.id.edx_passc);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        btn_lcan = (Button) findViewById(R.id.btn_lcan);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btn_lcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edx_loginc.getText().toString();

                final String password = edx_passc.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar2.setVisibility(View.VISIBLE);
                if (email.contains("@Canteen.com")) {
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(CanteenLogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar2.setVisibility(View.GONE);
                                    if (!task.isSuccessful()) {
                                        if (password.length() < 6) {
                                            edx_passc.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(CanteenLogin.this, getString(R.string.auth_failed),
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        startActivity(new Intent(CanteenLogin.this, CanteenMain.class));

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

