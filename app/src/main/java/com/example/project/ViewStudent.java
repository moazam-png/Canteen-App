package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("student").get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<String> studentNameList = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        studentNameList.add("Name: " + document.get("name") + "Id: " + document.get("id") + "Email: " + document.get("email") + "Password: " + document.get("password") + "Balance: " + document.get("balance"));
                    }

                    ListView listV=findViewById(R.id.listS);
                    ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.lay, studentNameList);
                    listV.setAdapter(adapter);
                }
            }
        });
    }
}
