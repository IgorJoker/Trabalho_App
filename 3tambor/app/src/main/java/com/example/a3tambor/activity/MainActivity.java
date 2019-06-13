package com.example.a3tambor.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3tambor.R;

public class MainActivity extends AppCompatActivity {
    private Button Button_com;
    private Button Button_pass;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button_com = findViewById(R.id.button_com);
        Button_pass = findViewById(R.id.button_pass);

        Button_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, AdicionarCompetidorActivity.class);
                startActivity(intent);
            }
        });
        Button_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, PassadaActivity.class);
                startActivity(intent);
            }
        });

    }
}
