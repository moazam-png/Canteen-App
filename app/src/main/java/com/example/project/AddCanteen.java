package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddCanteen extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_canteen);
        auth=FirebaseAuth.getInstance();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final EditText edx_cname = findViewById(R.id.edx_cname);
        final EditText edx_cemail = findViewById(R.id.edx_cemail);
        final EditText edx_cpass = findViewById(R.id.edx_cpass);
        final EditText edx_cmobile = findViewById(R.id.edx_cmobile);
        final EditText edx_caddress = findViewById(R.id.edx_caddress);
        final EditText edx_camount = findViewById(R.id.edx_camount);
        Button btn_cadd = findViewById(R.id.btn_cadd);

        btn_cadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("name", edx_cname.getText().toString().trim());
                user.put("email", edx_cemail.getText().toString().trim());
                user.put("password",edx_cpass.getText().toString().trim());
                user.put("mobile", edx_cmobile.getText().toString().trim());
                user.put("address", edx_caddress.getText().toString().trim());
                user.put("amount",edx_camount.getText().toString().trim());


                db.collection("canteen").document(String.valueOf(edx_cemail.getText())).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        auth.createUserWithEmailAndPassword(edx_cemail.getText().toString().trim(),edx_cpass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Not Added ",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
