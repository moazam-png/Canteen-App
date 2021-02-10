package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class WithDrawCanteen extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_draw_canteen);

        auth=FirebaseAuth.getInstance();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final EditText edx_wcanteen = findViewById(R.id.edx_wcanteen);
        Button btn_wcanteen= findViewById(R.id.btn_wcanteen);

        btn_wcanteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("canteen").document(edx_wcanteen.getText().toString()).delete();
                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
