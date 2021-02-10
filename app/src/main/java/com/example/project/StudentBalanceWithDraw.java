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

import java.util.HashMap;
import java.util.Map;

public class StudentBalanceWithDraw extends AppCompatActivity {

    private int sum;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_balance_with_draw);

        sum=0;

        final FirebaseFirestore db=FirebaseFirestore.getInstance();

        final EditText edx_enid =  findViewById(R.id.edx_enid);
        final EditText edx_enbal = findViewById(R.id.edx_enbal);
        Button btn_drawbal = findViewById(R.id.btn_drawbal);
        Button btn_drawbal2 = findViewById(R.id.btn_drawbal2);

        btn_drawbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("student").document(edx_enid.getText().toString().trim()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot doc = task.getResult();
                            int oldamount = 0;
                            if (doc.exists()) {
                                oldamount = Integer.parseInt(String.valueOf(doc.get("balance")));
                                final int newAmount = Integer.parseInt(edx_enbal.getText().toString());
                                final int currentAmount = oldamount - newAmount;
                                final int finalOldamount = oldamount;
                                db.collection("student").document(edx_enid.getText().toString().trim()).update("balance", String.valueOf(currentAmount)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        Map<Object,String> transac=new HashMap<>();
                                        transac.put("oldamount",String.valueOf(finalOldamount));
                                        transac.put("newamount",String.valueOf(newAmount));
                                        transac.put("totalamount",String.valueOf(currentAmount));
                                        db.collection("WithDraw Transactions Canteen").document().set(transac);

                                        Toast.makeText(getApplicationContext(), "WithDraw Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), "UnSuccessful", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });
        btn_drawbal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("canteen").document(edx_enid.getText().toString().trim()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot doc = task.getResult();
                            int oldamount = 0;
                            if (doc.exists()) {
                                oldamount = Integer.parseInt(String.valueOf(doc.get("amount")));
                                final int newAmount = Integer.parseInt(edx_enbal.getText().toString());
                                final int currentAmount = oldamount - newAmount;
                                final int finalOldamount = oldamount;
                                db.collection("canteen").document(edx_enid.getText().toString().trim()).update("amount", String.valueOf(currentAmount)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        Map<Object,String> transac=new HashMap<>();
                                        transac.put("oldamount",String.valueOf(finalOldamount));
                                        transac.put("newamount",String.valueOf(newAmount));
                                        transac.put("totalamount",String.valueOf(currentAmount));
                                        db.collection("WithDraw Transactions Canteen").document().set(transac);

                                        Toast.makeText(getApplicationContext(), "WithDraw Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), "UnSuccessful", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });
    }
}
