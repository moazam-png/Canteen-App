package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button btn_logina = (Button) findViewById(R.id.btn_logina);
        Button btn_loginc = (Button) findViewById(R.id.btn_loginc);
        Button btn_logins = (Button) findViewById(R.id.btn_logins);
        // Firebase Instance

        btn_logina.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i_a = new Intent(getApplicationContext(), AdminLogin.class);
                startActivity(i_a);
            }
        });
        btn_loginc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i_c = new Intent(getApplicationContext(), CanteenLogin.class);
                startActivity(i_c);
            }
        });
        btn_logins.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i_s = new Intent(getApplicationContext(), StudentLogin.class);
                startActivity(i_s);
            }
        });

    }
}
