package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        Button btn_menuv = findViewById(R.id.btn_menuv);
        Button btn_bal = findViewById(R.id.btn_bal);
        Button btn_draw = findViewById(R.id.btn_draw);
        Button btn_order = findViewById(R.id.btn_order);
        Button btn_trans = findViewById(R.id.btn_trans);
        Button btn_transs = findViewById(R.id.btn_transs);

        btn_menuv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_menu = new Intent(getApplicationContext(), ViewMenu.class);
                startActivity(intent_menu);
            }
        });
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vr = new Intent(getApplicationContext(), ViewOrder.class);
                startActivity(intent_vr);
            }
        });
        btn_bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_bal = new Intent(getApplicationContext(), StudentBalanceAdd.class);
                startActivity(intent_bal);
            }
        });
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_draw = new Intent(getApplicationContext(), StudentBalanceWithDraw.class);
                startActivity(intent_draw);
            }
        });
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_order = new Intent(getApplicationContext(), PlaceOrder.class);
                startActivity(intent_order);
            }
        });

        btn_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tr = new Intent(getApplicationContext(), StudentAddBalTrans.class);
                startActivity(intent_tr);
            }
        });
        btn_transs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_trs = new Intent(getApplicationContext(), StudentDrawBalTrans.class);
                startActivity(intent_trs);
            }
        });
    }
}
