package com.example.a2ndmission_week2_mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AddAndEditActivity extends AppCompatActivity {

    Button add_button;
    ImageButton btn_back;
    EditText editName, editAge, editAddress;
    String _name, _age, _address;
    TextView title;
    User user;
    Boolean isAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_and_editing);

        Intent i = getIntent();
        final String iName = i.getStringExtra("name");
        final int iAge = i.getIntExtra("age", 0);
        final String iAddress = i.getStringExtra("address");
        final int iPosition = i.getIntExtra("position", 0);
        isAdd = i.getBooleanExtra("from", true);

        add_button = findViewById(R.id.button_edit_add);
        editName = findViewById(R.id.editText_name);
        editAge = findViewById(R.id.editText_age);
        editAddress = findViewById(R.id.editText_address);
        btn_back = findViewById(R.id.button_back_edit);
        title = findViewById(R.id.text_titleEdit);

        if (isAdd) {
            title.setText("Add New User");
            add_button.setText("Add Data");
        }
        else {
            title.setText("Update User Data");
            add_button.setText("Update Data");
        }

        editName.setText(iName);
        if (isAdd == false) {
            editAge.setText(String.valueOf(iAge));
        }
        editAddress.setText(iAddress);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _name = editName.getText().toString().trim();
                _age = editAge.getText().toString().trim();
                _address = editAddress.getText().toString().trim();

                if (isAdd) {
                    if (TextUtils.isEmpty(_name) || TextUtils.isEmpty(_age) || TextUtils.isEmpty(_address)) {
                        Toast.makeText(AddAndEditActivity.this, "Isi semua field dulu dong bang!", Toast.LENGTH_SHORT).show();
                    } else {
                        user = new User(_name, Integer.parseInt(_age), _address);
                        insert_data();

                        Toast.makeText(AddAndEditActivity.this, "Data Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AddAndEditActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                else {
                    if (TextUtils.isEmpty(_name) || TextUtils.isEmpty(_age) || TextUtils.isEmpty(_address)) {
                        Toast.makeText(AddAndEditActivity.this, "Jangan dikosongin dong bang!", Toast.LENGTH_SHORT).show();
                    } else {
                        user = new User(_name, Integer.parseInt(_age), _address);
                        getSetUser.items.set(iPosition, user);

                        Toast.makeText(AddAndEditActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AddAndEditActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void insert_data() {
        getSetUser.items.add(user);
    }

}

