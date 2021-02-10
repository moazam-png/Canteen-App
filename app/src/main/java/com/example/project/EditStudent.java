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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditStudent extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final EditText edx_updates = findViewById(R.id.edx_updates);
        final EditText edx_updatepp = findViewById(R.id.edx_updatepp);
        final EditText edx_updatepp2 = findViewById(R.id.edx_updatepp2);
        final Button btn_updatep = findViewById(R.id.btn_updatep);

        btn_updatep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("student").document(edx_updates.getText().toString().trim()).update("name", edx_updatepp.getText().toString().trim(), "id", edx_updatepp2.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
