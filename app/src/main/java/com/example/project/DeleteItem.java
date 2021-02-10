package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DeleteItem extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);

            auth=FirebaseAuth.getInstance();
            final FirebaseFirestore db = FirebaseFirestore.getInstance();

            final EditText edx_itemd = findViewById(R.id.edx_itemd);
            Button btn_itemd= findViewById(R.id.btn_itemd);

        btn_itemd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.collection("Food Item").document(edx_itemd.getText().toString()).delete();
                    Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
            });


    }
}
