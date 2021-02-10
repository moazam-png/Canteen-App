package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaceOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        final FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Food Item").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            ArrayList<String> menuList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                menuList.add("Item Name: " +document.get("name" ) + "Description: " + document.get("description" ) + "Cost: " + document.get("cost" ) + "Status: " + document.get("status"));
                            }
                            final ListView listplace=findViewById(R.id.listplace);
                            ArrayAdapter adapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.lay, menuList);
                            listplace.setAdapter(adapter);
                            listplace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    Map<Object,String> orders=new HashMap<>();
                                    orders.put("order",String.valueOf(listplace).trim());

                                    db.collection("Orders").document().set(orders);
                                    Toast.makeText(getApplicationContext(), "Order placed", Toast.LENGTH_LONG).show();

                                }
                            });
                        }
                    }
                });
    }
}
