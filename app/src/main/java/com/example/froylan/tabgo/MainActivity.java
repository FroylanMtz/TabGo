package com.example.froylan.tabgo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void ejecutar_inicio(View view){

        Intent i = new Intent(this, Inicio.class);

        startActivity(i);

    }

}
