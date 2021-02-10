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

public class ViewCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_canteen);

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("canteen").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<String> canteenList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                canteenList.add("Name: " +document.get("name" ) + "Email: " + document.get("email" ) + "Password: " + document.get("password" ) + "Mobile: " + document.get("mobile" ) + "Address: " + document.get("address" ) + "Amount: " + document.get("amount" ));
                            }
                            ListView listV=findViewById(R.id.listC);
                            ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.lay, canteenList);
                            listV.setAdapter(adapter);
                        }
                    }
                });
    }
}
