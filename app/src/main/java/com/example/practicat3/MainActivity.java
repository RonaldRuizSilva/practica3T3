package com.example.practicat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//https://6298a8b7f2decf5bb74859ed.mockapi.io

    Button agregarLibro;
    RecyclerView reccycletView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarLibro = findViewById(R.id.agregarLibro);
        reccycletView = findViewById(R.id.reccycletView);
        reccycletView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        reccycletView.setLayoutManager(manager);


        agregarLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistrarLibroActivity.class);
                startActivity(intent);
            }
        });
    }
}