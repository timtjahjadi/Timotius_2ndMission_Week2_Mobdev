package com.example.a2ndmission_week2_mobdev;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailViewActivity extends AppCompatActivity {
    TextView name, age, address;
    Button btn_delete, btn_edit;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent i = getIntent();
        final String iName = i.getStringExtra("name");
        final int iAge = i.getIntExtra("age", 0);
        final String iAddress = i.getStringExtra("address");
        final int iPosition = i.getIntExtra("position", 0);

        name = findViewById(R.id.text_nameDetail);
        age = findViewById(R.id.text_ageDetail);
        address = findViewById(R.id.text_locationDetail);

        btn_delete = findViewById(R.id.button_delete);
        btn_edit = findViewById(R.id.button_edit);
        btn_back = findViewById(R.id.button_back_detail);

        name.setText(iName);
        age.setText(String.valueOf(iAge));
        address.setText(iAddress);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DetailViewActivity.this);
                alertDialogBuilder.setTitle("Confirm Delete");

                alertDialogBuilder
                        .setMessage("Are you sure?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("Delete",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                getSetUser.items.remove(iPosition);

                                Toast.makeText(DetailViewActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(DetailViewActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailViewActivity.this, AddAndEditActivity.class);
                intent.putExtra("name", iName);
                intent.putExtra("age", iAge);
                intent.putExtra("address", iAddress);
                intent.putExtra("position", iPosition);
                intent.putExtra("from", false);
                startActivity(intent);
            }
        });
    }
}