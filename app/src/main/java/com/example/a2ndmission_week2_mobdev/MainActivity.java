package com.example.a2ndmission_week2_mobdev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemAdapter.OnItemListener {

    private RecyclerView _RecyclerView;
    itemAdapter _adapter;
    ArrayList<User> items;
    FloatingActionButton button_add;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _RecyclerView = findViewById(R.id.recyclerView);

        loadUsers();

//        items.add(new User("Tim", 21, "Indonesia"));
//
        showUsers();

        button_add = findViewById(R.id.button_floating_to_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAndEditActivity.class);
                intent.putExtra("from", true);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void loadUsers() {
        items = getSetUser.items;
    }

    public void showUsers() {
        _RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        _adapter = new itemAdapter(this, items, this);
        _RecyclerView.setAdapter(_adapter);
    }

    @Override
    public void onItemClicked(int position) {

        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("name", items.get(position).get_Name());
        intent.putExtra("age", items.get(position).get_age());
        intent.putExtra("address", items.get(position).get_Address());
        intent.putExtra("position", position);
        startActivity(intent);
    }
}