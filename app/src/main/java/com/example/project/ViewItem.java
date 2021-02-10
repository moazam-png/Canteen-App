package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ViewItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Food Item").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<String> foodItemList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                foodItemList.add("Item Name: " +document.get("name" ) + "Cost: " + document.get("cost" ));

                            }
                            ListView listV=findViewById(R.id.listi);
                            ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.lay, foodItemList);
                            listV.setAdapter(adapter);
                            listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                }
                            });
                        }
                    }
                });
    }
}
