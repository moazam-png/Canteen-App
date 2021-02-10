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

public class CanteenBalDrawTrans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_bal_draw_trans);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("WithDraw Transactions Canteen").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<String> transactionList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                transactionList.add("Old amount: " + document.get("oldamount") + "New amount: " + document.get("newamount") + "Total amount: " + document.get("totalamount"));

                            }
                            ListView transview = findViewById(R.id.transview);
                            ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.lay, transactionList);
                            transview.setAdapter(adapter);
                            transview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                                }
                            });
                        }
                    }
                });
    }
}