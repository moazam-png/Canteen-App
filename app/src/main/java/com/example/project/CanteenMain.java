package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CanteenMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_main);

        Button btn_addi = findViewById(R.id.btn_addi);
        Button btn_viewi = findViewById(R.id.btn_viewi);
        Button btn_deletei = findViewById(R.id.btn_deletei);
        Button btn_updatei = findViewById(R.id.btn_updatei);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_transaction = findViewById(R.id.btn_transaction);
        Button btn_balance = findViewById(R.id.btn_balance);
        Button btn_withdraw = findViewById(R.id.btn_withdraw);
        Button btn_wtransaction = findViewById(R.id.btn_wtransaction);
        Button btn_status = findViewById(R.id.btn_status);

        btn_addi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_add = new Intent(getApplicationContext(), Additem.class);
                startActivity(intent_add);
            }
        });
        btn_viewi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_view = new Intent(getApplicationContext(), ViewItem.class);
                startActivity(intent_view);
            }
        });
        btn_deletei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_delete = new Intent(getApplicationContext(), DeleteItem.class);
                startActivity(intent_delete);
            }
        });
        btn_updatei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_edit = new Intent(getApplicationContext(), UpdateItem.class);
                startActivity(intent_edit);
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_view = new Intent(getApplicationContext(), ViewOrder.class);
                startActivity(intent_view);
            }
        });
        btn_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_transaction = new Intent(getApplicationContext(), Transaction.class);
                startActivity(intent_transaction);
            }
        });
        btn_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_balance = new Intent(getApplicationContext(), CanteenBalanceAdd.class);
                startActivity(intent_balance);
            }
        });
        btn_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_withdraw = new Intent(getApplicationContext(), CanteenBalanceWithDraw.class);
                startActivity(intent_withdraw);
            }
        });
        btn_wtransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dtrans = new Intent(getApplicationContext(), CanteenBalDrawTrans.class);
                startActivity(intent_dtrans);
            }
        });
        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_st = new Intent(getApplicationContext(), UpdateStatus.class);
                startActivity(intent_st);
            }
        });
    }
}
