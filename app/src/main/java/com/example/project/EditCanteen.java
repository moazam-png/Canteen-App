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
import com.google.firebase.firestore.FirebaseFirestore;

public class EditCanteen extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_canteen);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final EditText edx_updatec = findViewById(R.id.edx_updatec);
        final EditText edx_updateh = findViewById(R.id.edx_updateh);
        final EditText edx_updatew = findViewById(R.id.edx_updatew);
        final  EditText edx_updatem = findViewById(R.id.edx_updatem);
        Button btn_updatei = findViewById(R.id.btn_updatei);

        btn_updatei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("canteen").document(edx_updatec.getText().toString().trim()).update("name", edx_updateh.getText().toString().trim(), "mobile", edx_updatew.getText().toString().trim(),"address",edx_updatem.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
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
