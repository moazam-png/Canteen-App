package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Additem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final EditText edx_itemn = findViewById(R.id.edx_itemn);
        final EditText edx_description = findViewById(R.id.edx_description);
        final EditText edx_cost = findViewById(R.id.edx_cost);
        final EditText edx_status = findViewById(R.id.edx_status);
        Button btn_sadd = findViewById(R.id.btn_addi);


        btn_sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("name", edx_itemn.getText().toString().trim());
                user.put("description", edx_description.getText().toString().trim());
                user.put("cost", edx_cost.getText().toString().trim());
                user.put("status", edx_status.getText().toString().trim());
                db.collection("Food Item").document(String.valueOf(edx_itemn.getText())).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Not Added",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
