package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        Button btn_adds = findViewById(R.id.btn_adds);
        Button btn_views = findViewById(R.id.btn_views);
        Button btn_deletes = findViewById(R.id.btn_deletes);
        Button btn_edits = findViewById(R.id.btn_edits);
        Button btn_addc = findViewById(R.id.btn_addi);
        Button btn_viewc = findViewById(R.id.btn_viewi);
        Button btn_deletec = findViewById(R.id.btn_deletei);
        Button btn_editc = findViewById(R.id.btn_editc);
        Button btn_addb = findViewById(R.id.btn_addb);
        Button btn_withdrawb = findViewById(R.id.btn_withdrawb);

        btn_adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_add = new Intent(getApplicationContext(), AddStudent.class);
                startActivity(i_add);
            }
        });
        btn_views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_view = new Intent(getApplicationContext(), ViewStudent.class);
                startActivity(i_view);
            }
        });
        btn_deletes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_delete = new Intent(getApplicationContext(), WithDrawStudent.class);
                startActivity(i_delete);
            }
        });
        btn_edits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_edit = new Intent(getApplicationContext(), EditStudent.class);
                startActivity(i_edit);
            }
        });
        btn_addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_addc = new Intent(getApplicationContext(), AddCanteen.class);
                startActivity(i_addc);
            }
        });
        btn_viewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_views = new Intent(getApplicationContext(), ViewCanteen.class);
                startActivity(i_views);
            }
        });
        btn_deletec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_deletec = new Intent(getApplicationContext(), WithDrawCanteen.class);
                startActivity(i_deletec);
            }
        });
        btn_editc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_editc = new Intent(getApplicationContext(), EditCanteen.class);
                startActivity(i_editc);
            }
        });
        btn_addb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_addb = new Intent(getApplicationContext(), AddBalance.class);
                startActivity(i_addb);
            }
        });
        btn_withdrawb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_withdrawb = new Intent(getApplicationContext(), WIthDrawBalance.class);
                startActivity(i_withdrawb);
            }
        });




    }
}
